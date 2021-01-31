package src.test.java.com.quick.jdbc.test;

import com.quick.jdbc.Application;
import com.quick.jdbc.entity.SubjectKycFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class jdbctemplateBatchtest {
//    @Autowired
//    DataSourceProperties dataSourceProperties;

//    @Autowired
//    ApplicationContext applicationContext;
//    DataSource dataSource = applicationContext.getBean(DataSource.class);
//ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
//    MybatisPlusConfig MybatisPlusConfig=new MybatisPlusConfig();
//    DataSource dataSource = (DataSource) applicationContext.getBean(String.valueOf(MybatisPlusConfig.singleDatasource()));
//    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void  batch() {
        long start = System.nanoTime();
        //简单测试用
//        String sql1 = "UPDATE `fornow_student`  SET NAME='真我风采' WHERE student_id='1'";
//        jdbcTemplate.update(sql1);
//        System.out.println("jdbctemplateBatchtest sql=="+sql1);


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

        List<Object[]> objectList = new ArrayList<>();
        //100000 ok 200000 耗时==21s
        for (int i = 0; i < 800000; i++) {
            SubjectKycFile sb=new SubjectKycFile();

            sb.setId(String.valueOf(SnowflakeIdWorker.generateId()));
            sb.setCreateDateTime(LocalDateTime.of(2021, 1, 22, 22, 46, 20));
            sb.setLastModifyDateTime(LocalDateTime.of(2021, 1, 23, 22, 46, 20));
//            sb.setGraduSchool("中国科学技术大学");//2
//            sb.setGraduSchool("上海交通大学");//1000000 yiwan
            sb.setGraduSchool("复旦大学");//100000 900000
//            sb.setGraduSchool("浙江大学");//1000000
            sb.setGraduSpecialty("计算机");
            sb.setIsEmailValid(0);
            sb.setIsFromFornow(1);
            sb.setIsPhoneValid(0);
            sb.setName("杨洋");
            sb.setQq("123456789");
            sb.setSex(0);
            sb.setWebchat("987654321");
            sb.setZone("北京市 北京市");
            sb.setCityId(BigInteger.valueOf(36));
            sb.setDegreeId(BigInteger.valueOf(1));
            sb.setProvinceId(BigInteger.valueOf(1));
            sb.setUserId(BigInteger.valueOf(24));
            sb.setIsFirst(1);
            sb.setQqKf(null);
            sb.setWebchatKf(null);
            sb.setType(null);
            sb.setKfAddTime(null);
            sb.setIsFromOffline(null);
            sb.setIsToOffline(null);
            sb.setIsToOrNot(null);
            sb.setAvailableFees(BigDecimal.valueOf(0));
            sb.setTotleCoupons(BigDecimal.valueOf(0));
            sb.setIsNeedMatch(0);
            sb.setIsAssign(0);
            sb.setAssignType(0);
            sb.setAvailableFee(null);
            sb.setCreateDate(BigInteger.valueOf(-99));
            sb.setLastModifyDate(BigInteger.valueOf(-99));
            sb.setHeadPicUrl(null);
            sb.setStudyCurrency(BigDecimal.valueOf(1));
            sb.setTravelTime(null);
            sb.setVersion(0);
            sb.setDiyAssignType(0);
            sb.setIsStudentRegister(0);
            sb.setPort(0);
            sb.setRecentStatus(0);
//            System.out.println("jdbctemplateBatchtest sb=="+sb.toString());
//                list.add(sb);
            objectList.add(new  Object[] {
                    sb.getId(),
                    sb.getCreateDateTime(),
                    sb.getLastModifyDateTime(),
                    sb.getGraduSchool(),
                    sb.getGraduSpecialty(),
                    sb.getIsEmailValid(),
                    sb.getIsFromFornow(),
                    sb.getIsPhoneValid(),
                    sb.getName(),
                    sb.getQq(),
                    sb.getSex(),
                    sb.getWebchat(),
                    sb.getZone(),
                    sb.getCityId(),
                    sb.getDegreeId(),
                    sb.getProvinceId(),
                    sb.getUserId(),
                    sb.getIsFirst(),
                    sb.getQqKf(),
                    sb.getWebchatKf(),
                    sb.getType(),
                    sb.getKfAddTime(),
                    sb.getIsFromOffline(),
                    sb.getIsToOffline(),
                    sb.getIsToOrNot(),
                    sb.getAvailableFees(),
                    sb.getTotleCoupons(),
                    sb.getIsNeedMatch(),
                    sb.getIsAssign(),
                    sb.getAssignType(),
                    sb.getAvailableFee(),
                    sb.getCreateDate(),
                    sb.getLastModifyDate(),
                    sb.getHeadPicUrl(),
                    sb.getStudyCurrency(),
                    sb.getTravelTime(),
                    sb.getVersion(),
                    sb.getDiyAssignType(),
                    sb.getIsStudentRegister(),
                    sb.getPort(),
                    sb.getRecentStatus()
            });
//            System.out.println("jdbctemplateBatchtest objectList=="+objectList);
            if ((i + 1) % 10000 == 0) {
                System.out.println("i=="+i);
            }
        }
        jdbcTemplate.batchUpdate(sql,objectList);
        long period = System.nanoTime() - start;
        System.out.println("耗时=="+ TimeUnit.NANOSECONDS.toSeconds(period)+ "s");

//        return null;
    }



}
