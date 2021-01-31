//package com.quick.jdbc.entity;
//
////import com.cloudkeeper.leasing.base.constant.BaseConstants;
////import com.cloudkeeper.leasing.base.domain.SubjectBaseEntity;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.experimental.Accessors;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.time.LocalDateTime;
//
///**
// * kyc附件
// * @author lixin.shao
// */
//@ApiModel(value = "kyc附件", description = "kyc附件")
//@Getter
//@Setter
//@Accessors(chain = true)
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "fornow_student")
//public class SubjectKycFile1 {
//
//    @Id
////    @GeneratedValue(generator = "idGenerator")
////    @GenericGenerator(name = "idGenerator", strategy = "uuid2")
//    @Column(name = "student_id", length = 36)
//    @ApiModelProperty(value = "主键id", position = 1)
//    private String id;
//
//    /** 创建时间 */
//    @CreatedDate
//    @ApiModelProperty(value = "创建时间", position = 2)
//    @Column(name = "createDateTime")
//    private LocalDateTime createDateTime;
//
//    /** 更新时间 */
//    @LastModifiedDate
//    @ApiModelProperty(value = "更新时间", position = 3)
//    @Column(name = "lastModifyDateTime")
//    private LocalDateTime lastModifyDateTime;
//
//    /** 创建人 */
//    @CreatedBy
//    @ApiModelProperty(value = "创建人", position = 4)
//    @Column(name = "gradu_school")
//    private String graduSchool;
//
//    /** 更新人 */
//    @LastModifiedBy
//    @ApiModelProperty(value = "更新人", position = 5)
//    @Column(name = "gradu_specialty")
//    private String graduSpecialty;
//
//    /** 更新人 */
//    @LastModifiedBy
////    @ApiModelProperty(value = "更新人", position = 5)
//    @Column(name = "is_email_valid")
//    private Integer isEmailValid;
//
//    /** 版本（乐观锁） */
//    @Version
////    @ApiModelProperty(value = "版本（乐观锁）", position = 6)
//    @Column(name = "is_from_fornow")
//    private Integer isFromFornow;
//
//    //    @ApiModelProperty(value = "版本（乐观锁）", position = 6)
//    @Column(name = "is_phone_valid")
//    private Integer isPhoneValid;
//
//
////    /** 逻辑删除 */
////    @ApiModelProperty(value = "逻辑删除", position = 7)
////    private Integer isDelete = BaseConstants.Boolean.FALSE.ordinal();
//
//    @Column(name = "name")
//    private String name;
//
//    /** 公司id */
//    @ApiModelProperty(value = "公司id", position = 8)
//    @Column(name = "qq")
//    private String qq;
//
//    @Column(name = "sex")
//    private Integer sex;
//
//    /** 案件id*/
//    @ApiModelProperty(value = "案件id", position = 9)
//    @Column(name = "webchat")
//    private String webchat;
//
////    /** 案件*/
////    @ApiModelProperty(value = "案件")
////    @ManyToOne
////    @JoinColumn(name = "subjectId", updatable = false, insertable = false)
////    @JsonIgnore
////    private Subject subject;
//
//    /** 序号 */
////    @ApiModelProperty(value = "序号", position = 10)
//    @Column(name = "zone")
//    private String zone;
//    @Column(name = "city_id")
//    private BigInteger cityId;
//    @Column(name = "degree_id")
//    private BigInteger degreeId;
//    @Column(name = "province_id")
//    private BigInteger provinceId;
//    @Column(name = "user_id")
//    private BigInteger userId;
//    @Column(name = "is_first")
//    private Integer isFirst;
//    @Column(name = "qq_kf")
//    private String qqKf;
//    @Column(name = "webchat_kf")
//    private String webchatKf;
//    @Column(name = "type")
//    private Integer type;
//    @Column(name = "kfAddTime")
//    private BigInteger kfAddTime;
//    @Column(name = "is_from_offline")
//    private Integer isFromOffline;
//    @Column(name = "is_To_offline")
//    private Integer isToOffline;
//    @Column(name = "isToOrNot")
//    private Integer isToOrNot;
//    @Column(name = "available_fees")
//    private BigDecimal availableFees;
//    @Column(name = "totle_coupons")
//    private BigDecimal totleCoupons;
//    @Column(name = "is_need_match")
//    private Integer isNeedMatch;
//    @Column(name = "is_assign")
//    private Integer isAssign;
//    @Column(name = "assign_type")
//    private Integer assignType;
//    @Column(name = "available_fee")
//    private BigDecimal availableFee;
//    @Column(name = "createDate")
//    private BigInteger createDate;
//    @Column(name = "lastModifyDate")
//    private BigInteger lastModifyDate;
//    @Column(name = "head_pic_url")
//    private String headPicUrl;
//    @Column(name = "studyCurrency")
//    private BigDecimal studyCurrency;
//    @Column(name = "travelTime")
//    private String travelTime;
//    @Column(name = "version")
//    private Integer version;
//    @Column(name = "diy_assign_type")
//    private Integer diyAssignType;
//    @Column(name = "is_student_register")
//    private Integer isStudentRegister;
//    @Column(name = "port")
//    private Integer port;
//    @Column(name = "recent_status")
//    private Integer recentStatus;
//
//
////    /** 文件名称 */
////    @ApiModelProperty(value = "文件名称", position = 10)
////    @Column(length = 100)
////    private String fileName;
////
////    /** 文件路径 */
////    @ApiModelProperty(value = "文件路径", position = 10)
////    @Column(length = 200)
////    private String filePath;
////
////    /** 上传时间 */
////    @ApiModelProperty(value = "上传时间", position = 10)
////    private LocalDate uploadDate;
//
//}