package ykx.manual.spring.springframework.beans.factory.support;

import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * @author yangkaixuan
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
