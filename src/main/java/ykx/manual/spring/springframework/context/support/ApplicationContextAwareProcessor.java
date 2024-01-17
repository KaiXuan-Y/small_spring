package ykx.manual.spring.springframework.context.support;

import ykx.manual.spring.springframework.beans.factory.ApplicationContextAware;
import ykx.manual.spring.springframework.beans.factory.config.BeanPostProcessor;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;
import ykx.manual.spring.springframework.context.ApplicationContext;

/**
 * @author yangkaixuan
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansCreateException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansCreateException {
        return bean;
    }
}
