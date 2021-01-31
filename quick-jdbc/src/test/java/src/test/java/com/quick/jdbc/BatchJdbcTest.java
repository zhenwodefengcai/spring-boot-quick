package src.test.java.com.quick.jdbc;

import com.quick.jdbc.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BatchJdbcTest {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void batchUpdaTest() {
        log.info("selectTest1 start");
        int result=0;
        String sql = "UPDATE `fornow_student`  SET NAME='真我的风采' WHERE student_id=?";//sql语句
        Object[] params = new Object[]{1};//设置参数
        result=jdbcTemplate.update(sql,params);//返回受影响的行数
        System.out.println(result);
        log.info("selectTest1 end");
    }

    //主启动类用到
//    public void run(String... strings) throws Exception {
//        log.info("Creating tables");
//        int result=0;
//        String sql = "UPDATE `fornow_student`  SET NAME='真我的风采' WHERE student_id=?";//sql语句
//        Object[] params = new Object[]{1};//设置参数
//        result=jdbcTemplate.update(sql,params);//返回受影响的行数
//        System.out.println(result);
//        log.info("selectTest1 end");
//    }

}