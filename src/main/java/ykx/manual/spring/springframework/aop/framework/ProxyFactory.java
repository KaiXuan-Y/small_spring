package ykx.manual.spring.springframework.aop.framework;

import ykx.manual.spring.springframework.aop.AdvisedSupport;

/**
 * @author yangkaixuan
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy(){
        if (advisedSupport.isProxyTargetClass()){
            return new Cglib2AopProxy(advisedSupport);
        }else {
            return new JdkDynamicAopProxy(advisedSupport);
        }
    }
}
