package com.tp.admin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author tp
 * @since 2018-04-28
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id_user")
    private String idUser;
    /**
     * 账号(手机)
     */
    @TableField("login_name")
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 1:男2:女
     */
    private String sex;
    /**
     * 备注
     */
    private String remark;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 上次登陆时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * IS_ADMIN:Y IS_NOT_ADMIN:N
     */
    @TableField("is_admin")
    private String isAdmin;
    /**
     * Y:有效N无效
     */
    @TableField("is_valid")
    private String isValid;
    /**
     * Y启用N禁用
     */
    @TableField("is_enable")
    private String isEnable;
    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.idUser;
    }

    @Override
    public String toString() {
        return "User{" +
        ", idUser=" + idUser +
        ", loginName=" + loginName +
        ", password=" + password +
        ", name=" + name +
        ", sex=" + sex +
        ", remark=" + remark +
        ", email=" + email +
        ", lastLoginTime=" + lastLoginTime +
        ", isAdmin=" + isAdmin +
        ", isValid=" + isValid +
        ", isEnable=" + isEnable +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        ", updateBy=" + updateBy +
        ", updateTime=" + updateTime +
        "}";
    }
}
