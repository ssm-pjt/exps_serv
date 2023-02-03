package exps.component.code.packet;

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
@Setter
@Getter
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Tag(name="공통 메인 코드 수정 객체")
public class ReqCommonCodeMod {
    @Schema(description = "공통코드 ID", hidden = true)
    private Integer id;
    @Schema(description = "공통그룹코드 (식별을 위한 하위 그룹코드와 동일한 영문단어 또는 이니셜)")
    private String groupCode;
    @Schema(description = "공통코드명")
    private String codeNm;
    @Schema(description = "공통코드 영문명")
    private String codeEngNm;
    @Schema(description = "공통코드 설명")
    private String codeDc;
    @Schema(description = "상위공통코드 ID")
    private Integer upperId;
    @Schema(description = "정렬순서")
    private Integer order;
    @Schema(description = "사용여부")
    private Boolean enabled;
}
