package ykx.manual.spring.springframework.aop;

public interface PointCut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();


}
