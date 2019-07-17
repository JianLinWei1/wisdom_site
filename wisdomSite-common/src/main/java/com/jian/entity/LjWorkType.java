package com.jian.entity;

import java.io.Serializable;

public class LjWorkType implements Serializable {
    private String id;

    private String workTypeName;

    private String workTypeDescription;

    private String belongId;

    private Long version;

    private Integer action;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName == null ? null : workTypeName.trim();
    }

    public String getWorkTypeDescription() {
        return workTypeDescription;
    }

    public void setWorkTypeDescription(String workTypeDescription) {
        this.workTypeDescription = workTypeDescription == null ? null : workTypeDescription.trim();
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }
}