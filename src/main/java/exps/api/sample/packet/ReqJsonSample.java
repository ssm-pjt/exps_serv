package exps.api.sample.packet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import exps.api.sample.constant.Hobby;
import exps.api.sample.domain.JsonSample;
import exps.api.sample.model.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 샘플 객체
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Tag(name="샘플 POST 요청 RequestBody 객체") // 모델명
@JsonInclude(Include.ALWAYS)
public class ReqJsonSample extends JsonSample {

    @Schema(title =  "취미")
    private Hobby hobby;

    @Builder
    public ReqJsonSample(Integer seq, @NotNull String myId, @NotNull String myName, @Min(10) Integer myAge, @Email String myEmail, @NotNull String myJob, Address myAddress, Hobby hobby) {
        super(seq, myId, myName, myAge, myEmail, myJob, myAddress);
        this.hobby = hobby;
    }
}
