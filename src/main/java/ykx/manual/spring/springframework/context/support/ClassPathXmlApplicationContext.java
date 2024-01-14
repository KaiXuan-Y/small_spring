package ykx.manual.spring.springframework.context.support;

import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.util.Map;

/**
 * @author yangkaixuan
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configLocation) throws BeansCreateException {
        this(new String[]{configLocation});
    }


    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }


}
