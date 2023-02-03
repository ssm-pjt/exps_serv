package exps.api.sample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 * 도메인에 공통 적으로 사용되는 객체는 모델에 정의
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Tag(name="샘플 모델 객체") // 모델명
@JsonInclude(Include.ALWAYS)
public class Address {

    @NotEmpty
    @Schema(title =  "국가", description = "국가 입력", example = "한국")
    //@JsonProperty("country")
    private String country;

    @NotEmpty
    @Schema(title =  "시도", description = "시도 입력", example = "서울")
    //@JsonProperty("state")
    private String state;

    @NotEmpty
    @Schema(title =  "면읍구군시", description = "면읍구군시 입력", example = "영등포구")
    //@JsonProperty("city")
    private String city;

    @NotEmpty
    @Schema(title =  "우편번호", defaultValue = "zip_code", description = "우편번호 입력", example = "07276")
    @JsonProperty("zip_code")
    private String zipCode;

    @Builder
    public Address(final String country, final String state, final String city, final String zipCode) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    /*
    public String getFullAddress() {
        return String.format("%s %s %s", this.state, this.city, this.zipCode);
    }
    */
}