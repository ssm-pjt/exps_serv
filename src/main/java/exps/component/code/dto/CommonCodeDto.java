package exps.component.code.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

import exps.component.code.domain.CommonCode;
import exps.component.code.domain.CommonDetailCode;

/**
 * 공통 코드 DTO
 *  
 */
@Getter
@Setter
@ToString
public class CommonCodeDto {
    /* 공통 메인 코드 */
    private CommonCode code;
    /* 공통 상세 코드 */
    private CommonDetailCode detailCode;

    public CommonCodeDto() {
        this.code = new CommonCode();
        this.detailCode = new CommonDetailCode();
    }

    @Builder
    public CommonCodeDto(CommonCode code, CommonDetailCode detailCode) {
        this.code = Objects.isNull(code) ? new CommonCode() : code;
        this.detailCode = Objects.isNull(detailCode) ? new CommonDetailCode() : detailCode;
    }
}
