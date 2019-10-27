package com.freeLearn.wall.model;

import java.io.Serializable;

public class WallUserInformation implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private String university;

    private String schoolNumber;

    // 是否实名
    private Boolean isRealNameRegistered;

    private String idCard;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Boolean getIsRealNameRegistered() {
        return isRealNameRegistered;
    }

    public void setIsRealNameRegistered(Boolean isRealNameRegistered) {
        this.isRealNameRegistered = isRealNameRegistered;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", university=").append(university);
        sb.append(", schoolNumber=").append(schoolNumber);
        sb.append(", isRealNameRegistered=").append(isRealNameRegistered);
        sb.append(", idCard=").append(idCard);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}