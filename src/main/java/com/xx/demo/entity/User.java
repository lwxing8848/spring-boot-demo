package com.xx.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lwx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("demo_user")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户账户
     */
    @TableField("USER_ACCOUNT")
    private String userAccount;

    /**
     * 用户密码
     */
    @TableField("USER_PASSWORD")
    private String userPassword;

    /**
     * 电子邮件
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 手机号码
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 创建日期
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @TableField("CREATED_TIME")
    private Date createdTime;

    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private Long createdBy;

    @TableField("STATUS")
    private String status;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
