package spring.mvc.Service;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.sql.*;
@Service
@EnableAspectJAutoProxy
public class TestJDBC {
    public static String getMysql()
    {
        String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from block limit 1";
        System.out.println("hello");
        try{
            Class.forName(driverName);

            Connection connection = DriverManager.getConnection(url,"root","2019");

            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery(sqlString);

            while (resultset.next()){
                System.out.println(resultset.getLong(1));
            }
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return "s";
    }

    public String Print()
    {
        System.out.println("Print()");
        return "Have accessed to Jdbc";
    }
    public static void main(String[] args)
    {
            getMysql();
    }

}
