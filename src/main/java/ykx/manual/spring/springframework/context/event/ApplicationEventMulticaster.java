package ykx.manual.spring.springframework.context.event;

import ykx.manual.spring.springframework.context.ApplicationEvent;
import ykx.manual.spring.springframework.context.ApplicationListener;

/**
 * @author yangkaixuan
 */
public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);

}
