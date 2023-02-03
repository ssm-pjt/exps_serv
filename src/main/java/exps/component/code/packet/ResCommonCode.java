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
@Tag(name="공통 메인 코드 조회 응답")
public class ResCommonCode {
    @Schema(description = "공통코드 ID")
    private Integer id;
    @Schema(description = "공통그룹코드 (식별을 위한 하위 그룹코드와 동일한 영문단어 또는 이니셜)")
    private String groupCode;
    @Schema(description = "공통코드(공통코드 ID 하위의 단순증가값)")
    private Integer code;
    @Schema(description = "공통코드명")
    private String codeNm;
    @Schema(description = "공통코드 영문명")
    private String codeEngNm;
    @Schema(description = "공통코드 설명")
    private String codeDc;
    @Schema(description = "상위공통코드 ID")
    private Integer upperId;
    @Schema(description = "뎁스")
    private Integer depth;
    @Schema(description = "정렬순서")
    private Integer order;
    @Schema(description = "공통코드 ID 경로")
    private String path ;
    @Schema(description = "공통코드명 경로")
    private String pathNm;
    @Schema(description = "사용여부", example = "true")
    private Boolean enabled;
    @Schema(description = "생성자")
    private String createdId;
    @Schema(description = "생성일시")
    private LocalDateTime createdAt;
    @Schema(description = "수정자")
    private String updatedId;
    @Schema(description = "수정일시")
    private LocalDateTime updatedAt;
}
