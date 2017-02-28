package com.comic.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbEpisodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEpisodeExample() {
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

        public Criteria andEpisodeidIsNull() {
            addCriterion("episodeId is null");
            return (Criteria) this;
        }

        public Criteria andEpisodeidIsNotNull() {
            addCriterion("episodeId is not null");
            return (Criteria) this;
        }

        public Criteria andEpisodeidEqualTo(Integer value) {
            addCriterion("episodeId =", value, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidNotEqualTo(Integer value) {
            addCriterion("episodeId <>", value, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidGreaterThan(Integer value) {
            addCriterion("episodeId >", value, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("episodeId >=", value, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidLessThan(Integer value) {
            addCriterion("episodeId <", value, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidLessThanOrEqualTo(Integer value) {
            addCriterion("episodeId <=", value, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidIn(List<Integer> values) {
            addCriterion("episodeId in", values, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidNotIn(List<Integer> values) {
            addCriterion("episodeId not in", values, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidBetween(Integer value1, Integer value2) {
            addCriterion("episodeId between", value1, value2, "episodeid");
            return (Criteria) this;
        }

        public Criteria andEpisodeidNotBetween(Integer value1, Integer value2) {
            addCriterion("episodeId not between", value1, value2, "episodeid");
            return (Criteria) this;
        }

        public Criteria andSourceidIsNull() {
            addCriterion("sourceId is null");
            return (Criteria) this;
        }

        public Criteria andSourceidIsNotNull() {
            addCriterion("sourceId is not null");
            return (Criteria) this;
        }

        public Criteria andSourceidEqualTo(Integer value) {
            addCriterion("sourceId =", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidNotEqualTo(Integer value) {
            addCriterion("sourceId <>", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidGreaterThan(Integer value) {
            addCriterion("sourceId >", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sourceId >=", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidLessThan(Integer value) {
            addCriterion("sourceId <", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidLessThanOrEqualTo(Integer value) {
            addCriterion("sourceId <=", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidIn(List<Integer> values) {
            addCriterion("sourceId in", values, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidNotIn(List<Integer> values) {
            addCriterion("sourceId not in", values, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidBetween(Integer value1, Integer value2) {
            addCriterion("sourceId between", value1, value2, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidNotBetween(Integer value1, Integer value2) {
            addCriterion("sourceId not between", value1, value2, "sourceid");
            return (Criteria) this;
        }

        public Criteria andEpisodenumIsNull() {
            addCriterion("episodeNum is null");
            return (Criteria) this;
        }

        public Criteria andEpisodenumIsNotNull() {
            addCriterion("episodeNum is not null");
            return (Criteria) this;
        }

        public Criteria andEpisodenumEqualTo(Integer value) {
            addCriterion("episodeNum =", value, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumNotEqualTo(Integer value) {
            addCriterion("episodeNum <>", value, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumGreaterThan(Integer value) {
            addCriterion("episodeNum >", value, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("episodeNum >=", value, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumLessThan(Integer value) {
            addCriterion("episodeNum <", value, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumLessThanOrEqualTo(Integer value) {
            addCriterion("episodeNum <=", value, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumIn(List<Integer> values) {
            addCriterion("episodeNum in", values, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumNotIn(List<Integer> values) {
            addCriterion("episodeNum not in", values, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumBetween(Integer value1, Integer value2) {
            addCriterion("episodeNum between", value1, value2, "episodenum");
            return (Criteria) this;
        }

        public Criteria andEpisodenumNotBetween(Integer value1, Integer value2) {
            addCriterion("episodeNum not between", value1, value2, "episodenum");
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