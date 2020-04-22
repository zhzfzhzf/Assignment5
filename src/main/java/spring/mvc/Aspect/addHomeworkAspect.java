package spring.mvc.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class addHomeworkAspect {
    @Pointcut("execution(public * addHomework(..))")
    public void show()
    {System.out.println("addhomework() entered");}

    @After("show()")
    public void aftershow()
    {
        System.out.println("after show() of addHomework()");
    }


}
