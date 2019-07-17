package com.jian.entity;

import java.io.Serializable;
import java.util.Date;

public class LjWorkerCapture implements Serializable {
    private String uuid;

    private String idCard;

    private Date captureTime;

    private String capturePhoto;

    private String deviceSeril;

    private Integer matchScore;

    private String belongId;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
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

    public String getDeviceSeril() {
        return deviceSeril;
    }

    public void setDeviceSeril(String deviceSeril) {
        this.deviceSeril = deviceSeril == null ? null : deviceSeril.trim();
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
}