package exps.api.sample.packet;



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
@Tag(name="파일 업로드 요청 객체")
public class ReqJsonFileSample {

    @Schema(title =  "이름", example = "아이언맨")
    protected String name;
    @Schema(title =  "전화번호", example = "010-1111-1111")
    protected String phoneNumber;

}