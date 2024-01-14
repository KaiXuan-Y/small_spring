package ykx.manual.spring.springframework.beans.factory.config;

import ykx.manual.spring.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author yangkaixuan
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
