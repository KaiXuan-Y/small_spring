package ykx.manual.spring.springframework.beans.factory;

import ykx.manual.spring.springframework.beans.factory.Aware;
import ykx.manual.spring.springframework.context.ApplicationContext;

public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext);
}
