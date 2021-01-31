package src.test.java.com.quick.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class jdbcbatchtest {
    public static void main(String[] args) {
        {
            long start = System.nanoTime();
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
//                Class.forName("com.mysql.jdbc.Driver");&serverTimezone=GMT%2B8
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url="jdbc:mysql://127.0.0.1:3306/yyt?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&useSSL=true";
                String user="root";
                String password="zwdfc";

                conn= DriverManager.getConnection(url,user,password);
                long starTime = System.currentTimeMillis();

                conn.setAutoCommit(false);
                String sql = "INSERT INTO `fornow_student` (`student_id`, `createDateTime`," +
                        " `lastModifyDateTime`, `gradu_school`, `gradu_specialty`, `is_email_valid`," +
                        " `is_from_fornow`, `is_phone_valid`, `name`, `qq`, `sex`, " +
                        "`webchat`, `zone`, `city_id`, `degree_id`, `province_id`, " +
                        "`user_id`, `is_first`, `qq_kf`, `webchat_kf`, `type`, `kfAddTime`," +
                        " `is_from_offline`, `is_To_offline`, `isToOrNot`, `available_fees`," +
                        " `totle_coupons`, `is_need_match`, `is_assign`, `assign_type`, " +
                        "`available_fee`, `createDate`, `lastModifyDate`, `head_pic_url`," +
                        " `studyCurrency`, `travelTime`, `version`, `diy_assign_type`, " +
                        "`is_student_register`, `port`, `recent_status`) " +
                        "VALUES(?,'2014-07-22 09:07:27','2014-07-24 14:00:02','南京大学'," +
                        "'计算机','0','1','0','张无忌','123456789',NULL,'987654321'," +
                        "'北京市 北京市','36','1','1','24','1',NULL,NULL,NULL,NULL," +
                        "'0','0',NULL,'0.00','0.00','0','0','0',NULL,'-99','-99'," +
                        "NULL,NULL,NULL,'0','0','0','0','0')";
                // JAVA默认为TRUE,我们自己处理需要设置为FALSE,并且修改为手动提交,才可以调用rollback()函数
                conn.setAutoCommit(false);
                pstmt = conn.prepareStatement(sql);
//                System.out.println("sql="+sql);
                for (int i = 0; i < 1000000; i++) {
                    String id = String.valueOf(SnowflakeIdWorker.generateId());


                    pstmt.setString(1, id);

                    pstmt.addBatch();
                    //防止内存溢出，我也不是很清楚都这么写
                    if ((i + 1) % 10000 == 0) {
                        System.out.println("i=="+i);
                        pstmt.executeBatch();
                        pstmt.clearBatch();
                    }
                }
                pstmt.executeBatch(); // 批量执行
                conn.commit();// 提交事务
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("SQLException e"+e);
                try {
                    conn.rollback(); // 进行事务回滚
                    System.out.println("conn.rollback");
                } catch (SQLException ex) {
                    System.out.println("conn.rollback SQLException");
                    e.printStackTrace();
                }
            } finally {
                if (pstmt != null)
                    try {
                        pstmt.close();
                        System.out.println("pstmt.close");
                    } catch (SQLException e) {
                        System.out.println("pstmt.close SQLException");
                        e.printStackTrace();
                    }
                if (conn != null)
                    try {
                        conn.close();
                        System.out.println("conn.close ");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("conn.closeSQLException");
                    }
            }
//            long end = System.nanoTime();
            long period = System.nanoTime() - start;
            System.out.println("耗时=="+ TimeUnit.NANOSECONDS.toSeconds(period)+ "s");
        }
    }
}
