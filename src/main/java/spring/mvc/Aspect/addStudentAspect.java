package spring.mvc.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class addStudentAspect {
    @Pointcut("execution(public * addStudent(..))")
    public void service(){
        System.out.println("addStudent() entered");
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
