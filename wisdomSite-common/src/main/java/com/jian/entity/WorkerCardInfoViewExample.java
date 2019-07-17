package com.jian.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkerCardInfoViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkerCardInfoViewExample() {
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

        public Criteria andIdEndDateIsNull() {
            addCriterion("id_end_date is null");
            return (Criteria) this;
        }

        public Criteria andIdEndDateIsNotNull() {
            addCriterion("id_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andIdEndDateEqualTo(String value) {
            addCriterion("id_end_date =", value, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateNotEqualTo(String value) {
            addCriterion("id_end_date <>", value, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateGreaterThan(String value) {
            addCriterion("id_end_date >", value, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("id_end_date >=", value, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateLessThan(String value) {
            addCriterion("id_end_date <", value, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateLessThanOrEqualTo(String value) {
            addCriterion("id_end_date <=", value, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateLike(String value) {
            addCriterion("id_end_date like", value, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateNotLike(String value) {
            addCriterion("id_end_date not like", value, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateIn(List<String> values) {
            addCriterion("id_end_date in", values, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateNotIn(List<String> values) {
            addCriterion("id_end_date not in", values, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateBetween(String value1, String value2) {
            addCriterion("id_end_date between", value1, value2, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdEndDateNotBetween(String value1, String value2) {
            addCriterion("id_end_date not between", value1, value2, "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateIsNull() {
            addCriterion("id_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateIsNotNull() {
            addCriterion("id_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateEqualTo(String value) {
            addCriterion("id_begin_date =", value, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateNotEqualTo(String value) {
            addCriterion("id_begin_date <>", value, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateGreaterThan(String value) {
            addCriterion("id_begin_date >", value, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("id_begin_date >=", value, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateLessThan(String value) {
            addCriterion("id_begin_date <", value, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateLessThanOrEqualTo(String value) {
            addCriterion("id_begin_date <=", value, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateLike(String value) {
            addCriterion("id_begin_date like", value, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateNotLike(String value) {
            addCriterion("id_begin_date not like", value, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateIn(List<String> values) {
            addCriterion("id_begin_date in", values, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateNotIn(List<String> values) {
            addCriterion("id_begin_date not in", values, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateBetween(String value1, String value2) {
            addCriterion("id_begin_date between", value1, value2, "idBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateNotBetween(String value1, String value2) {
            addCriterion("id_begin_date not between", value1, value2, "idBeginDate");
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

        public Criteria andIdTypeIsNull() {
            addCriterion("id_type is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("id_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(Integer value) {
            addCriterion("id_type =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(Integer value) {
            addCriterion("id_type <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(Integer value) {
            addCriterion("id_type >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_type >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(Integer value) {
            addCriterion("id_type <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("id_type <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<Integer> values) {
            addCriterion("id_type in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<Integer> values) {
            addCriterion("id_type not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(Integer value1, Integer value2) {
            addCriterion("id_type between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("id_type not between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andRedPhotoIsNull() {
            addCriterion("red_photo is null");
            return (Criteria) this;
        }

        public Criteria andRedPhotoIsNotNull() {
            addCriterion("red_photo is not null");
            return (Criteria) this;
        }

        public Criteria andRedPhotoEqualTo(String value) {
            addCriterion("red_photo =", value, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoNotEqualTo(String value) {
            addCriterion("red_photo <>", value, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoGreaterThan(String value) {
            addCriterion("red_photo >", value, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("red_photo >=", value, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoLessThan(String value) {
            addCriterion("red_photo <", value, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoLessThanOrEqualTo(String value) {
            addCriterion("red_photo <=", value, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoLike(String value) {
            addCriterion("red_photo like", value, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoNotLike(String value) {
            addCriterion("red_photo not like", value, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoIn(List<String> values) {
            addCriterion("red_photo in", values, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoNotIn(List<String> values) {
            addCriterion("red_photo not in", values, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoBetween(String value1, String value2) {
            addCriterion("red_photo between", value1, value2, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andRedPhotoNotBetween(String value1, String value2) {
            addCriterion("red_photo not between", value1, value2, "redPhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureIsNull() {
            addCriterion("visible_photo_feature is null");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureIsNotNull() {
            addCriterion("visible_photo_feature is not null");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureEqualTo(String value) {
            addCriterion("visible_photo_feature =", value, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureNotEqualTo(String value) {
            addCriterion("visible_photo_feature <>", value, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureGreaterThan(String value) {
            addCriterion("visible_photo_feature >", value, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureGreaterThanOrEqualTo(String value) {
            addCriterion("visible_photo_feature >=", value, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureLessThan(String value) {
            addCriterion("visible_photo_feature <", value, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureLessThanOrEqualTo(String value) {
            addCriterion("visible_photo_feature <=", value, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureLike(String value) {
            addCriterion("visible_photo_feature like", value, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureNotLike(String value) {
            addCriterion("visible_photo_feature not like", value, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureIn(List<String> values) {
            addCriterion("visible_photo_feature in", values, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureNotIn(List<String> values) {
            addCriterion("visible_photo_feature not in", values, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureBetween(String value1, String value2) {
            addCriterion("visible_photo_feature between", value1, value2, "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureNotBetween(String value1, String value2) {
            addCriterion("visible_photo_feature not between", value1, value2, "visiblePhotoFeature");
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

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(Integer value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(Integer value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(Integer value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(Integer value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(Integer value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(Integer value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<Integer> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<Integer> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(Integer value1, Integer value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(Integer value1, Integer value2) {
            addCriterion("action not between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdIsNull() {
            addCriterion("work_type_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdIsNotNull() {
            addCriterion("work_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdEqualTo(String value) {
            addCriterion("work_type_id =", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdNotEqualTo(String value) {
            addCriterion("work_type_id <>", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdGreaterThan(String value) {
            addCriterion("work_type_id >", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_type_id >=", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdLessThan(String value) {
            addCriterion("work_type_id <", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdLessThanOrEqualTo(String value) {
            addCriterion("work_type_id <=", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdLike(String value) {
            addCriterion("work_type_id like", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdNotLike(String value) {
            addCriterion("work_type_id not like", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdIn(List<String> values) {
            addCriterion("work_type_id in", values, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdNotIn(List<String> values) {
            addCriterion("work_type_id not in", values, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdBetween(String value1, String value2) {
            addCriterion("work_type_id between", value1, value2, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdNotBetween(String value1, String value2) {
            addCriterion("work_type_id not between", value1, value2, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameIsNull() {
            addCriterion("work_type_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameIsNotNull() {
            addCriterion("work_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameEqualTo(String value) {
            addCriterion("work_type_name =", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameNotEqualTo(String value) {
            addCriterion("work_type_name <>", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameGreaterThan(String value) {
            addCriterion("work_type_name >", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_type_name >=", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameLessThan(String value) {
            addCriterion("work_type_name <", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameLessThanOrEqualTo(String value) {
            addCriterion("work_type_name <=", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameLike(String value) {
            addCriterion("work_type_name like", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameNotLike(String value) {
            addCriterion("work_type_name not like", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameIn(List<String> values) {
            addCriterion("work_type_name in", values, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameNotIn(List<String> values) {
            addCriterion("work_type_name not in", values, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameBetween(String value1, String value2) {
            addCriterion("work_type_name between", value1, value2, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameNotBetween(String value1, String value2) {
            addCriterion("work_type_name not between", value1, value2, "workTypeName");
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdCardLikeInsensitive(String value) {
            addCriterion("upper(id_card) like", value.toUpperCase(), "idCard");
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

        public Criteria andIdEndDateLikeInsensitive(String value) {
            addCriterion("upper(id_end_date) like", value.toUpperCase(), "idEndDate");
            return (Criteria) this;
        }

        public Criteria andIdBeginDateLikeInsensitive(String value) {
            addCriterion("upper(id_begin_date) like", value.toUpperCase(), "idBeginDate");
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

        public Criteria andRedPhotoLikeInsensitive(String value) {
            addCriterion("upper(red_photo) like", value.toUpperCase(), "redPhoto");
            return (Criteria) this;
        }

        public Criteria andVisiblePhotoFeatureLikeInsensitive(String value) {
            addCriterion("upper(visible_photo_feature) like", value.toUpperCase(), "visiblePhotoFeature");
            return (Criteria) this;
        }

        public Criteria andBelongIdLikeInsensitive(String value) {
            addCriterion("upper(belong_id) like", value.toUpperCase(), "belongId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdLikeInsensitive(String value) {
            addCriterion("upper(work_type_id) like", value.toUpperCase(), "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameLikeInsensitive(String value) {
            addCriterion("upper(work_type_name) like", value.toUpperCase(), "workTypeName");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
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