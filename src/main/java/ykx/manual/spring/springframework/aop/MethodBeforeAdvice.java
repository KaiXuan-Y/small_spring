package ykx.manual.spring.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author yangkaixuan
 */
public interface MethodBeforeAdvice extends BeforeAdvice{

    void before(Method method, Object[] args, Object target) throws Throwable;
}
