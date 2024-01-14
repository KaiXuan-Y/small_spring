package ykx.manual.spring.springframework.beans.factory.support;

import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;
import ykx.manual.spring.springframework.core.io.Resource;
import ykx.manual.spring.springframework.core.io.ResourceLoader;

/**
 * @author yangkaixuan
 *
 * 加载通过Resource注册BeanDefinition
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws BeansCreateException;

    void loadBeanDefinition(Resource... resources) throws BeansCreateException;

    void loadBeanDefinition(String location) throws BeansCreateException;

    void loadBeanDefinition(String[] locations) throws BeansCreateException;

}
