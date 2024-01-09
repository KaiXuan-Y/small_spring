package ykx.manual.spring.springframework.beans.factory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author yangkaixuan
 */
public interface BeanFactory {
    Object getBean(String name);

    Object getBean(String name, Object... args);
}