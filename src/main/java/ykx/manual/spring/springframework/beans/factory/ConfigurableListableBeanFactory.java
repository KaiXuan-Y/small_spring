package ykx.manual.spring.springframework.beans.factory;

import ykx.manual.spring.springframework.beans.factory.config.AutowireCapableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.config.ConfigurableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

/**
 * @author yangkaixuan
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansCreateException;

}
