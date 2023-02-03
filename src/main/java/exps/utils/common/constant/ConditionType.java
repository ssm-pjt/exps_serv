package exps.utils.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 *  조건에 대한 상수
 *  
 *  조건 : ConditionType conditionType
 *  
 */
@Getter
@AllArgsConstructor
@ToString
public enum ConditionType {
    eq,				/* 같음 */
    notEqual,
    like,
    notLike,
    contains,
    startsWith,
    endsWith,
    in,
    notIn,
    isNull,
    isNotNull,
    between,
    notBetween,
    ne,
    lt,
    le,
    ge,
    lessThan,
    lessOrEqual,
    greaterThan,
    greaterOrEqual,
    isTrue,
    isFalse;
}
