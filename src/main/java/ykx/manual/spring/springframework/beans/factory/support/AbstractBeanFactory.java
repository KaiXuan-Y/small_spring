package ykx.manual.spring.springframework.beans.factory.support;

import ykx.manual.spring.springframework.beans.factory.BeanFactory;
import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * @author yangkaixuan
 */
public abstract class AbstractBeanFactory extends DefaultSingletonRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (null != bean){
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name , beanDefinition);


    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
