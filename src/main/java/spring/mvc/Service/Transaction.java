package spring.mvc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import javax.sql.DataSource;

@Transactional
public class Transaction {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(String name, int age) {
        String sql = "insert into s_homework(id,title,content,create_time) values(?,?,?,?);";
        int updateResult = jdbcTemplate.update(sql, 33, "Javaee","Homework","4.22");
        System.out.println("updateResult:" + updateResult);
        return updateResult;

    }



}
