package io.github.zhdotm.ohzh.cqrs.starter.web;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.extra.spring.SpringUtil;
import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.cqrs.core.exception.CQRSException;
import io.github.zhdotm.ohzh.cqrs.starter.web.enums.CQRSExceptionEnum;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.ICommandExecutor;
import io.github.zhdotm.ohzh.cqrs.starter.web.executor.IQueryExecutor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * CQRS执行器工厂
 *
 * @author zhihao.mao
 */

@Slf4j
public class CQRSExecutorFactory {

    /**
     * 注册查询执行器
     *
     * @param name     执行器名称
     * @param queryExe 执行器
     */
    @SneakyThrows
    public static void registerQueryExecutor(String name, IQueryExecutor queryExe) {

        SpringUtil.registerBean(name, queryExe);
    }

    /**
     * 注册命令执行器
     *
     * @param name   执行器名称
     * @param cmdExe 执行器
     */
    @SneakyThrows
    public static void registerCommandExecutor(String name, ICommandExecutor cmdExe) {

        SpringUtil.registerBean(name, cmdExe);
    }

    /**
     * 获取命令执行器
     *
     * @param bizScenario 业务身份
     * @param cmdExeClazz 命令执行器类型
     * @param <T>         命令执行器类型
     * @return 命令执行器
     */
    @SneakyThrows
    public static <T extends ICommandExecutor> T getCommandExecutor(BizScenario bizScenario, Class<T> cmdExeClazz) {
        Collection<T> cmdExes = SpringUtil
                .getBeansOfType(cmdExeClazz)
                .values();

        List<T> matchedCmdExes = cmdExes
                .stream()
                .filter(cmdExe -> cmdExe.strictMatch(bizScenario))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(matchedCmdExes)) {
            Assert.isTrue(matchedCmdExes.size() == 1, (Supplier<Throwable>) () -> new CQRSException(CQRSExceptionEnum.COMMAND_EXECUTOR_STRICT_MATCH_MANY.getCode(), CQRSExceptionEnum.COMMAND_EXECUTOR_STRICT_MATCH_MANY.getMessage(bizScenario)));
            T matchedCmdExe = matchedCmdExes.get(0);

            log.info("严格匹配到命令执行器[{}]: {}", bizScenario, matchedCmdExe.getCode());
            return matchedCmdExe;
        }

        matchedCmdExes = cmdExes.stream()
                .filter(cmdExe -> cmdExe.looseMatch(bizScenario))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(matchedCmdExes)) {
            Assert.isTrue(matchedCmdExes.size() == 1, (Supplier<Throwable>) () -> new CQRSException(CQRSExceptionEnum.COMMAND_EXECUTOR_LOOSE_MATCH_MANY.getCode(), CQRSExceptionEnum.COMMAND_EXECUTOR_LOOSE_MATCH_MANY.getMessage(bizScenario)));
            T matchedCmdExe = matchedCmdExes.get(0);

            log.info("松散匹配到命令执行器[{}]: {}", bizScenario, matchedCmdExe.getCode());
            return matchedCmdExe;
        }

        throw new CQRSException(CQRSExceptionEnum.COMMAND_EXECUTOR_NOT_MATCH.getCode(), CQRSExceptionEnum.COMMAND_EXECUTOR_NOT_MATCH.getMessage(bizScenario));
    }

    /**
     * 获取查询执行器
     *
     * @param bizScenario   业务身份
     * @param queryExeClazz 查询执行器类型
     * @param <T>           查询执行器类型
     * @return 查询执行器
     */
    @SneakyThrows
    public static <T extends IQueryExecutor> T getQueryExecutor(BizScenario bizScenario,
                                                                Class<T> queryExeClazz) {
        Collection<T> queryExes = SpringUtil
                .getBeansOfType(queryExeClazz)
                .values();

        List<T> matchedQueryExes = queryExes
                .stream()
                .filter(queryExe -> queryExe.strictMatch(bizScenario))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(matchedQueryExes)) {
            Assert.isTrue(matchedQueryExes.size() == 1, (Supplier<Throwable>) () -> new CQRSException(CQRSExceptionEnum.QUERY_EXECUTOR_STRICT_MATCH_MANY.getCode(), CQRSExceptionEnum.QUERY_EXECUTOR_STRICT_MATCH_MANY.getMessage(bizScenario)));
            T matchedQueryExe = matchedQueryExes.get(0);
            log.info("严格匹配到查询执行器[{}]: {}", bizScenario, matchedQueryExe.getCode());

            return matchedQueryExe;
        }

        matchedQueryExes = queryExes.stream()
                .filter(queryExe -> queryExe.looseMatch(bizScenario))
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(matchedQueryExes)) {
            Assert.isTrue(matchedQueryExes.size() == 1, (Supplier<Throwable>) () -> new CQRSException(CQRSExceptionEnum.QUERY_EXECUTOR_LOOSE_MATCH_MANY.getCode(), CQRSExceptionEnum.QUERY_EXECUTOR_LOOSE_MATCH_MANY.getMessage(bizScenario)));
            T matchedQueryExe = matchedQueryExes.get(0);
            log.info("松散匹配到查询执行器[{}]: {}", bizScenario, matchedQueryExe.getCode());

            return matchedQueryExe;
        }

        throw new CQRSException(CQRSExceptionEnum.QUERY_EXECUTOR_NOT_MATCH.getCode(), CQRSExceptionEnum.QUERY_EXECUTOR_NOT_MATCH.getMessage(bizScenario));
    }

}
