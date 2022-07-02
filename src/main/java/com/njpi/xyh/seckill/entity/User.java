package com.njpi.xyh.seckill.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;


/**
 * 用户表(User)表实体类
 *
 * @author xyh
 * @since 2022-06-30 16:47:42
 */
@SuppressWarnings("serial")
@TableName("t_user")
public class User extends Model<User> {
    /**
     * 用户ID,手机号码
     */
    @TableId(value = "id",type = IdType.NONE)
    private Long id;

    /**
     * ${column.comment}
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    @NotBlank(message="手机号不能为空")
//    @Pattern(regexp = "/^(1[0-9][0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$/",message = "手机号格式错误")
    private String mobile;

    /**
     * MD5(MD5(pass明文+固定salt)+salt)
     */
    @TableField(value = "password")
    @NotBlank(message="密码不能为空")
    private String password;

    /**
     * ${column.comment}
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 头像
     */
    @TableField(value = "head")
    private String head;

    /**
     * 注册时间
     */
    @TableField(value = "register_date")
    private Date registerDate;

    /**
     * 最后一次登录事件
     */
    @TableField(value = "last_login_date")
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    @TableField(value = "login_count")
    private Integer loginCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", head='" + head + '\'' +
                ", registerDate=" + registerDate +
                ", lastLoginDate=" + lastLoginDate +
                ", loginCount=" + loginCount +
                '}';
    }
}

