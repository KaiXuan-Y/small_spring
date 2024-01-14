package ykx.manual.spring.springframework.beans.factory.config;

import ykx.manual.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

/**
 * @author yangkaixuan
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansCreateException;
}
