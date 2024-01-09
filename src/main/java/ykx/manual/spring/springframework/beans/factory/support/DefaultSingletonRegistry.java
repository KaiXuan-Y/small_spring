package ykx.manual.spring.springframework.beans.factory.support;

import ykx.manual.spring.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author yangkaixuan
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {
    private final ConcurrentMap<String , Object> singletonObjects = new ConcurrentHashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
