package spring.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.Bean.Student_Homework;
import spring.mvc.Service.StudentHomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentHomeworkServlet {

    @RequestMapping("list")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentHomeworkJdbc a = new StudentHomeworkJdbc();
        List<Student_Homework> listrep = a.selectAll();
        req.setAttribute("list",listrep);
        req.getRequestDispatcher("Query_homework.jsp").forward(req,resp);
    }
}
