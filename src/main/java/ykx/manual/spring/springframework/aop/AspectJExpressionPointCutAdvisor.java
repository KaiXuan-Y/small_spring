package ykx.manual.spring.springframework.aop;

import org.aopalliance.aop.Advice;
import ykx.manual.spring.springframework.aop.aspectj.AspectJExpressionPointCut;

/**
 * @author yangkaixuan
 */
public class AspectJExpressionPointCutAdvisor implements PointCutAdvisor{
    private AspectJExpressionPointCut aspectJExpressionPointCut;

    private Advice advice;

    private String expression;
    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public PointCut getPointCut() {
        if (null == aspectJExpressionPointCut){
            aspectJExpressionPointCut = new AspectJExpressionPointCut(expression);
        }
        return aspectJExpressionPointCut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
