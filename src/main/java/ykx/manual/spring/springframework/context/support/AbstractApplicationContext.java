package ykx.manual.spring.springframework.context.support;

import ykx.manual.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.ListableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.config.BeanFactoryPostProcessor;
import ykx.manual.spring.springframework.beans.factory.config.BeanPostProcessor;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;
import ykx.manual.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import ykx.manual.spring.springframework.context.ApplicationEvent;
import ykx.manual.spring.springframework.context.ApplicationListener;
import ykx.manual.spring.springframework.context.ConfigurableApplicationContext;
import ykx.manual.spring.springframework.context.event.ApplicationEventMulticaster;
import ykx.manual.spring.springframework.context.event.ContextClosedEvent;
import ykx.manual.spring.springframework.context.event.ContextRefreshedEvent;
import ykx.manual.spring.springframework.context.event.SimpleApplicationEventMulticaster;
import ykx.manual.spring.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @author yangkaixuan
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;


    @Override
    public void refresh() throws BeansCreateException {
        //1.创建BeanFactory，加载BeanDefinition
        refreshBeanFactory();

        //2.获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        //3.在BeanFactory实例化之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //4.BeanPostProcessor需要提前于其他Bean对象实力化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        initApplicationEventMulticaster();
        
        registerListeners();

        //5.提前实力化单例Bean
        beanFactory.preInstantiateSingletons();

        finishRefresh();

    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners){
            this.applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void initApplicationEventMulticaster() {
        DefaultListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME , applicationEventMulticaster);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> beanType) throws BeansCreateException {
        return getBeanFactory().getBeansOfType(beanType);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return getBeanFactory().getBean(name, requiredType);
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
}

    @Override
    public void close() {
        publishEvent(new ContextClosedEvent(this));
        getBeanFactory().destroySingletons();
    }

    protected abstract DefaultListableBeanFactory getBeanFactory();

    //创建BeanFactory
    protected abstract void refreshBeanFactory() throws BeansCreateException;


}
