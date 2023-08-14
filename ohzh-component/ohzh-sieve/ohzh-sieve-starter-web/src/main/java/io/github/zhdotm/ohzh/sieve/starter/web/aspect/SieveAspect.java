package io.github.zhdotm.ohzh.sieve.starter.web.aspect;

import cn.hutool.core.collection.CollectionUtil;
import io.github.zhdotm.ohzh.sieve.core.annotation.Sieve;
import io.github.zhdotm.ohzh.sieve.core.annotation.Sieves;
import io.github.zhdotm.ohzh.sieve.core.getter.IValueGetter;
import io.github.zhdotm.ohzh.sieve.core.getter.impl.EqualToExpressionGetterImpl;
import io.github.zhdotm.ohzh.sieve.core.getter.impl.ExpressionTextGetterImpl;
import io.github.zhdotm.ohzh.sieve.core.getter.impl.InExpressionGetterImpl;
import io.github.zhdotm.ohzh.sieve.starter.web.holder.SieveConditionHolder;
import io.github.zhdotm.ohzh.sieve.starter.web.manager.ISpringValueGetterManager;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.sf.jsqlparser.expression.Expression;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

/**
 * @author zhihao.mao
 */

@AllArgsConstructor
@Aspect
public class SieveAspect {

    private final ISpringValueGetterManager springValueGetterManager;

    @Pointcut("@annotation(io.github.zhdotm.ohzh.sieve.core.annotation.Sieves)")
    public void sievesPointcut() {
    }

    @Pointcut("@annotation(io.github.zhdotm.ohzh.sieve.core.annotation.Sieve)")
    public void sievePointcut() {
    }

    @SneakyThrows
    @Around("sievePointcut() && @annotation(sieve)")
    public Object sieveAround(ProceedingJoinPoint pjp, Sieve sieve) {

        addCondition(sieve);
        Object proceed = pjp.proceed(pjp.getArgs());
        clearConditions();

        return proceed;
    }

    @SneakyThrows
    @Around("sievesPointcut() && @annotation(sieves)")
    public Object sievesAround(ProceedingJoinPoint pjp, Sieves sieves) {

        addConditions(sieves);
        Object proceed = pjp.proceed(pjp.getArgs());
        clearConditions();

        return proceed;
    }

    private void addCondition(Sieve sieve) {
        String tableName = sieve.tableName();
        String columnName = sieve.columnName();
        String valueGetterName = sieve.valueGetterName();
        IValueGetter valueGetter = springValueGetterManager.getValueGetter(valueGetterName);
        List<String> values = valueGetter.get();
        Expression expression;
        if (CollectionUtil.isEmpty(values)) {
            expression = new ExpressionTextGetterImpl(" 1 != 1 ")
                    .getExpression();
        } else if (values.size() == 1) {
            expression = new EqualToExpressionGetterImpl(tableName, columnName, values.get(0))
                    .getExpression();
        } else {
            expression = new InExpressionGetterImpl(tableName, columnName, values)
                    .getExpression();
        }

        SieveConditionHolder.addCondition(tableName, expression);
    }

    private void addConditions(Sieves sieves) {
        for (Sieve sieve : sieves.sieves()) {
            addCondition(sieve);
        }
    }

    private void clearConditions() {
        SieveConditionHolder.clear();
    }

}
