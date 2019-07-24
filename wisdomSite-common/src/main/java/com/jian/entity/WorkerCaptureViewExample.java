package com.jian.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkerCaptureViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkerCaptureViewExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIdissueIsNull() {
            addCriterion("idissue is null");
            return (Criteria) this;
        }

        public Criteria andIdissueIsNotNull() {
            addCriterion("idissue is not null");
            return (Criteria) this;
        }

        public Criteria andIdissueEqualTo(String value) {
            addCriterion("idissue =", value, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueNotEqualTo(String value) {
            addCriterion("idissue <>", value, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueGreaterThan(String value) {
            addCriterion("idissue >", value, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueGreaterThanOrEqualTo(String value) {
            addCriterion("idissue >=", value, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueLessThan(String value) {
            addCriterion("idissue <", value, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueLessThanOrEqualTo(String value) {
            addCriterion("idissue <=", value, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueLike(String value) {
            addCriterion("idissue like", value, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueNotLike(String value) {
            addCriterion("idissue not like", value, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueIn(List<String> values) {
            addCriterion("idissue in", values, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueNotIn(List<String> values) {
            addCriterion("idissue not in", values, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueBetween(String value1, String value2) {
            addCriterion("idissue between", value1, value2, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdissueNotBetween(String value1, String value2) {
            addCriterion("idissue not between", value1, value2, "idissue");
            return (Criteria) this;
        }

        public Criteria andIdPhotoIsNull() {
            addCriterion("id_photo is null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoIsNotNull() {
            addCriterion("id_photo is not null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoEqualTo(String value) {
            addCriterion("id_photo =", value, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoNotEqualTo(String value) {
            addCriterion("id_photo <>", value, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoGreaterThan(String value) {
            addCriterion("id_photo >", value, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("id_photo >=", value, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoLessThan(String value) {
            addCriterion("id_photo <", value, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoLessThanOrEqualTo(String value) {
            addCriterion("id_photo <=", value, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoLike(String value) {
            addCriterion("id_photo like", value, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoNotLike(String value) {
            addCriterion("id_photo not like", value, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoIn(List<String> values) {
            addCriterion("id_photo in", values, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoNotIn(List<String> values) {
            addCriterion("id_photo not in", values, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoBetween(String value1, String value2) {
            addCriterion("id_photo between", value1, value2, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andIdPhotoNotBetween(String value1, String value2) {
            addCriterion("id_photo not between", value1, value2, "idPhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoIsNull() {
            addCriterion("visible_photo is null");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoIsNotNull() {
            addCriterion("visible_photo is not null");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoEqualTo(String value) {
            addCriterion("visible_photo =", value, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoNotEqualTo(String value) {
            addCriterion("visible_photo <>", value, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoGreaterThan(String value) {
            addCriterion("visible_photo >", value, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("visible_photo >=", value, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoLessThan(String value) {
            addCriterion("visible_photo <", value, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoLessThanOrEqualTo(String value) {
            addCriterion("visible_photo <=", value, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoLike(String value) {
            addCriterion("visible_photo like", value, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoNotLike(String value) {
            addCriterion("visible_photo not like", value, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoIn(List<String> values) {
            addCriterion("visible_photo in", values, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoNotIn(List<String> values) {
            addCriterion("visible_photo not in", values, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoBetween(String value1, String value2) {
            addCriterion("visible_photo between", value1, value2, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoNotBetween(String value1, String value2) {
            addCriterion("visible_photo not between", value1, value2, "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIsNull() {
            addCriterion("device_address is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIsNotNull() {
            addCriterion("device_address is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressEqualTo(String value) {
            addCriterion("device_address =", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotEqualTo(String value) {
            addCriterion("device_address <>", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressGreaterThan(String value) {
            addCriterion("device_address >", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressGreaterThanOrEqualTo(String value) {
            addCriterion("device_address >=", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLessThan(String value) {
            addCriterion("device_address <", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLessThanOrEqualTo(String value) {
            addCriterion("device_address <=", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLike(String value) {
            addCriterion("device_address like", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotLike(String value) {
            addCriterion("device_address not like", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIn(List<String> values) {
            addCriterion("device_address in", values, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotIn(List<String> values) {
            addCriterion("device_address not in", values, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressBetween(String value1, String value2) {
            addCriterion("device_address between", value1, value2, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotBetween(String value1, String value2) {
            addCriterion("device_address not between", value1, value2, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andUploadIsNull() {
            addCriterion("upload is null");
            return (Criteria) this;
        }

        public Criteria andUploadIsNotNull() {
            addCriterion("upload is not null");
            return (Criteria) this;
        }

        public Criteria andUploadEqualTo(Integer value) {
            addCriterion("upload =", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotEqualTo(Integer value) {
            addCriterion("upload <>", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadGreaterThan(Integer value) {
            addCriterion("upload >", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload >=", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadLessThan(Integer value) {
            addCriterion("upload <", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadLessThanOrEqualTo(Integer value) {
            addCriterion("upload <=", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadIn(List<Integer> values) {
            addCriterion("upload in", values, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotIn(List<Integer> values) {
            addCriterion("upload not in", values, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadBetween(Integer value1, Integer value2) {
            addCriterion("upload between", value1, value2, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotBetween(Integer value1, Integer value2) {
            addCriterion("upload not between", value1, value2, "upload");
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

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(uuid) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andCapturePhotoLikeInsensitive(String value) {
            addCriterion("upper(capture_photo) like", value.toUpperCase(), "capturePhoto");
            return (Criteria) this;
        }

        public Criteria andBelongIdLikeInsensitive(String value) {
            addCriterion("upper(belong_id) like", value.toUpperCase(), "belongId");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andNationLikeInsensitive(String value) {
            addCriterion("upper(nation) like", value.toUpperCase(), "nation");
            return (Criteria) this;
        }

        public Criteria andBirthdayLikeInsensitive(String value) {
            addCriterion("upper(birthday) like", value.toUpperCase(), "birthday");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andIdissueLikeInsensitive(String value) {
            addCriterion("upper(idissue) like", value.toUpperCase(), "idissue");
            return (Criteria) this;
        }

        public Criteria andIdPhotoLikeInsensitive(String value) {
            addCriterion("upper(id_photo) like", value.toUpperCase(), "idPhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoLikeInsensitive(String value) {
            addCriterion("upper(visible_photo) like", value.toUpperCase(), "visiblePhoto");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLikeInsensitive(String value) {
            addCriterion("upper(device_name) like", value.toUpperCase(), "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLikeInsensitive(String value) {
            addCriterion("upper(device_address) like", value.toUpperCase(), "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andIdCardLikeInsensitive(String value) {
            addCriterion("upper(id_card) like", value.toUpperCase(), "idCard");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLikeInsensitive(String value) {
            addCriterion("upper(device_seril) like", value.toUpperCase(), "deviceSeril");
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