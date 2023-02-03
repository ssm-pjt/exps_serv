package exps.component.code.packet;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *  
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Tag(name="공통 메인 코드 등록 요청")
public class ReqCommonCodeRegist {
    @NotEmpty(message = "공통그룹코드는 필수 입력값 입니다")
    @Schema(description = "공통그룹코드 (식별을 위한 하위 그룹코드와 동일한 영문단어 또는 이니셜)")
    private String groupCode;
    @NotEmpty(message = "공통코드명은 필수 입력값 입니다")
    @Schema(description = "공통코드명")
    private String codeNm;
    @NotEmpty(message = "공통코드 영문명는 필수 입력값 입니다")
    @Schema(description = "공통코드 영문명")
    private String codeEngNm;
    @Schema(description = "공통코드 설명")
    private String codeDc;
    @Schema(description = "상위공통코드 ID")
    private Integer upperId;
    @Schema(description = "정렬순서")
    private Integer order;

    @Builder
    public ReqCommonCodeRegist(String groupCode, String codeNm, String codeEngNm, String codeDc, Integer upperId, Integer order) {
        this.groupCode = groupCode;
        this.codeNm = codeNm;
        this.codeEngNm = codeEngNm;
        this.codeDc = codeDc;
        this.upperId = upperId;
        this.order = order;
    }
}
