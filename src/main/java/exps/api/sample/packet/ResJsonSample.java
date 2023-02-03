package exps.api.sample.packet;

import exps.api.sample.constant.Hobby;
import exps.api.sample.domain.JsonSample;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 샘플 객체
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Tag(name="샘플 Json 응답 객체") // 모델명
public class ResJsonSample extends JsonSample {

    @Schema(title =  "취미")
    private Hobby hobby;

    public ResJsonSample(ReqJsonSample reqJsonSample) {
        super(reqJsonSample);
        this.hobby = reqJsonSample.getHobby();
    }
}
