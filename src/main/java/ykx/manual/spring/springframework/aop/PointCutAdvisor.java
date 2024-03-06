package ykx.manual.spring.springframework.aop;

/**
 * @author yangkaixuan
 */
public interface PointCutAdvisor extends Advisor{
    PointCut getPointCut();
}
