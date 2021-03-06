package spring.mvc.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class addStudentHomeworkAspect {
    @Pointcut("execution(public * addStudentHomework(..))")
    public void service(){
        System.out.println("addStudentHomeworkAspect() entered");
    }

    @Before("service()")
    public void beforeService(){
        System.out.println("Before Service");
    }

    @After("service()")
    public void afterService(){
        System.out.println("After service");
    }


}
