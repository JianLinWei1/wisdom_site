package com.jian.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LjWorkerCaptureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LjWorkerCaptureExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeIsNull() {
            addCriterion("capture_time is null");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeIsNotNull() {
            addCriterion("capture_time is not null");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeEqualTo(Date value) {
            addCriterion("capture_time =", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeNotEqualTo(Date value) {
            addCriterion("capture_time <>", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeGreaterThan(Date value) {
            addCriterion("capture_time >", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("capture_time >=", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeLessThan(Date value) {
            addCriterion("capture_time <", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeLessThanOrEqualTo(Date value) {
            addCriterion("capture_time <=", value, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeIn(List<Date> values) {
            addCriterion("capture_time in", values, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeNotIn(List<Date> values) {
            addCriterion("capture_time not in", values, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeBetween(Date value1, Date value2) {
            addCriterion("capture_time between", value1, value2, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCaptureTimeNotBetween(Date value1, Date value2) {
            addCriterion("capture_time not between", value1, value2, "captureTime");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoIsNull() {
            addCriterion("capture_photo is null");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoIsNotNull() {
            addCriterion("capture_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoEqualTo(String value) {
            addCriterion("capture_photo =", value, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoNotEqualTo(String value) {
            addCriterion("capture_photo <>", value, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoGreaterThan(String value) {
            addCriterion("capture_photo >", value, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("capture_photo >=", value, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoLessThan(String value) {
            addCriterion("capture_photo <", value, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoLessThanOrEqualTo(String value) {
            addCriterion("capture_photo <=", value, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoLike(String value) {
            addCriterion("capture_photo like", value, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoNotLike(String value) {
            addCriterion("capture_photo not like", value, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoIn(List<String> values) {
            addCriterion("capture_photo in", values, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoNotIn(List<String> values) {
            addCriterion("capture_photo not in", values, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoBetween(String value1, String value2) {
            addCriterion("capture_photo between", value1, value2, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoNotBetween(String value1, String value2) {
            addCriterion("capture_photo not between", value1, value2, "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilIsNull() {
            addCriterion("device_seril is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilIsNotNull() {
            addCriterion("device_seril is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilEqualTo(String value) {
            addCriterion("device_seril =", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilNotEqualTo(String value) {
            addCriterion("device_seril <>", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilGreaterThan(String value) {
            addCriterion("device_seril >", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilGreaterThanOrEqualTo(String value) {
            addCriterion("device_seril >=", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLessThan(String value) {
            addCriterion("device_seril <", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLessThanOrEqualTo(String value) {
            addCriterion("device_seril <=", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLike(String value) {
            addCriterion("device_seril like", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilNotLike(String value) {
            addCriterion("device_seril not like", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilIn(List<String> values) {
            addCriterion("device_seril in", values, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilNotIn(List<String> values) {
            addCriterion("device_seril not in", values, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilBetween(String value1, String value2) {
            addCriterion("device_seril between", value1, value2, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilNotBetween(String value1, String value2) {
            addCriterion("device_seril not between", value1, value2, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andMatchScoreIsNull() {
            addCriterion("match_score is null");
            return (Criteria) this;
        }

        public Criteria andMatchScoreIsNotNull() {
            addCriterion("match_score is not null");
            return (Criteria) this;
        }

        public Criteria andMatchScoreEqualTo(Integer value) {
            addCriterion("match_score =", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreNotEqualTo(Integer value) {
            addCriterion("match_score <>", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreGreaterThan(Integer value) {
            addCriterion("match_score >", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("match_score >=", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreLessThan(Integer value) {
            addCriterion("match_score <", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreLessThanOrEqualTo(Integer value) {
            addCriterion("match_score <=", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreIn(List<Integer> values) {
            addCriterion("match_score in", values, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreNotIn(List<Integer> values) {
            addCriterion("match_score not in", values, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreBetween(Integer value1, Integer value2) {
            addCriterion("match_score between", value1, value2, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("match_score not between", value1, value2, "matchScore");
            return (Criteria) this;
        }

        public Criteria andBelongIdIsNull() {
            addCriterion("belong_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongIdIsNotNull() {
            addCriterion("belong_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongIdEqualTo(String value) {
            addCriterion("belong_id =", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdNotEqualTo(String value) {
            addCriterion("belong_id <>", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdGreaterThan(String value) {
            addCriterion("belong_id >", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdGreaterThanOrEqualTo(String value) {
            addCriterion("belong_id >=", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdLessThan(String value) {
            addCriterion("belong_id <", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdLessThanOrEqualTo(String value) {
            addCriterion("belong_id <=", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdLike(String value) {
            addCriterion("belong_id like", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdNotLike(String value) {
            addCriterion("belong_id not like", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdIn(List<String> values) {
            addCriterion("belong_id in", values, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdNotIn(List<String> values) {
            addCriterion("belong_id not in", values, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdBetween(String value1, String value2) {
            addCriterion("belong_id between", value1, value2, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdNotBetween(String value1, String value2) {
            addCriterion("belong_id not between", value1, value2, "belongId");
            return (Criteria) this;
        }

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(uuid) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andIdCardLikeInsensitive(String value) {
            addCriterion("upper(id_card) like", value.toUpperCase(), "idCard");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoLikeInsensitive(String value) {
            addCriterion("upper(capture_photo) like", value.toUpperCase(), "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLikeInsensitive(String value) {
            addCriterion("upper(device_seril) like", value.toUpperCase(), "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andBelongIdLikeInsensitive(String value) {
            addCriterion("upper(belong_id) like", value.toUpperCase(), "belongId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}