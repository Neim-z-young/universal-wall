package com.freeLearn.wall.model;

import java.util.ArrayList;
import java.util.List;

public class PostingStatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostingStatisticExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andThemeIdIsNull() {
            addCriterion("theme_id is null");
            return (Criteria) this;
        }

        public Criteria andThemeIdIsNotNull() {
            addCriterion("theme_id is not null");
            return (Criteria) this;
        }

        public Criteria andThemeIdEqualTo(Integer value) {
            addCriterion("theme_id =", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotEqualTo(Integer value) {
            addCriterion("theme_id <>", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdGreaterThan(Integer value) {
            addCriterion("theme_id >", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("theme_id >=", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLessThan(Integer value) {
            addCriterion("theme_id <", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLessThanOrEqualTo(Integer value) {
            addCriterion("theme_id <=", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdIn(List<Integer> values) {
            addCriterion("theme_id in", values, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotIn(List<Integer> values) {
            addCriterion("theme_id not in", values, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdBetween(Integer value1, Integer value2) {
            addCriterion("theme_id between", value1, value2, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("theme_id not between", value1, value2, "themeId");
            return (Criteria) this;
        }

        public Criteria andClickTimesIsNull() {
            addCriterion("click_times is null");
            return (Criteria) this;
        }

        public Criteria andClickTimesIsNotNull() {
            addCriterion("click_times is not null");
            return (Criteria) this;
        }

        public Criteria andClickTimesEqualTo(Integer value) {
            addCriterion("click_times =", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesNotEqualTo(Integer value) {
            addCriterion("click_times <>", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesGreaterThan(Integer value) {
            addCriterion("click_times >", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_times >=", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesLessThan(Integer value) {
            addCriterion("click_times <", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesLessThanOrEqualTo(Integer value) {
            addCriterion("click_times <=", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesIn(List<Integer> values) {
            addCriterion("click_times in", values, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesNotIn(List<Integer> values) {
            addCriterion("click_times not in", values, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesBetween(Integer value1, Integer value2) {
            addCriterion("click_times between", value1, value2, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("click_times not between", value1, value2, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andLastModifyIsNull() {
            addCriterion("last_modify is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyIsNotNull() {
            addCriterion("last_modify is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyEqualTo(Integer value) {
            addCriterion("last_modify =", value, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyNotEqualTo(Integer value) {
            addCriterion("last_modify <>", value, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyGreaterThan(Integer value) {
            addCriterion("last_modify >", value, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_modify >=", value, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyLessThan(Integer value) {
            addCriterion("last_modify <", value, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyLessThanOrEqualTo(Integer value) {
            addCriterion("last_modify <=", value, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyIn(List<Integer> values) {
            addCriterion("last_modify in", values, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyNotIn(List<Integer> values) {
            addCriterion("last_modify not in", values, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyBetween(Integer value1, Integer value2) {
            addCriterion("last_modify between", value1, value2, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastModifyNotBetween(Integer value1, Integer value2) {
            addCriterion("last_modify not between", value1, value2, "lastModify");
            return (Criteria) this;
        }

        public Criteria andLastViewIsNull() {
            addCriterion("last_view is null");
            return (Criteria) this;
        }

        public Criteria andLastViewIsNotNull() {
            addCriterion("last_view is not null");
            return (Criteria) this;
        }

        public Criteria andLastViewEqualTo(Integer value) {
            addCriterion("last_view =", value, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewNotEqualTo(Integer value) {
            addCriterion("last_view <>", value, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewGreaterThan(Integer value) {
            addCriterion("last_view >", value, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_view >=", value, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewLessThan(Integer value) {
            addCriterion("last_view <", value, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewLessThanOrEqualTo(Integer value) {
            addCriterion("last_view <=", value, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewIn(List<Integer> values) {
            addCriterion("last_view in", values, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewNotIn(List<Integer> values) {
            addCriterion("last_view not in", values, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewBetween(Integer value1, Integer value2) {
            addCriterion("last_view between", value1, value2, "lastView");
            return (Criteria) this;
        }

        public Criteria andLastViewNotBetween(Integer value1, Integer value2) {
            addCriterion("last_view not between", value1, value2, "lastView");
            return (Criteria) this;
        }

        public Criteria andPosterIdIsNull() {
            addCriterion("poster_id is null");
            return (Criteria) this;
        }

        public Criteria andPosterIdIsNotNull() {
            addCriterion("poster_id is not null");
            return (Criteria) this;
        }

        public Criteria andPosterIdEqualTo(Integer value) {
            addCriterion("poster_id =", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdNotEqualTo(Integer value) {
            addCriterion("poster_id <>", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdGreaterThan(Integer value) {
            addCriterion("poster_id >", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("poster_id >=", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdLessThan(Integer value) {
            addCriterion("poster_id <", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdLessThanOrEqualTo(Integer value) {
            addCriterion("poster_id <=", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdIn(List<Integer> values) {
            addCriterion("poster_id in", values, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdNotIn(List<Integer> values) {
            addCriterion("poster_id not in", values, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdBetween(Integer value1, Integer value2) {
            addCriterion("poster_id between", value1, value2, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("poster_id not between", value1, value2, "posterId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
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