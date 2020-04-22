package spring.mvc.Spring;

import org.aspectj.weaver.ast.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.mvc.Aspect.testAspect;
import spring.mvc.Bean.TestBean;
import spring.mvc.Service.StudentHomeworkJdbc;
import spring.mvc.Service.TestJDBC;

@ComponentScan("spring.mvc.*")
public class TestSpring {
    public static void main(String[] args){


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestBean testBean = context.getBean("testBean",TestBean.class);
        testAspect testAspect = context.getBean("testAspect",testAspect.class);
        TestJDBC testJDBC = context.getBean("testJdbc",TestJDBC.class);
        //TestJDBC a = new TestJDBC();
        testJDBC.Print();
        StudentHomeworkJdbc studentHomeworkJdbc=context.getBean("StudentHomeworkJdbc", StudentHomeworkJdbc.class);
        studentHomeworkJdbc.testMethod();
        //System.out.println(testBean.toString());
    }
}
