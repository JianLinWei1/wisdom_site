package com.jian.entity;

import java.io.Serializable;

public class LjDevice implements Serializable {
    private String deviceSeril;

    private String deviceName;

    private Integer deviceType;

    private String deviceAddress;

    private String deviceAccuracy;

    private String tcpId;

    private String tcpPort;

    private Integer ioType;

    private String belongId;

    private String deviceNo;

    private String deviceKey;

    private static final long serialVersionUID = 1L;

    public String getDeviceSeril() {
        return deviceSeril;
    }

    public void setDeviceSeril(String deviceSeril) {
        this.deviceSeril = deviceSeril == null ? null : deviceSeril.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress == null ? null : deviceAddress.trim();
    }

    public String getDeviceAccuracy() {
        return deviceAccuracy;
    }

    public void setDeviceAccuracy(String deviceAccuracy) {
        this.deviceAccuracy = deviceAccuracy == null ? null : deviceAccuracy.trim();
    }

    public String getTcpId() {
        return tcpId;
    }

    public void setTcpId(String tcpId) {
        this.tcpId = tcpId == null ? null : tcpId.trim();
    }

    public String getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(String tcpPort) {
        this.tcpPort = tcpPort == null ? null : tcpPort.trim();
    }

    public Integer getIoType() {
        return ioType;
    }

    public void setIoType(Integer ioType) {
        this.ioType = ioType;
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey == null ? null : deviceKey.trim();
    }
}