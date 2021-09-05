package cn.whu.dhji.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘泽彬
 * @since 2019-05-21
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 登录用户名
     */
    private String username;
    /**
     * 登录密码，md5小写字母加密
     */
    private String password;
    @TableField("creat_time")
    private Date creatTime;
    @TableField("update_time")
    private Date updateTime;
    /**
     * 是否启用该用户，1表示启用，0表示禁用
     */
    private Integer enable;
    /**
     * 用户显示名称，一般是用户的真实姓名
     */
    private String nickname;
    /**
     * 用户移动电话，手机号
     */
    private String mobile;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户类型，0是普通用户，1是教师用户，2是校级管理员，3是省域管理员，4是超级管理员
     */
    private Integer type;
    private String photo;
    /**
     * 用户登陆会修改这个值，会对用户进行配置
     */
    private Integer sessionId;

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", creatTime=" + creatTime +
        ", updateTime=" + updateTime +
        ", enable=" + enable +
        ", nickname=" + nickname +
        ", mobile=" + mobile +
        ", email=" + email +
        ", type=" + type +
        ", photo=" + photo +
        ", sessionId=" + sessionId +
        "}";
    }
}
