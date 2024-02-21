package ykx.manual.spring.springframework.context.support;

import ykx.manual.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;
import ykx.manual.spring.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author yangkaixuan
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;
    @Override
    protected DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    protected void refreshBeanFactory() throws BeansCreateException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }


    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);
}
