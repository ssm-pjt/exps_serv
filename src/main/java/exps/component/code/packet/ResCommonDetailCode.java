package exps.component.code.packet;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *  
 */
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Tag(name="공통 상세 코드 조회 응답")
public class ResCommonDetailCode {

    @Schema(description = "공통코드 ID")
    private Integer commonCodeId;
    @Schema(description = "공통상세코드")
    private Integer detailCode;
    @Schema(description = "공통상세코드 명")
    private String detailCodeNm;
    @Schema(description = "공통상세코드 영문명")
    private String detailCodeEngNm;
    @Schema(description = "공통상세코드 설명")
    private String detailCodeDc;
    @Schema(description = "정렬순서")
    private Integer order;
    @Schema(description = "사용여부", example = "true")
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
    @Schema(description = "생성자")
    private String createdId;
    @Schema(description = "생성일시")
    private LocalDateTime createdAt;
    @Schema(description = "수정자")
    private String updatedId;
    @Schema(description = "수정일시")
    private LocalDateTime updatedAt;

}
