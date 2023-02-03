package exps.component.code.packet;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Tag(name="공통 상세 코드 등록 요청")
public class ReqCommonDetailCodeRegist {
    @NotEmpty(message = "공통상세코드 명은 필수 입력값 입니다")
    @Schema(description = "공통상세코드 명", required = true)
    private String detailCodeNm;
    @NotEmpty(message = "공통상세코드 영문명은 필수 입력값 입니다")
    @Schema(description = "공통상세코드 영문명", required = true)
    private String detailCodeEngNm;
    @Schema(description = "공통상세코드 설명")
    private String detailCodeDc;
    @Schema(description = "정렬순서")
    private Integer order;
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

    public ReqCommonDetailCodeRegist(@NotEmpty String detailCodeNm, @NotEmpty String detailCodeEngNm, String detailCodeDc, Integer order, String etc1, String etc2, String etc3, String etc4, String etc5) {
        this.detailCodeNm = detailCodeNm;
        this.detailCodeEngNm = detailCodeEngNm;
        this.detailCodeDc = detailCodeDc;
        this.order = order;
        this.etc1 = etc1;
        this.etc2 = etc2;
        this.etc3 = etc3;
        this.etc4 = etc4;
        this.etc5 = etc5;
    }
}
