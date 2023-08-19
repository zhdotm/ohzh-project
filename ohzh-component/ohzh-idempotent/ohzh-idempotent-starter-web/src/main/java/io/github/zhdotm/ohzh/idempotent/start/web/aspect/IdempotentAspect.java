package io.github.zhdotm.ohzh.idempotent.start.web.aspect;

import io.github.zhdotm.ohzh.idempotent.core.annotation.Idempotent;
import io.github.zhdotm.ohzh.idempotent.core.getter.IIdempotentKeyGetter;
import io.github.zhdotm.ohzh.idempotent.core.handler.IIdempotentHandler;
import io.github.zhdotm.ohzh.idempotent.core.model.IdempotentPoint;
import io.github.zhdotm.ohzh.idempotent.start.web.manager.ISpringIdempotentManager;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author zhihao.mao
 */

@Aspect
@AllArgsConstructor
public class IdempotentAspect {

    private final ISpringIdempotentManager idempotentManager;

    @Pointcut("@annotation(io.github.zhdotm.ohzh.idempotent.core.annotation.Idempotent)")
    public void idempotentPointcut() {
    }

    @SneakyThrows
    @Around("idempotentPointcut() && @annotation(idempotent)")
    public Object idempotentAround(ProceedingJoinPoint pjp, Idempotent idempotent) {
        MethodInvocationProceedingJoinPoint methodPjp = (MethodInvocationProceedingJoinPoint) pjp;
        String keyGetterName = idempotent.keyGetterName();
        IIdempotentKeyGetter keyGetter = idempotentManager.getKeyGetter(keyGetterName);
        String handlerName = idempotent.handlerName();
        IIdempotentHandler handler = idempotentManager.getHandler(handlerName);
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        IdempotentPoint idempotentPoint = IdempotentPoint.create(idempotent.bizId(), methodPjp.getTarget(), method, methodPjp.getArgs(), idempotent.keyExpressionText(), keyGetter, idempotent.expire());

        return handler.handle(idempotentPoint);
    }

}
