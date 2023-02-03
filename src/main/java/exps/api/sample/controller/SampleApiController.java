package exps.api.sample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import exps.api.sample.constant.Hobby;
import exps.api.sample.packet.ReqGetSample;
import exps.api.sample.packet.ReqJsonSample;
import exps.api.sample.packet.ResGetSample;
import exps.api.sample.service.SampleApiService;
import exps.common.domain.CommonResult;
import exps.utils.common.InfoUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springdoc.webmvc.core.RequestService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.validation.Valid;

import static exps.common.constant.ResCode.SUCCESS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


/**
 * Sample API 코드
 */
@Slf4j
@RestController
@RequiredArgsConstructor
// @RequestMapping("/v1")
@Tag(name = "Sample API 컨트롤러", description = "Sample API")
// @ApiIgnore
public class SampleApiController {

    private static final HttpServletRequest RequestService = null;
	private final SampleApiService service;
    private final ObjectMapper objectMapper;

    /**
     * 서버 접속 테스트
     * @return
     */
    @Operation(summary = "서버 접속 테스트")
    @GetMapping("/call")
    public String call(){
        log.info("~~~~~~~~~~~~~~~");
        Map<String , Object> result = new HashMap<>();
      //result.put("list",service.test() );
        InfoUtils.getRequestInfoMap(result,RequestService);         //result.put("list",service.test() );
        return "ok";
    }

    /**
     * 서버 접속 테스트
     * @return
     */
    @Operation(summary = "서버 접속 테스트")
    @GetMapping("/test")
    public CommonResult<List<Integer>> test(){
        log.info("~~~~~~~~~~~~~~~");
        return new CommonResult<>(SUCCESS, SUCCESS.getMessage(), Lists.newArrayList(1,2,3));
    }

    @Operation(summary = "비동기 서비스 테스트1 SUCCESS")
    @GetMapping("/test-async-test1")
    public void testAsync1() {
        IntStream.range(1,100).forEach(service::asyncTestSuccess);
    }

    @Operation(summary = "비동기 서비스 테스트2 FAIL")
    @GetMapping("/test-async-test2")
    public void testAsync2() {
        IntStream.range(1,100).forEach(service::asyncTestFail);
    }

    @Operation(summary = "비동기 서비스 테스트3 메인 AsyncService 사용")
    @GetMapping("/test-async-test3")
    public void testAsync3() {
        IntStream.range(1,100).forEach(service::asyncTestAsyncService);
    }

    @Operation(summary = "비동기 서비스 테스트4 CompletableFuture")
    @GetMapping("/test-async-test4")
    public void testAsync4() {
        IntStream.range(1,100).forEach(service::asyncTestCompletableFuture);
    }

    /**
     * 에러 테스트
     * @return
     * @throws Exception
     */
    @Operation(summary = "에러 테스트")
    @GetMapping(value = "/err")
    public CommonResult<Map<String, Object>> error() throws Exception {
        log.info("~~~~~~~~~~~~~~~");
        Map<String , Object> result = new HashMap<>();

        if(true) throw new Exception("ERROR TEST");

        return new CommonResult<>(SUCCESS, SUCCESS.getMessage(), result);
    }

    /**
     * GET 요청 Object 파라메터 테스트
     * @param sample
     * @return
     */
    @Operation(summary = "GET 요청 Object 파라메터 테스트")
    @GetMapping(value = "/sample")
    public CommonResult<ResGetSample> sampleGet(@Param("ReqGetSample 요청 객체")
                                                @Valid ReqGetSample sample) {
        log.info("sample = {}",sample);
        return new CommonResult<>(SUCCESS, SUCCESS.name(), new ResGetSample(sample));
    }

    /**
     * GET 요청 Object 파라메터 테스트
     * @param sample
     * @return
     */
    @Operation(summary = "GET 요청 PathVariable Object 파라메터 테스트")
    @GetMapping(value = "/sample/{seq}")
    public CommonResult<ResGetSample> sampleGetPathVariable(@Parameter(name = "seq 값")
                                                            @PathVariable("seq") Integer seq,
                                                            @Parameter(name = "ReqGetSample 요청 객체")
                                                            @Valid ReqGetSample sample){
        sample.setSeq(seq);
        log.info("sample = {}",sample);
        return new CommonResult<>(SUCCESS, SUCCESS.name(), new ResGetSample(sample));
    }

    /**
     * GET 요청 PathVariable Object 파라메터 테스트
     * @param hobby
     * @param sample
     * @return
     */
    @Operation(summary = "GET 요청 특정 카테고리 PathVariable Object 파라메터 테스트")
    @GetMapping(value = "/sample/hobby/{hobby}")
    public CommonResult<ResGetSample> sampleGetCategoryPathVariable (@Parameter(name = "hobby 취미 PathVriable 값")
                                                                     @PathVariable("hobby") Hobby hobby,
                                                                     @Parameter(name = "ReqGetSample 요청 객체")
                                                                     @Valid ReqGetSample sample){
        sample.setHobby(hobby);
        log.info("sample = {}",sample);
        return new CommonResult<>(SUCCESS, SUCCESS.name(), new ResGetSample(sample));
    }

    /**
     * RequestBody String 파라메터 테스트
     * @param body
     * @return
     */
    @Operation(summary = "@RequestBody String 파라메터 테스트")
    @Parameters({
            @Parameter(name = "Sample", content = @Content( mediaType = "sample\n\n " +
                    "{\"my_address\": \\{\"city\": \"영등포구\", \"country\": \"한국\", \"state\": \"서울\", \"zip_code\": \"07276\"}, \"my_id\":\"abcd\",\"my_name\":\"홍길동\",\"my_age\":10,\"my_email\":\"abc@company.com\",\"my_job\":\"developer\"}" ),
                    required = true)
    })
    @PostMapping("/sample/body-string")
    public CommonResult<ReqJsonSample> bodyString(@Parameter(name = "ReqJsonSample String 요청 객체")
                                                  @Valid @RequestBody String body,
                                                  WebRequest webRequest) throws Exception {
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", body, RequestAttributes.SCOPE_REQUEST);
        log.info("body = {}",body);
        ReqJsonSample sample = objectMapper.readValue(body, ReqJsonSample.class);
        log.info("sample = {}",sample);
        return new CommonResult<>(SUCCESS, SUCCESS.name(), sample);
    }

    /**
     * RequestBody Object 테스트
     * @param sample
     * @return
     */
    @Operation(summary = "@RequestBody Object 파라메터 테스트")
    @PostMapping("/sample/body-object")
    public CommonResult<ReqJsonSample> bodyObject(@Parameter(name = "ReqJsonSample 요청 객체")
                                                  @Valid @RequestBody ReqJsonSample sample,
                                                  WebRequest webRequest) throws Exception {
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", sample, RequestAttributes.SCOPE_REQUEST);
        log.info("sample = {}",sample);
        return new CommonResult<>(SUCCESS, SUCCESS.name(), sample);
    }

    @Operation(summary = "PATCH - @PathVariable Object 파라메터 테스트")
    @PatchMapping("/sample/pathvariable-object/{seq}")
    public CommonResult<ReqJsonSample> patchBodyObjectPathvariable(@Parameter(name = "ReqJsonSample 요청 객체")
                                                                   @PathVariable("seq") Integer seq,
                                                                   @Parameter(name = "ReqJsonSample 요청 객체")
                                                                   @Valid @RequestBody ReqJsonSample sample,
                                                                   WebRequest webRequest) throws Exception {
        sample.setSeq(seq);
        //ExceptionHandler로 RequestBody 값을 전달해주기 위한 셋팅
        webRequest.setAttribute("body", sample, RequestAttributes.SCOPE_REQUEST);
        log.info("sample = {}",sample);
        return new CommonResult<>(SUCCESS, SUCCESS.name(), sample);
    }

    @Operation(summary = "DELETE - @PathVariable Object 파라메터 테스트")
    @DeleteMapping("/sample/pathvariable-object/{seq}")
    public CommonResult<ReqJsonSample> deleteObjectPathVariable(@Parameter(name = "ReqJsonSample 요청 객체")
                                                                @PathVariable("seq") Integer seq,
                                                                @Parameter(name = "ReqJsonSample 요청 객체")
                                                                @Valid ReqJsonSample sample) throws Exception {
        sample.setSeq(seq);
        log.info("sample = {}",sample);
        return new CommonResult<>(SUCCESS, SUCCESS.name(), sample);
    }
}