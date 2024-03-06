package ykx.manual.spring.springframework.aop.framework.autoproxy;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import ykx.manual.spring.springframework.aop.*;
import ykx.manual.spring.springframework.aop.framework.ProxyFactory;
import ykx.manual.spring.springframework.beans.factory.BeanFactory;
import ykx.manual.spring.springframework.beans.factory.BeanFactoryAware;
import ykx.manual.spring.springframework.beans.factory.PropertyValues;
import ykx.manual.spring.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;
import ykx.manual.spring.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * @author yangkaixuan
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private DefaultListableBeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansCreateException {
       if (isInfrastructureClass(beanClass)){
           return null;
       }
       Collection<AspectJExpressionPointCutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointCutAdvisor.class).values();
        for (AspectJExpressionPointCutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointCut().getClassFilter();
            if (!classFilter.matches(beanClass)) {
                continue;
            }
            AdvisedSupport advisedSupport = new AdvisedSupport();
            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setProxyTargetClass(true);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointCut().getMethodMatcher());
            return new ProxyFactory(advisedSupport).getProxy();


        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansCreateException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansCreateException {
        return bean;
    }



    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansCreateException {
        return pvs;
    }

    private boolean isInfrastructureClass(Class<?> beanClass){
        return Advice.class.isAssignableFrom(beanClass) || PointCut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }
}
