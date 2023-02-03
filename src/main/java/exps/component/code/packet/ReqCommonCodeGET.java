package exps.component.code.packet;

import exps.common.annotation.ParamName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 *  
 */
@Tag(name="공통 메인 코드 조회 요청")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReqCommonCodeGET {
	@Schema(description = "공통코드 ID")
    private Integer id;
    @Schema(description = "공통그룹코드 (식별을 위한 하위 그룹코드와 동일한 영문단어 또는 이니셜)", name = "group_code")
    @ParamName("group_code")
    private String groupCode;
    @Schema(description = "공통코드(공통코드 ID 하위의 단순증가값)")
    private Integer code;
    @Schema(description = "공통코드명", name = "code_nm")
    @ParamName("code_nm")
    private String codeNm;
    @Schema(description = "공통코드 영문명", name = "code_eng_nm")
    @ParamName("code_eng_nm")
    private String codeEngNm;
    @Schema(description = "공통코드 설명", name = "code_dc")
    @ParamName("code_dc")
    private String codeDc;
    @Schema(description = "상위공통코드 ID", name = "upper_id")
    @ParamName("upper_id")
    private Integer upperId;
    @Schema(description = "뎁스")
    private Integer depth;
    @Schema(description = "정렬순서")
    private Integer order;
    @Schema(description = "사용여부", example = "true")
    private Boolean enabled;
}
