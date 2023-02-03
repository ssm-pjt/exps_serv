package exps.api.sample.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import exps.api.sample.dto.SampleExcelDto;
import exps.api.sample.packet.ReqJsonSample;
import exps.api.sample.service.SampleExcelService;
import exps.common.domain.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.examples.Example;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sample Excel 컨트롤러
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
@Tag(name = "Sample Excel API 컨트롤러", description = "Sample Excel API")
// @ApiIgnore
public class SampleExcelController {

    private final SampleExcelService sampleExcelService;

    @Operation(summary = "Sample 엑셀 양식 다운로드")
    @GetMapping("/excel")
    public ResponseEntity<Resource> getSampleExcel() throws IOException {
        return sampleExcelService.getSampleExcel();
    }

    @Operation(summary = "Sample 엑셀 업로드", tags = "KMS", description = "# Sample 엑셀 업로드를 테스트 해볼 수 있는 API\n" +
            "## 엑셀 업로드 공통 서비스 가이드\n" +
            "---\n" +
            "https://\n\n" +
            "## 사용예시\n" +
            "---\n" +
            "`List<SampleExcelDto> dataList = ExcelReader.getObjectList(multipartFile, SampleExcelDto::from);`")
    @ApiResponses({
            @ApiResponse(responseCode = "4010", content = @Content( mediaType = "읽을 수 없는 엑셀 파일 입니다 (DRM 적용 또는 다른이유)")),
            @ApiResponse(responseCode = "4010", content = @Content( mediaType = "읽을 수 없는 엑셀 파일 입니다 (DRM 적용 또는 다른이유)")),
            @ApiResponse(responseCode = "4011", content = @Content(schema = @Schema(implementation = Example.class)))
    })
    @PostMapping(value = "/excel", consumes = { MediaType.MULTIPART_MIXED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public CommonResult<List<SampleExcelDto>> insertEquipment(@Parameter(name = "JWT 토큰 - 요청시 전달 받아 ID를 추출한다")
                                                              @RequestHeader(value = "jwt", defaultValue = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbktleSI6IjIxMEJGMDY1LUFDRjMtNEUxQS04QTM4LThFRjQ0Mzg1NTM5QSIsImlkIjoieXNraW0iLCJuYW1lIjoiXHVhZTQwXHVjNzIwXHVjMTFkIiwiZGVwYXJ0bWVudF9jb2RlIjoiMTUwMTIiLCJkZXBhcnRtZW50X25hbWUiOiJcdWM2ZjlcdWQ1MDRcdWI4NjBcdWQyYjhcdWM1ZDRcdWI0ZGNcdWQzMGNcdWQyYjgiLCJlbXBsb3llZV9udW1iZXIiOiIyMDE3MDAyNCIsImVtYWlsIjoieXNraW1AaXBhcmtpbmcuY28ua3IiLCJwb3NpdGlvbl9jb2RlIjoiSjEiLCJwb3NpdGlvbl9uYW1lIjoiXHViOWU0XHViMmM4XHVjODAwIiwiZHV0eV9jb2RlIjoiTDIiLCJkdXR5X25hbWUiOiJcdWQzMDBcdWM2ZDAiLCJ0ZWFtX25hbWUiOm51bGwsInBhdGgiOiIxMDAwfDEwMDAwfDE1MDExfDE1MDEyIiwicGF0aF9uYW1lIjoiXHVkMzBjXHVkMGI5XHVkMDc0XHViNzdjXHVjNmIwXHViNGRjfFImRHxcdWQ1MDRcdWI4NjBcdWQyYjhcdWM1ZDRcdWI0ZGNcdWQzMDB8XHVjNmY5XHVkNTA0XHViODYwXHVkMmI4XHVjNWQ0XHViNGRjXHVkMzBjXHVkMmI4In0.bxBABM7tSoHyxMyfp2P89rQSGS_cWpAqc-1bcGDrbrY") String jwt,
                                                              @Parameter(name = "업로드 엑셀파일 - 업무에 해당하는 엑셀 업로드 양식을 다운 받아 양식에 맞게 작성한뒤 업로드해야함")
                                                              @RequestPart(value = "file") MultipartFile file) throws Exception {
        return sampleExcelService.excelUpload(jwt, file);
    }

    @Operation(summary = "Sample 엑셀 업로드 테스트", tags = "KMS")
    @PostMapping(value = "/excel", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public CommonResult<List<ReqJsonSample>> excelUpload(@Valid @RequestBody List<ReqJsonSample> samples,
                                                         WebRequest webRequest) throws Exception {
        return sampleExcelService.excelUpload(samples);
    }
}
