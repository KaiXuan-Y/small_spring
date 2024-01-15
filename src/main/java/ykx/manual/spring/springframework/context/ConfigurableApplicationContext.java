package ykx.manual.spring.springframework.context;

import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

/**
 * @author yangkaixuan
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh() throws BeansCreateException;

    void registerShutdownHook();

    void close();

}
