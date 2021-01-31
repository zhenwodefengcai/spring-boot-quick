package src.test.java.com.quick.jdbc.test;

import com.quick.jdbc.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public  class jdbctemplateBatchtestTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;//创建jdbctemplate对象，并使用spring的自动注入完成实例化

    @Test
    public void selectTest1() {
        int result=0;
        String sql = "UPDATE `fornow_student`  SET NAME='真我风采' WHERE student_id=?";//sql语句
        Object[] params = new Object[]{1};//设置参数
        result=jdbcTemplate.update(sql,params);//返回受影响的行数
        System.out.println(result);
    }



}