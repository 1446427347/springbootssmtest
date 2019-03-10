package org.springboot.ssm.test.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户基本信息表
 */
@Data
public class UserInformation implements Serializable{

    private static final long serialVersionUID = -6883795800966275207L;

    private String userId;

    private String userName;

    private String number;

    private String mail;

    private String sex;

    private String organization;

    private String department;

    private String position;

    private String role;

    private String status;

    private String note;

    private String avatorUrl;

    private Timestamp createTime;

    private Timestamp updateTime;

}
