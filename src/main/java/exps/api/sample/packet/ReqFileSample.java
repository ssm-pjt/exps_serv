package exps.api.sample.packet;



import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 샘플 객체
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Tag(name="파일 업로드 요청 객체")
public class ReqFileSample extends ReqJsonFileSample {
    @Schema(title =  "업로드 단건파일")
    private MultipartFile file;
    @Schema(title =  "업로드 다중파일")
    private MultipartFile[] files;

    @Builder
    public ReqFileSample(String name, String phoneNumber, MultipartFile file, MultipartFile[] files) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.file = file;
        this.files = files;
    }
}