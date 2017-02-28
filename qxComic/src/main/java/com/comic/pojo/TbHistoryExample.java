package com.comic.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbHistoryExample() {
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

        public Criteria andHistoryidIsNull() {
            addCriterion("historyId is null");
            return (Criteria) this;
        }

        public Criteria andHistoryidIsNotNull() {
            addCriterion("historyId is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryidEqualTo(Integer value) {
            addCriterion("historyId =", value, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidNotEqualTo(Integer value) {
            addCriterion("historyId <>", value, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidGreaterThan(Integer value) {
            addCriterion("historyId >", value, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("historyId >=", value, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidLessThan(Integer value) {
            addCriterion("historyId <", value, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidLessThanOrEqualTo(Integer value) {
            addCriterion("historyId <=", value, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidIn(List<Integer> values) {
            addCriterion("historyId in", values, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidNotIn(List<Integer> values) {
            addCriterion("historyId not in", values, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidBetween(Integer value1, Integer value2) {
            addCriterion("historyId between", value1, value2, "historyid");
            return (Criteria) this;
        }

        public Criteria andHistoryidNotBetween(Integer value1, Integer value2) {
            addCriterion("historyId not between", value1, value2, "historyid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
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

        public Criteria andHistorylocationIsNull() {
            addCriterion("historyLocation is null");
            return (Criteria) this;
        }

        public Criteria andHistorylocationIsNotNull() {
            addCriterion("historyLocation is not null");
            return (Criteria) this;
        }

        public Criteria andHistorylocationEqualTo(String value) {
            addCriterion("historyLocation =", value, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationNotEqualTo(String value) {
            addCriterion("historyLocation <>", value, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationGreaterThan(String value) {
            addCriterion("historyLocation >", value, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationGreaterThanOrEqualTo(String value) {
            addCriterion("historyLocation >=", value, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationLessThan(String value) {
            addCriterion("historyLocation <", value, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationLessThanOrEqualTo(String value) {
            addCriterion("historyLocation <=", value, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationLike(String value) {
            addCriterion("historyLocation like", value, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationNotLike(String value) {
            addCriterion("historyLocation not like", value, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationIn(List<String> values) {
            addCriterion("historyLocation in", values, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationNotIn(List<String> values) {
            addCriterion("historyLocation not in", values, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationBetween(String value1, String value2) {
            addCriterion("historyLocation between", value1, value2, "historylocation");
            return (Criteria) this;
        }

        public Criteria andHistorylocationNotBetween(String value1, String value2) {
            addCriterion("historyLocation not between", value1, value2, "historylocation");
            return (Criteria) this;
        }

        public Criteria andViewtimeIsNull() {
            addCriterion("ViewTime is null");
            return (Criteria) this;
        }

        public Criteria andViewtimeIsNotNull() {
            addCriterion("ViewTime is not null");
            return (Criteria) this;
        }

        public Criteria andViewtimeEqualTo(String value) {
            addCriterion("ViewTime =", value, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeNotEqualTo(String value) {
            addCriterion("ViewTime <>", value, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeGreaterThan(String value) {
            addCriterion("ViewTime >", value, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ViewTime >=", value, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeLessThan(String value) {
            addCriterion("ViewTime <", value, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeLessThanOrEqualTo(String value) {
            addCriterion("ViewTime <=", value, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeLike(String value) {
            addCriterion("ViewTime like", value, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeNotLike(String value) {
            addCriterion("ViewTime not like", value, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeIn(List<String> values) {
            addCriterion("ViewTime in", values, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeNotIn(List<String> values) {
            addCriterion("ViewTime not in", values, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeBetween(String value1, String value2) {
            addCriterion("ViewTime between", value1, value2, "viewtime");
            return (Criteria) this;
        }

        public Criteria andViewtimeNotBetween(String value1, String value2) {
            addCriterion("ViewTime not between", value1, value2, "viewtime");
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