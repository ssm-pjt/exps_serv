package exps.component.code.packet;

import java.time.LocalDateTime;

import exps.common.annotation.ParamName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@ToString
@Builder
@Tag(name="공통 상세 코드 조회 요청")
public class ReqCommonDetailCodeGET {

    @Schema(description = "공통코드 ID", name = "common_code_id", example = "1")
    @ParamName("common_code_id")
    private Integer commonCodeId;
    @Schema(description = "공통상세코드", name = "detail_code", example = "1")
    @ParamName("detail_code")
    private Integer detailCode;
    @Schema(description = "공통상세코드 명", name = "detail_code_nm")
    @ParamName("detail_code_nm")
    private String detailCodeNm;
    @Schema(description = "공통상세코드 영문명", name = "detail_code_eng_nm")
    @ParamName("detail_code_eng_nm")
    private String detailCodeEngNm;
    @Schema(description = "공통상세코드 설명", name = "detail_code_dc")
    @ParamName("detail_code_dc")
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
    @Schema(description = "생성자", name = "created_id")
    @ParamName("created_id")
    private String createdId;
    @Schema(description = "생성일시", name = "created_at")
    @ParamName("created_at")
    private LocalDateTime createdAt;
    @Schema(description = "수정자", name = "updated_id")
    @ParamName("updated_id")
    private String updatedId;
    @Schema(description = "수정일시", name = "updated_at")
    @ParamName("updated_at")
    private LocalDateTime updatedAt;
}
