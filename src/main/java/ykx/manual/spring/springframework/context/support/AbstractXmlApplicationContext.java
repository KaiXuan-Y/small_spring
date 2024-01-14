package ykx.manual.spring.springframework.context.support;

import ykx.manual.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author yangkaixuan
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinition(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
