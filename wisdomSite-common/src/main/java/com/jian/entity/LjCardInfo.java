package com.jian.entity;

import java.io.Serializable;

public class LjCardInfo implements Serializable {
    private String idCard;

    private String name;

    private Integer gender;

    private String nation;

    private String birthday;

    private String address;

    private String idissue;

    private String idBeginDate;

    private String idEndDate;

    private String idPhoto;

    private String visiblePhoto;

    private String redPhoto;

    private Integer idType;

    private String visiblePhotoFeature;

    private String belongId;

    private Integer action;

    private Long version;

    private static final long serialVersionUID = 1L;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIdissue() {
        return idissue;
    }

    public void setIdissue(String idissue) {
        this.idissue = idissue == null ? null : idissue.trim();
    }

    public String getIdBeginDate() {
        return idBeginDate;
    }

    public void setIdBeginDate(String idBeginDate) {
        this.idBeginDate = idBeginDate == null ? null : idBeginDate.trim();
    }

    public String getIdEndDate() {
        return idEndDate;
    }

    public void setIdEndDate(String idEndDate) {
        this.idEndDate = idEndDate == null ? null : idEndDate.trim();
    }

    public String getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(String idPhoto) {
        this.idPhoto = idPhoto == null ? null : idPhoto.trim();
    }

    public String getVisiblePhoto() {
        return visiblePhoto;
    }

    public void setVisiblePhoto(String visiblePhoto) {
        this.visiblePhoto = visiblePhoto == null ? null : visiblePhoto.trim();
    }

    public String getRedPhoto() {
        return redPhoto;
    }

    public void setRedPhoto(String redPhoto) {
        this.redPhoto = redPhoto == null ? null : redPhoto.trim();
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getVisiblePhotoFeature() {
        return visiblePhotoFeature;
    }

    public void setVisiblePhotoFeature(String visiblePhotoFeature) {
        this.visiblePhotoFeature = visiblePhotoFeature == null ? null : visiblePhotoFeature.trim();
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}