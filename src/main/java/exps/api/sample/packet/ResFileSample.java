package exps.api.sample.packet;



import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 * 샘플 객체
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Tag(name="샘플 파일 업로드 응답 객체")
public class ResFileSample {

    @Schema(title =  "이름")
    private String name;
    @Schema(title =  "전화번호")
    private String phoneNumber;
    @Schema(title =  "파일명")
    private String fileName;
    @Schema(title =  "파일다운로드URL")
    private String fileDownloadUri;
    @Schema(title =  "파일타입")
    private String fileType;
    @Schema(title =  "파일사이즈")
    private long size;
}
