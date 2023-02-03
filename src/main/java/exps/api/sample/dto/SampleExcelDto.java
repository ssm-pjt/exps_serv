package exps.api.sample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.apache.poi.ss.usermodel.Row;

import exps.component.excel.utils.ExcelUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 엑셀 업로드 Sample DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Tag(name="Sample 엑셀 업로드 객체")
public class SampleExcelDto {
    @NotEmpty//(message = "이름은 필수 입력값 입니다")
    @Schema(title =  "이름")
    private String name;
    @Schema(title =  "이메일")
    private String email;
    @NotEmpty//(message = "전화번호는 필수 입력값입니다")
    @Schema(title =  "전화번호")
    private String phone;
    @NotEmpty//(message = "소속부서는 필수 입력값입니다")
    @Schema(title =  "소속부서")
    @Size(min = 1, max = 10)
    private String dept;
    @NotNull//(message = "업무코드는 필수 입력값입니다")
    @Schema(title =  "업무코드")
    private Integer workCode;
    @NotNull//(message = "부서코드는 필수 입력값입니다")
    @Schema(title =  "부서코드")
    private Integer deptCode;
    @Size(min = 1, max = 500)
    @Schema(title =  "내용")
    private String content;
    @Size(max = 15)
    @Pattern(regexp="(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])", message="IP 주소 형식이 올바르지 않습니다")
    @Schema(title =  "IP")
    private String ip;
    @Schema(title =  "소수")
    private Double percent;
    @Schema(title =  "날짜")
    private String createDate;
    @Schema(title =  "일시")
    private String updateDatetime;
    @Schema(title =  "빈데이터")
    private String emptyData;

    /**
     * 엑셀 업로드 처리를 위한 객체
     * @param row
     * @return
     */
    public static SampleExcelDto from(Row row) {
        return ExcelUtils.setObjectMapping(new SampleExcelDto(), row);
    }
}
