package ykx.manual.spring.springframework.beans.factory.support;

import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.lang.reflect.InvocationTargetException;

/**
 * @author yangkaixuan
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object instance;
        try {
            instance = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException exception) {
            throw new BeansCreateException("Instantiation of bean error " , exception);

        }

        addSingleton(beanName, instance);
        return instance;

    }
}
