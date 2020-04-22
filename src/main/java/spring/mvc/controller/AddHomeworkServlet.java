package spring.mvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.mvc.Bean.Homework;
import spring.mvc.Bean.TestBean;
import spring.mvc.Service.StudentHomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/add_homework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Homework hw = context.getBean("Homework",Homework.class);
        hw.setId(Integer.valueOf(req.getParameter("id")));
        hw.setTitle(req.getParameter("title"));
        hw.setContent(req.getParameter("content"));
        hw.setCreate_time(sqlDate);
        StudentHomeworkJdbc a = new StudentHomeworkJdbc();
        a.addHomework(hw);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
