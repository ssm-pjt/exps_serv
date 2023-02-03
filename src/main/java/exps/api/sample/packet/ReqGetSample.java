package exps.api.sample.packet;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import exps.api.sample.constant.Hobby;
import exps.api.sample.domain.GetSample;
import exps.api.sample.model.Address;

/**
 * 샘플 객체
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Tag(name="샘플 GET 요청 RequestParam 객체") // 모델명
public class ReqGetSample extends GetSample {

    @Schema(title =  "취미")
    private Hobby hobby;

    @Builder
    public ReqGetSample(Integer seq, @NotNull(message = "아이디는 필수 입력갑 입니다") String myId, @NotNull(message = "이름은 필수 입력값 입니다") String myName, @Min(value = 10, message = "나이는 최소 10살이상 입니다") Integer myAge, @Email(message = "이메일 형식에 맞게 입력하세요") String myEmail, @NotNull(message = "직업은 필수 입력값 입니다") String myJob, Address myAddress, Hobby hobby) {
        super(seq, myId, myName, myAge, myEmail, myJob, myAddress);
        this.hobby = hobby;
    }
}
