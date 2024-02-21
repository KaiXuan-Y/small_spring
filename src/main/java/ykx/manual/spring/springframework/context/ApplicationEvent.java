package ykx.manual.spring.springframework.context;

import java.util.EventObject;

public class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *  事件的关闭，刷新，以及自定义事件都需要继承这个类
     *
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
