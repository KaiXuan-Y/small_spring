package ykx.manual.spring.springframework.beans.factory.support;

import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author yangkaixuan
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private final ConcurrentMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    ;

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new BeansCreateException("no bean Named " + beanName + "is defined");

        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }
}
