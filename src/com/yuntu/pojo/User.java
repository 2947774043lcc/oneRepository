package com.yuntu.pojo;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: Mybatis01
 * @BelongsPackage: com.yuntu.pojo
 * @Author: Shuo
 * @CreateTime: 2023-08-28  15:35
 * @Description:
 * @Version: 1.0
 */
public class User {
   private Integer id;
   private String userCode;
   private String userName;
   private String userPassword;
   private Integer gender;
   private Date birthday;
   private String phone;
   private String address;
   private Integer userRole;
   private Integer createdBy;
   private Date creationDate;
   private Integer modifyBy;
   private Date modifyDate;
   private Role role;//引入角色表

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", userCode='" + userCode + '\'' +
              ", userName='" + userName + '\'' +
              ", userPassword='" + userPassword + '\'' +
              ", gender=" + gender +
              ", birthday=" + birthday +
              ", phone='" + phone + '\'' +
              ", address='" + address + '\'' +
              ", userRole=" + userRole +
              ", createdBy=" + createdBy +
              ", creationDate=" + creationDate +
              ", modifyBy=" + modifyBy +
              ", modifyDate=" + modifyDate +
              ", role=" + role +
              ", addressList=" + addressList +
              '}';
   }

   private List<Address> addressList;

   public List<Address> getAddressList() {
      return addressList;
   }

   public void setAddressList(List<Address> addressList) {
      this.addressList = addressList;
   }

   public Role getRole() {
      return role;
   }

   public void setRole(Role role) {
      this.role = role;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getUserCode() {
      return userCode;
   }

   public void setUserCode(String userCode) {
      this.userCode = userCode;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getUserPassword() {
      return userPassword;
   }

   public void setUserPassword(String userPassword) {
      this.userPassword = userPassword;
   }

   public Integer getGender() {
      return gender;
   }

   public void setGender(Integer gender) {
      this.gender = gender;
   }

   public Date getBirthday() {
      return birthday;
   }

   public void setBirthday(Date birthday) {
      this.birthday = birthday;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public Integer getUserRole() {
      return userRole;
   }

   public void setUserRole(Integer userRole) {
      this.userRole = userRole;
   }

   public Integer getCreatedBy() {
      return createdBy;
   }

   public void setCreatedBy(Integer createdBy) {
      this.createdBy = createdBy;
   }

   public Date getCreationDate() {
      return creationDate;
   }

   public void setCreationDate(Date creationDate) {
      this.creationDate = creationDate;
   }

   public Integer getModifyBy() {
      return modifyBy;
   }

   public void setModifyBy(Integer modifyBy) {
      this.modifyBy = modifyBy;
   }

   public Date getModifyDate() {
      return modifyDate;
   }

   public void setModifyDate(Date modifyDate) {
      this.modifyDate = modifyDate;
   }

   public User() {
   }

   public User(Integer id, String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, Integer userRole, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
      this.id = id;
      this.userCode = userCode;
      this.userName = userName;
      this.userPassword = userPassword;
      this.gender = gender;
      this.birthday = birthday;
      this.phone = phone;
      this.address = address;
      this.userRole = userRole;
      this.createdBy = createdBy;
      this.creationDate = creationDate;
      this.modifyBy = modifyBy;
      this.modifyDate = modifyDate;
   }
}
