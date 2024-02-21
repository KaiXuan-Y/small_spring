package ykx.manual.spring.springframework.context.event;

import ykx.manual.spring.springframework.context.ApplicationContext;
import ykx.manual.spring.springframework.context.ApplicationEvent;

/**
 * @author yangkaixuan
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
