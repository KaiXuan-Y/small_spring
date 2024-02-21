package ykx.manual.spring.springframework.context.event;

import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import ykx.manual.spring.springframework.beans.factory.BeanFactory;
import ykx.manual.spring.springframework.beans.factory.BeanFactoryAware;
import ykx.manual.spring.springframework.context.ApplicationEvent;
import ykx.manual.spring.springframework.context.ApplicationListener;
import ykx.manual.spring.springframework.util.ClassUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author yangkaixuan
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    private final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent applicationEvent) {
        LinkedList<ApplicationListener> allListeners = new LinkedList<>();
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            if (supportsEvent(listener, applicationEvent)) {
                allListeners.add(listener);
            }
        }
        return allListeners;

    }

    private boolean supportsEvent(ApplicationListener<ApplicationEvent> listener, ApplicationEvent applicationEvent) {
        Class<? extends ApplicationListener> listenerClass = listener.getClass();
        Class<?> targetClass = ClassUtil.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterfaces = targetClass.getGenericInterfaces()[0];
        Type actualTypeArgument = ((ParameterizedType) genericInterfaces).getActualTypeArguments()[0];
        String typeName = actualTypeArgument.getTypeName();

        Class<?> eventClass;
        try {
            eventClass = Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return eventClass.isAssignableFrom(applicationEvent.getClass());

    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
