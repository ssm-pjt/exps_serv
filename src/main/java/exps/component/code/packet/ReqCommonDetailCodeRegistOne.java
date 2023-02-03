package exps.component.code.packet;

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
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Tag(name="공통 상세 코드 단건 등록 요청")
public class ReqCommonDetailCodeRegistOne extends ReqCommonDetailCodeRegist {

    @Schema(description = "공통코드 ID", hidden = true)
    private Integer commonCodeId;

    @Builder
    public ReqCommonDetailCodeRegistOne(String detailCodeNm, String detailCodeEngNm, String detailCodeDc, Integer order, String etc1, String etc2, String etc3, String etc4, String etc5, Integer commonCodeId) {
        super(detailCodeNm, detailCodeEngNm, detailCodeDc, order, etc1, etc2, etc3, etc4, etc5);
        this.commonCodeId = commonCodeId;
    }
}
