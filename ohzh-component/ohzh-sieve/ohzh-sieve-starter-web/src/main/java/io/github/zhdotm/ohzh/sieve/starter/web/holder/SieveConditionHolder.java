package io.github.zhdotm.ohzh.sieve.starter.web.holder;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import net.sf.jsqlparser.expression.Expression;

import java.util.List;
import java.util.Map;

/**
 * @author zhihao.mao
 */

public class SieveConditionHolder {

    private static final ThreadLocal<Map<String, Expression>> CONDITION_MAP_THREAD_LOCAL = ThreadLocal.withInitial(MapUtil::newHashMap);

    public static Map<String, Expression> getConditionMap() {

        return CONDITION_MAP_THREAD_LOCAL.get();
    }

    public static Expression getExpression(String tableName) {

        return getConditionMap().get(tableName);
    }

    public static List<String> getTableNames() {

        return ListUtil.list(Boolean.FALSE, getConditionMap().keySet());
    }

    public static void addCondition(String tableName, Expression expression) {

        getConditionMap().put(tableName, expression);
    }

    public static void clear() {

        CONDITION_MAP_THREAD_LOCAL.remove();
    }
}
