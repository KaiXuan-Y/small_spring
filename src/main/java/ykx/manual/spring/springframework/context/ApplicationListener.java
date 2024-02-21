package ykx.manual.spring.springframework.context;

import java.util.EventListener;

/**
 * @author yangkaixuan
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
