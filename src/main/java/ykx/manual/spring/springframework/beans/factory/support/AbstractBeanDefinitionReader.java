package ykx.manual.spring.springframework.beans.factory.support;

import ykx.manual.spring.springframework.core.io.DefaultResourceLoader;
import ykx.manual.spring.springframework.core.io.ResourceLoader;

/**
 * @author yangkaixuan
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final ResourceLoader resourceLoader;

    private final BeanDefinitionRegistry beanDefinitionRegistry;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader, BeanDefinitionRegistry beanDefinitionRegistry) {
        this.resourceLoader = resourceLoader;
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this(new DefaultResourceLoader(), beanDefinitionRegistry );
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return beanDefinitionRegistry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
