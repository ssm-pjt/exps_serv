package exps.component.code.packet;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

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
@Tag(name="공통 상세 코드 다중 등록 요청")
public class ReqCommonDetailCodeRegistMulti extends ReqCommonDetailCodeRegist{

    @Builder
    public ReqCommonDetailCodeRegistMulti(String detailCodeNm, String detailCodeEngNm, String detailCodeDc, Integer order, String etc1, String etc2, String etc3, String etc4, String etc5) {
        super(detailCodeNm, detailCodeEngNm, detailCodeDc, order, etc1, etc2, etc3, etc4, etc5);
    }
}
