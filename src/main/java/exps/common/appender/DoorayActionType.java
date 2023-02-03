package exps.common.appender;

/**
 * 두레이 Action Type 정의
 *
 *  
 */
public enum DoorayActionType {

    BUTTON("button"),
    SELECT("select");

    private String code;

    private DoorayActionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
