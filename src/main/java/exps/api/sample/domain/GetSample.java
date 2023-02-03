package exps.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import exps.api.sample.model.Address;
import exps.api.sample.packet.ReqGetSample;
import exps.common.annotation.ParamName;
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
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Tag(name="샘플 GET RequestParam 객체 도메인") // 모델명
@JsonInclude(Include.ALWAYS)
public class GetSample {
    @Schema(title =  "순번", description = "순번 데이터", example = "1")
    protected Integer seq;
    @NotNull(message = "아이디는 필수 입력갑 입니다")
    /*
        @ApiModelProperty 사용법
        value - 파라메터 이름
        name - Swagger에서 입력 받을 리얼 파라메터 명
        description - 부가설명
        example - 지정된 임의 테스트 값을 입력 함
        required - 필수 입력 여부

     */
    @Schema(title = "아이디", name = "my_id", description = "이곳에 아이디를 넣어주세요", example = "abcd", required = true)
    @ParamName("my_id") // my_id 로 들어온 파라메터를 myId에 맵핑 시켜준다
    protected String myId;

    @NotNull(message = "이름은 필수 입력값 입니다")
    @Schema(title = "이름", name = "my_name", description = "이곳에 이름을 넣어주세요", example = "홍길동", required = true)
    @ParamName("my_name")
    protected String myName;

    @Min(value = 10, message = "나이는 최소 10살이상 입니다")
    @Schema(title = "나이\n최소 10살이상", name = "my_age", description = "나이는 최소 10살이상 입니다", example = "10")
    @ParamName("my_age")
    protected Integer myAge;

    @Email(message = "이메일 형식에 맞게 입력하세요")
    @Schema(title = "이메일\n이메일 형식에 맞게 입력", name = "my_email", description = "이메일 형식에 맞게 입력해주세요",example = "abc@company.com")
    @ParamName("my_email")
    protected String myEmail;

    @NotNull(message = "직업은 필수 입력값 입니다")
    @Schema(title = "직업",name = "my_job", description = "직업을 입력하세요", example = "developer", required = true)
    @ParamName("my_job")
    protected String myJob;

    //내부 객체는 @ParamName이 먹히지 않는다 방법을 연구해봐야 한다
    //그냥 myAddress.city 이런 형식으로만 받을 수 있다
    @Schema(title = "주소", name = "my_address")
    @ParamName("my_address")
    protected Address myAddress;

    public GetSample(ReqGetSample reqGetSample) {
        this.seq = reqGetSample.getSeq();
        this.myId = reqGetSample.getMyId();
        this.myName = reqGetSample.getMyName();
        this.myAge = reqGetSample.getMyAge();
        this.myEmail = reqGetSample.getMyEmail();
        this.myJob = reqGetSample.getMyJob();
        this.myAddress = reqGetSample.getMyAddress();
    }
}
