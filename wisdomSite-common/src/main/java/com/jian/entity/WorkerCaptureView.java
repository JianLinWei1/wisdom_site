package com.jian.entity;

import java.io.Serializable;
import java.util.Date;

public class WorkerCaptureView implements Serializable {
    private String uuid;

    private Date captureTime;

    private String capturePhoto;

    private Integer matchScore;

    private String belongId;

    private String name;

    private Integer gender;

    private String nation;

    private String birthday;

    private String address;

    private String idissue;

    private String idPhoto;

    private String visiblePhoto;

    private String deviceName;

    private String deviceAddress;

    private Integer upload;

    private String idCard;

    private String deviceSeril;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Date getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Date captureTime) {
        this.captureTime = captureTime;
    }

    public String getCapturePhoto() {
        return capturePhoto;
    }

    public void setCapturePhoto(String capturePhoto) {
        this.capturePhoto = capturePhoto == null ? null : capturePhoto.trim();
    }

    public Integer getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Integer matchScore) {
        this.matchScore = matchScore;
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress == null ? null : deviceAddress.trim();
    }

    public Integer getUpload() {
        return upload;
    }

    public void setUpload(Integer upload) {
        this.upload = upload;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getDeviceSeril() {
        return deviceSeril;
    }

    public void setDeviceSeril(String deviceSeril) {
        this.deviceSeril = deviceSeril == null ? null : deviceSeril.trim();
    }
}