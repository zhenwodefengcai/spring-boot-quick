package src.test.java.com.quick.jdbc.test;

import com.quick.jdbc.entity.SubjectKycFile;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class jdbcbatchtestParam {
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
                        "VALUES(?,?,?,?," +
                        "?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?)";
                // JAVA默认为TRUE,我们自己处理需要设置为FALSE,并且修改为手动提交,才可以调用rollback()函数
                conn.setAutoCommit(false);
                pstmt = conn.prepareStatement(sql);
//                System.out.println("sql="+sql);
                //990000   耗时==78s 5000000  耗时==328s  10000000 耗时==664s
                //100000000  耗时==2456s
                for (int i = 0; i < 100000000; i++) {
                    String id = String.valueOf(SnowflakeIdWorker.generateId());
                    List<Object[]> objectList = new ArrayList<>();
                    SubjectKycFile sb=new SubjectKycFile();
                    sb.setId(String.valueOf(SnowflakeIdWorker.generateId()));
                    pstmt.setString(1, id);
                    pstmt.setString(2, LocalDateTime.of(2021, 1, 22, 22, 46, 20).toString());
                    pstmt.setString(3, LocalDateTime.of(2021, 1, 23, 22, 46, 20).toString());
//                    pstmt.setString(4, "上海交通大学");//1000000 yiwan
//                    pstmt.setString(4, "浙江大学");//5000000
                    pstmt.setString(4, "中国科学技术大学");//10000000
                    pstmt.setString(5, "计算机");
                    pstmt.setString(6, "0");
                    pstmt.setString(7, "1");
                    pstmt.setString(8, "0");
                    pstmt.setString(9, "杨洋");
                    pstmt.setString(10, "123456789");
                    pstmt.setString(11, "0");
                    pstmt.setString(12, "987654321");
                    pstmt.setString(13, "北京市 北京市");
                    pstmt.setString(14, "36");
                    pstmt.setString(15, "1");
                    pstmt.setString(16, "1");
                    pstmt.setString(17, "24");
                    pstmt.setString(18, "1");
                    pstmt.setString(19, null);
                    pstmt.setString(20, null);
                    pstmt.setString(21, null);
                    pstmt.setString(22, null);
                    pstmt.setString(23, null);
                    pstmt.setString(24, null);
                    pstmt.setString(25, null);
                    pstmt.setString(26, "0");
                    pstmt.setString(27, "0");
                    pstmt.setString(28, "0");
                    pstmt.setString(29, "0");
                    pstmt.setString(30, "0");
                    pstmt.setString(31, null);
                    pstmt.setString(32, "-99");
                    pstmt.setString(33, "-99");
                    pstmt.setString(34, null);
                    pstmt.setString(35, "1");
                    pstmt.setString(36, null);
                    pstmt.setString(37, "0");
                    pstmt.setString(38, "0");
                    pstmt.setString(39, "0");
                    pstmt.setString(40, "0");
                    pstmt.setString(41, "0");

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
                System.out.println("SQLException e="+e);
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
