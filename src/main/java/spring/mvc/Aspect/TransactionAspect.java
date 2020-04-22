package spring.mvc.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Pointcut("execution(public * testMethod(..))")
    public void service(){
        System.out.println("service() entered");
    }

    @Before("service()")
    public void beforeService(){
        System.out.println("Before Service");
    }

    @After("service()")
    public void afterService(){
        System.out.println("After service");
    }


    @Around("service()")
    public Object aroundService(ProceedingJoinPoint jp)
    {
        Object object=null;
        try{
            System.out.println("Before Around Service");
            object = jp.proceed();
            System.out.println(object.toString());
            System.out.println("After Around Service");
        }catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        return object;
    }
}
