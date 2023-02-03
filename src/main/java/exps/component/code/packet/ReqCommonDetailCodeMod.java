package exps.component.code.packet;

import javax.validation.constraints.NotNull;

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
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ToString
@Tag(name="공통 상세 코드 수정 요청")
public class ReqCommonDetailCodeMod {
    @Schema(description = "공통코드 ID", hidden = true)
    private Integer commonCodeId;
    @NotNull
    @Schema(description = "공통상세코드", required = true)
    private Integer detailCode;
    @Schema(description = "공통상세코드 명")
    private String detailCodeNm;
    @Schema(description = "공통상세코드 영문명")
    private String detailCodeEngNm;
    @Schema(description = "공통상세코드 설명")
    private String detailCodeDc;
    @Schema(description = "정렬순서")
    private Integer order;
    @Schema(description = "사용여부")
    private Boolean enabled;
    @Schema(description = "기타1")
    private String etc1;
    @Schema(description = "기타2")
    private String etc2;
    @Schema(description = "기타3")
    private String etc3;
    @Schema(description = "기타4")
    private String etc4;
    @Schema(description = "기타5")
    private String etc5;

    @Builder
    public ReqCommonDetailCodeMod(@NotNull Integer commonCodeId, @NotNull Integer detailCode, String detailCodeNm, String detailCodeEngNm, String detailCodeDc, Integer order, Boolean enabled, String etc1, String etc2, String etc3, String etc4, String etc5) {
        this.commonCodeId = commonCodeId;
        this.detailCode = detailCode;
        this.detailCodeNm = detailCodeNm;
        this.detailCodeEngNm = detailCodeEngNm;
        this.detailCodeDc = detailCodeDc;
        this.order = order;
        this.enabled = enabled;
        this.etc1 = etc1;
        this.etc2 = etc2;
        this.etc3 = etc3;
        this.etc4 = etc4;
        this.etc5 = etc5;
    }
}
