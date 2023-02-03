package exps.api.sample.domain;

import exps.api.sample.model.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 * 샘플 도메인 객체
 * DB 컬럼과 일치하는 도메인 객체를 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Tag(name="샘플 Domain 객체") // 모델명
public class Sample {
    /*
        @ApiModelProperty 사용법
        value - 파라메터 이름
        name - Swagger에서 입력 받을 리얼 파라메터 명
        description - 부가설명
        example - 지정된 임의 테스트 값을 입력 함
        required - 필수 입력 여부

     */
    @Schema(title =  "아이디", description = "이곳에 아이디를 넣어주세요", example = "abcd", required = true)
    private String myId;

    @Schema(title =  "이름", description = "이곳에 이름을 넣어주세요", example = "홍길동", required = true)
    private String myName;

    @Schema(title =  "나이\n최소 10살이상", description = "나이는 최소 10살이상 입니다", example = "10")
    private Integer myAge;

    @Schema(title =  "이메일\n이메일 형식에 맞게 입력", description = "이메일 형식에 맞게 입력",example = "abc@company.com")
    private String myEmail;

    @Schema(title =  "직업", description = "농부, 광부, 개발자", example = "developer", required = true)
    private String myJob;

    @Schema(title =  "주소", description = "county, state, city, zipCode")
    private Address myAddress;
}
