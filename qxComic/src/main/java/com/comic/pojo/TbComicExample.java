package com.comic.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbComicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbComicExample() {
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

        public Criteria andComicidIsNull() {
            addCriterion("comicId is null");
            return (Criteria) this;
        }

        public Criteria andComicidIsNotNull() {
            addCriterion("comicId is not null");
            return (Criteria) this;
        }

        public Criteria andComicidEqualTo(Integer value) {
            addCriterion("comicId =", value, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidNotEqualTo(Integer value) {
            addCriterion("comicId <>", value, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidGreaterThan(Integer value) {
            addCriterion("comicId >", value, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidGreaterThanOrEqualTo(Integer value) {
            addCriterion("comicId >=", value, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidLessThan(Integer value) {
            addCriterion("comicId <", value, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidLessThanOrEqualTo(Integer value) {
            addCriterion("comicId <=", value, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidIn(List<Integer> values) {
            addCriterion("comicId in", values, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidNotIn(List<Integer> values) {
            addCriterion("comicId not in", values, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidBetween(Integer value1, Integer value2) {
            addCriterion("comicId between", value1, value2, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicidNotBetween(Integer value1, Integer value2) {
            addCriterion("comicId not between", value1, value2, "comicid");
            return (Criteria) this;
        }

        public Criteria andComicnameIsNull() {
            addCriterion("comicName is null");
            return (Criteria) this;
        }

        public Criteria andComicnameIsNotNull() {
            addCriterion("comicName is not null");
            return (Criteria) this;
        }

        public Criteria andComicnameEqualTo(String value) {
            addCriterion("comicName =", value, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameNotEqualTo(String value) {
            addCriterion("comicName <>", value, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameGreaterThan(String value) {
            addCriterion("comicName >", value, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameGreaterThanOrEqualTo(String value) {
            addCriterion("comicName >=", value, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameLessThan(String value) {
            addCriterion("comicName <", value, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameLessThanOrEqualTo(String value) {
            addCriterion("comicName <=", value, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameLike(String value) {
            addCriterion("comicName like", value, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameNotLike(String value) {
            addCriterion("comicName not like", value, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameIn(List<String> values) {
            addCriterion("comicName in", values, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameNotIn(List<String> values) {
            addCriterion("comicName not in", values, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameBetween(String value1, String value2) {
            addCriterion("comicName between", value1, value2, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicnameNotBetween(String value1, String value2) {
            addCriterion("comicName not between", value1, value2, "comicname");
            return (Criteria) this;
        }

        public Criteria andComicdptnIsNull() {
            addCriterion("comicDptn is null");
            return (Criteria) this;
        }

        public Criteria andComicdptnIsNotNull() {
            addCriterion("comicDptn is not null");
            return (Criteria) this;
        }

        public Criteria andComicdptnEqualTo(String value) {
            addCriterion("comicDptn =", value, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnNotEqualTo(String value) {
            addCriterion("comicDptn <>", value, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnGreaterThan(String value) {
            addCriterion("comicDptn >", value, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnGreaterThanOrEqualTo(String value) {
            addCriterion("comicDptn >=", value, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnLessThan(String value) {
            addCriterion("comicDptn <", value, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnLessThanOrEqualTo(String value) {
            addCriterion("comicDptn <=", value, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnLike(String value) {
            addCriterion("comicDptn like", value, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnNotLike(String value) {
            addCriterion("comicDptn not like", value, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnIn(List<String> values) {
            addCriterion("comicDptn in", values, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnNotIn(List<String> values) {
            addCriterion("comicDptn not in", values, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnBetween(String value1, String value2) {
            addCriterion("comicDptn between", value1, value2, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicdptnNotBetween(String value1, String value2) {
            addCriterion("comicDptn not between", value1, value2, "comicdptn");
            return (Criteria) this;
        }

        public Criteria andComicauthIsNull() {
            addCriterion("comicAuth is null");
            return (Criteria) this;
        }

        public Criteria andComicauthIsNotNull() {
            addCriterion("comicAuth is not null");
            return (Criteria) this;
        }

        public Criteria andComicauthEqualTo(String value) {
            addCriterion("comicAuth =", value, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthNotEqualTo(String value) {
            addCriterion("comicAuth <>", value, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthGreaterThan(String value) {
            addCriterion("comicAuth >", value, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthGreaterThanOrEqualTo(String value) {
            addCriterion("comicAuth >=", value, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthLessThan(String value) {
            addCriterion("comicAuth <", value, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthLessThanOrEqualTo(String value) {
            addCriterion("comicAuth <=", value, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthLike(String value) {
            addCriterion("comicAuth like", value, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthNotLike(String value) {
            addCriterion("comicAuth not like", value, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthIn(List<String> values) {
            addCriterion("comicAuth in", values, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthNotIn(List<String> values) {
            addCriterion("comicAuth not in", values, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthBetween(String value1, String value2) {
            addCriterion("comicAuth between", value1, value2, "comicauth");
            return (Criteria) this;
        }

        public Criteria andComicauthNotBetween(String value1, String value2) {
            addCriterion("comicAuth not between", value1, value2, "comicauth");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("classId is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classId is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Integer value) {
            addCriterion("classId =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Integer value) {
            addCriterion("classId <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Integer value) {
            addCriterion("classId >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classId >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Integer value) {
            addCriterion("classId <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Integer value) {
            addCriterion("classId <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Integer> values) {
            addCriterion("classId in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Integer> values) {
            addCriterion("classId not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Integer value1, Integer value2) {
            addCriterion("classId between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("classId not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andComiccoverIsNull() {
            addCriterion("comicCover is null");
            return (Criteria) this;
        }

        public Criteria andComiccoverIsNotNull() {
            addCriterion("comicCover is not null");
            return (Criteria) this;
        }

        public Criteria andComiccoverEqualTo(String value) {
            addCriterion("comicCover =", value, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverNotEqualTo(String value) {
            addCriterion("comicCover <>", value, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverGreaterThan(String value) {
            addCriterion("comicCover >", value, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverGreaterThanOrEqualTo(String value) {
            addCriterion("comicCover >=", value, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverLessThan(String value) {
            addCriterion("comicCover <", value, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverLessThanOrEqualTo(String value) {
            addCriterion("comicCover <=", value, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverLike(String value) {
            addCriterion("comicCover like", value, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverNotLike(String value) {
            addCriterion("comicCover not like", value, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverIn(List<String> values) {
            addCriterion("comicCover in", values, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverNotIn(List<String> values) {
            addCriterion("comicCover not in", values, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverBetween(String value1, String value2) {
            addCriterion("comicCover between", value1, value2, "comiccover");
            return (Criteria) this;
        }

        public Criteria andComiccoverNotBetween(String value1, String value2) {
            addCriterion("comicCover not between", value1, value2, "comiccover");
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