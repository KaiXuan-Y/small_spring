package ykx.manual.spring.springframework.context.event;

import ykx.manual.spring.springframework.beans.factory.BeanFactory;
import ykx.manual.spring.springframework.context.ApplicationEvent;
import ykx.manual.spring.springframework.context.ApplicationListener;

import java.util.Collection;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        Collection<ApplicationListener> applicationListeners = getApplicationListeners(event);
        applicationListeners.forEach(applicationListener -> applicationListener.onApplicationEvent(event));
    }
}
