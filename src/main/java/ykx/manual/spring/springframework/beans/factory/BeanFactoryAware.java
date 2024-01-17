package ykx.manual.spring.springframework.beans.factory;

import ykx.manual.spring.springframework.beans.factory.Aware;
import ykx.manual.spring.springframework.beans.factory.BeanFactory;

public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory);
}
