package com.jian.entity;

import java.io.Serializable;
import java.util.Date;

public class LjStrangerCapture implements Serializable {
    private String uuid;

    private Date captureTime;

    private String capturePhoto;

    private String belongId;

    private Integer qValue;

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

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
    }

    public Integer getqValue() {
        return qValue;
    }

    public void setqValue(Integer qValue) {
        this.qValue = qValue;
    }
}