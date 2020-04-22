package spring.mvc.controller;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.Bean.Student;
import spring.mvc.Bean.TestBean;
import spring.mvc.Service.StudentHomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class AddStudentServlet {
    @RequestMapping("/add_student")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Student st = context.getBean("Student",Student.class);
        st.setId(Integer.valueOf(req.getParameter("id")));
        st.setName(req.getParameter("name"));
        st.setCreate_time(sqlDate);
        System.out.println(st.getId()+","+st.getName()+","+st.getCreate_time());
        StudentHomeworkJdbc a = new StudentHomeworkJdbc();
        a.addStudent(st);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
