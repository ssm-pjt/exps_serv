package exps.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import exps.api.sample.model.Address;
import exps.api.sample.packet.ReqJsonSample;
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
@Tag(name="샘플 POST RequestBody 객체 도메인") // 모델명
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) //JSON 변환시 SnakeCase로 변환해줌
@JsonInclude(Include.ALWAYS)
public class JsonSample {
    @Schema(title =  "순번", description = "순번 데이터", example = "1")
    protected Integer seq;
    @NotNull
    /*
        @ApiModelProperty 사용법
        value - 파라메터 이름
        name - Swagger에서 입력 받을 리얼 파라메터 명
        description - 부가설명
        example - 지정된 임의 테스트 값을 입력 함
        required - 필수 입력 여부

     */
    @Schema(title =  "아이디", description = "이곳에 아이디를 넣어주세요", example = "abcd", required = true)
    // @JsonProperty("my_id")
    protected String myId;

    @NotNull
    @Schema(title =  "이름", description = "이곳에 이름을 넣어주세요", example = "홍길동", required = true)
    // @JsonProperty("my_name")
    protected String myName;

    @Min(10)
    @Schema(title =  "나이\n최소 10살이상", description = "나이는 최소 10살이상 입니다", example = "10")
    // @JsonProperty("my_age")
    protected Integer myAge;

    @Email
    @Schema(title =  "이메일\n이메일 형식에 맞게 입력", description = "이메일 형식에 맞게 입력해주세요",example = "abc@company.com")
    // @JsonProperty("my_email")
    protected String myEmail;

    @NotNull
    @Schema(title =  "직업", description = "직업을 입력하세요", example = "developer", required = true)
    // @JsonProperty("my_job")
    protected String myJob;

    @Schema(title =  "주소", description = "county, state, city, zipCode")
    // @JsonProperty("my_address")
    protected Address myAddress;

    public JsonSample(ReqJsonSample reqJsonSample) {
        this.seq = reqJsonSample.getSeq();
        this.myId = reqJsonSample.getMyId();
        this.myName = reqJsonSample.getMyName();
        this.myAge = reqJsonSample.getMyAge();
        this.myEmail = reqJsonSample.getMyEmail();
        this.myJob = reqJsonSample.myJob;
        this.myAddress = reqJsonSample.myAddress;
    }
}
