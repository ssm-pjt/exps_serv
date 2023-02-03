package exps.api.sample.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import exps.api.sample.packet.ReqFileDataFormSample;
import exps.api.sample.packet.ReqFileSample;
import exps.api.sample.packet.ReqJsonFileSample;
import exps.api.sample.packet.ResFileSample;
import exps.api.sample.service.SampleFileService;
import exps.common.domain.CommonResult;
import exps.utils.common.CommonUtils;
import exps.utils.common.JsonUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sample File 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping(value = "/sample/file")
@RequiredArgsConstructor
@Tag(name = "Sample File API 컨트롤러", description = "Sample File API")
public class SampleFileController {

    private final SampleFileService sampleFileService;

    @Operation(summary = "Sample File 업로드 기본",description = "한개의 파일 업로드시 사용")//, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
            @Parameter(name =  "Content-Type", content = @Content(mediaType = "multipart/form-data"), in = ParameterIn.HEADER)
    })
    @ApiResponse(responseCode = "200", description = "Not found", content = @Content(mediaType = "업로드 성공시 파일 업로드 파일정보 리턴"))
    @PostMapping//(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResFileSample> upload(@Parameter(name = "파일", required = true) @RequestPart(value = "file") MultipartFile file, HttpServletRequest request, WebRequest webRequest) throws IOException {
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", file, RequestAttributes.SCOPE_REQUEST);
        log.info("body = {}",file);
        return sampleFileService.upload(file, request, webRequest);
    }

    @Operation(summary = "Sample File 업로드 ModelAttribute",description = "한개의 파일 업로드와 추가적인 파라메터를 넘길때", method = MediaType.MULTIPART_FORM_DATA_VALUE ) //, produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
            @Parameter(name =  "Content-Type", content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE), in = ParameterIn.HEADER)// +","+MediaType.MULTIPART_MIXED_VALUE, in = ParameterIn.HEADER)
    })
    @ApiResponse(responseCode = "200", description = "Not found", content = @Content(mediaType = "업로드 성공시 파일 업로드 파일정보 리턴"))
    @PostMapping(value = "/mix")//, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})//, MediaType.MULTIPART_MIXED_VALUE})
    public ResponseEntity<ResFileSample> mixUpload(@Parameter(name = "파일 객체", required = true)
                                                   @ModelAttribute ReqFileSample reqFileSample, HttpServletRequest request, WebRequest webRequest) throws IOException {
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", reqFileSample, RequestAttributes.SCOPE_REQUEST);
        log.info("body = {}",reqFileSample);
        return sampleFileService.mixUpload(reqFileSample, request, webRequest);
    }

    @Operation(summary = "Sample File 업로드 ModelAttribute CommonResult 리턴",description = "여러개의 파일 업로드와 추가적인 파라메터를 넘길때", method = MediaType.MULTIPART_FORM_DATA_VALUE) //, produces = MediaType.APPLICATION_JSON_VALUE)

    @Parameters({
            @Parameter(name =  "Content-Type", content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE), in = ParameterIn.HEADER)// +","+MediaType.MULTIPART_MIXED_VALUE, in = ParameterIn.HEADER)
    })
    @ApiResponse(responseCode = "200", description = "Not found", content = @Content(mediaType = "업로드 성공시 파일 업로드 파일정보 리턴"))
    @PostMapping(value = "/mixmap")//, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})//, MediaType.MULTIPART_MIXED_VALUE})
    public CommonResult<?> mixMapUpload(@Parameter(name = "파일 객체", required = true)
                                        @ModelAttribute ReqFileSample reqFileSample, HttpServletRequest request, WebRequest webRequest) throws Exception {
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", reqFileSample, RequestAttributes.SCOPE_REQUEST);
        log.info("body = {}",reqFileSample);
        return sampleFileService.mixMapUpload(reqFileSample, request, webRequest);
    }

    @Operation(summary = "Sample File 단일 업로드 JSON",description = "한개의 파일 업로드와 추가적인 파라메터를 넘길때", method = MediaType.MULTIPART_FORM_DATA_VALUE+","+MediaType.MULTIPART_MIXED_VALUE) //, produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
            @Parameter(name =  "Content-Type", content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE+","+MediaType.MULTIPART_MIXED_VALUE), in = ParameterIn.HEADER)// +","+MediaType.MULTIPART_MIXED_VALUE, in = ParameterIn.HEADER)
    })
    @ApiResponse(responseCode = "200", description = "Not found", content = @Content(mediaType = "업로드 성공시 파일 업로드 파일정보 리턴"))
    @PostMapping(value = "/mixjson", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_MIXED_VALUE})//, MediaType.MULTIPART_MIXED_VALUE})
    public CommonResult<?> mixJsonMapUpload(@Parameter(name = "파일", required = true) @RequestPart(value = "file") MultipartFile file,
                                            @Parameter(name = "요청 JSON\n" +
                                                    "예시 - {\"name\":\"아이언맨\", \"phoneNumber\":\"010-1111-1111\"}", required = false) @RequestParam("params") String params,
                                            // @Parameter(name = "이름", required = false) @RequestParam("name") String name,
                                            HttpServletRequest request, WebRequest webRequest) throws Exception {
        ReqJsonFileSample jsonData = JsonUtils.getObjectMapper().readValue(params, ReqJsonFileSample.class);
        log.info("## jsonData = {}",jsonData);
        ReqFileSample reqFileSample = new ReqFileSample();
        CommonUtils.parentObjectToDto(jsonData, reqFileSample);
        reqFileSample.setFile(file);
        return sampleFileService.mixJsonOneMapUpload(reqFileSample, request, webRequest);
    }

    @Operation(summary = "Sample File 멀티 업로드 JSON",description = "여러개의 파일 업로드와 추가적인 파라메터를 넘길때", method = MediaType.MULTIPART_FORM_DATA_VALUE+","+MediaType.MULTIPART_MIXED_VALUE) //, produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
            @Parameter(name =  "Content-Type", content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE+","+MediaType.MULTIPART_MIXED_VALUE), in = ParameterIn.HEADER)// +","+MediaType.MULTIPART_MIXED_VALUE, in = ParameterIn.HEADER)
    })
    @ApiResponse(responseCode = "200", description = "Not found", content = @Content(mediaType = "업로드 성공시 파일 업로드 파일정보 리턴"))
    @PostMapping(value = "/mixjson-multi", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_MIXED_VALUE})//, MediaType.MULTIPART_MIXED_VALUE})
    public CommonResult<?> mixJsonMultiMapUpload(@Parameter(name = "파일", required = true) @RequestPart(value = "files") MultipartFile[] files,
                                                 @Parameter(name = "요청 JSON\n" +
                                                         "예시 - {\"name\":\"아이언맨\", \"phoneNumber\":\"010-1111-1111\"}", required = false)
                                                 @RequestParam("params") String params,
                                                 // @Parameter(name = "이름", required = false) @RequestParam("name") String name,
                                                 HttpServletRequest request, WebRequest webRequest) throws Exception {
        ReqJsonFileSample jsonData = JsonUtils.getObjectMapper().readValue(params, ReqJsonFileSample.class);
        log.info("## jsonData = {}",jsonData);
        ReqFileSample reqFileSample = new ReqFileSample();
        CommonUtils.parentObjectToDto(jsonData, reqFileSample);
        reqFileSample.setFiles(files);
        return sampleFileService.mixJsonMultiMapUpload(reqFileSample, request, webRequest);
    }

    @Operation(summary = "Sample File 다중 업로드 기본",description = "여러개의 파일 업로드시 사용")//, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    /*
    @Parameters({
            @Parameter(name =  "Content-Type", defaultValue = "multipart/form-data", in = ParameterIn.HEADER)
    })
    */
    @ApiResponse(responseCode = "200", description = "Not found", content = @Content(mediaType = "업로드 성공시 파일 업로드 파일정보 리턴"))
    @PostMapping("/multi")//(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<ResFileSample>> multiUpload(@Parameter(name = "파일 리스트", required = true)
                                                           @RequestPart(value = "files") MultipartFile[] files, HttpServletRequest request, WebRequest webRequest) throws IOException {
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", files, RequestAttributes.SCOPE_REQUEST);
        log.info("body = {}",files);
        return sampleFileService.multiUpload(files, request, webRequest);
    }

    @Operation(summary = "Sample File 다중 업로드 ModelAttribute CommonResult 리턴",description = "한개의 파일 업로드와 추가적인 파라메터를 넘길때", method = MediaType.MULTIPART_FORM_DATA_VALUE) //, produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
            @Parameter(name =  "Content-Type", content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE), in = ParameterIn.HEADER)// +","+MediaType.MULTIPART_MIXED_VALUE, in = ParameterIn.HEADER)
    })
    @ApiResponses({@ApiResponse(responseCode = "200", content = @Content(mediaType = "업로드 성공시 파일 업로드 파일정보 리턴"))})
    @PostMapping(value = "/multi/mixmap")//, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})//, MediaType.MULTIPART_MIXED_VALUE})
    public CommonResult<?> mixMapMultiUpload(@Parameter(name = "파일 객체", required = true)
                                             @ModelAttribute ReqFileSample reqFileSample, HttpServletRequest request, WebRequest webRequest) throws Exception {
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", reqFileSample, RequestAttributes.SCOPE_REQUEST);
        log.info("body = {}",reqFileSample);
        return sampleFileService.mixMapMultiUpload(reqFileSample, request, webRequest);
    }

    @Operation(summary = "Sample File 다운로드(Resource)", description = "파일을 다운로드(Resource 형태로 반환)")
    @Parameters({
            @Parameter(name =  "fileName", content = @Content(mediaType = "파일명"), ref = "string")
    })
    @GetMapping
    public ResponseEntity<Resource> download(@RequestParam("fileName") String fileName) throws IOException {
        return sampleFileService.download(fileName);
    }

    @Operation(summary = "Sample File 업로드 ModelAttribute 리스트",description = "리스트로 파일과 데이터를 전송할 때", method = MediaType.MULTIPART_FORM_DATA_VALUE ) //, produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
            @Parameter(name =  "Content-Type", content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE), in = ParameterIn.HEADER)// +","+MediaType.MULTIPART_MIXED_VALUE, in = ParameterIn.HEADER)
    })
    @ApiResponse(responseCode = "200", description = "Not found", content = @Content(mediaType = "업로드 성공시 파일 업로드 파일정보 리턴"))
    @PostMapping(value = "/listform")//, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})//, MediaType.MULTIPART_MIXED_VALUE})
    public ResponseEntity<List<Map<String, String>>> listForm(@Parameter(name = "파일 객체", required = true)
                                                   @ModelAttribute ReqFileDataFormSample reqFileDataFormSample, HttpServletRequest request, WebRequest webRequest) throws IOException {
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", reqFileDataFormSample, RequestAttributes.SCOPE_REQUEST);
        log.info("body = {}",reqFileDataFormSample);
        return sampleFileService.listForm(reqFileDataFormSample, request, webRequest);
    }
}