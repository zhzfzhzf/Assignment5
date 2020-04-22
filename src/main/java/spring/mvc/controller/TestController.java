package spring.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("test")
    public String test()
    {return "/index.jsp";}

    @RequestMapping("test2")
    @ResponseBody
    public String test2()
    {
        return "/index.jsp";
    }

}
