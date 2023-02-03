package exps.exception.custom.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import exps.api.sample.controller.SampleApiController;
import exps.common.domain.CommonResult;
import exps.exception.custom.CustomException;
import exps.exception.utils.ErrorUtils;

import javax.servlet.http.HttpServletRequest;

import static exps.common.constant.ResCode.ERROR;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(assignableTypes = SampleApiController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomErrorHandler {

    private String CLASS_NAME = "ApiController";

    private Map<String, Object> errorMap = new LinkedHashMap<>();

    /**
     * CustomException 에러 핸들러 예시
     * @param e
     * @param request
     * @param webRequest
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public CommonResult customException(Exception e, HttpServletRequest request, WebRequest webRequest) throws Exception {
        String ERROR_MSG = e.getMessage();

        errorMap = ErrorUtils.setErrorMap(request, webRequest); // ErrorMap 기본 셋팅

        ErrorUtils.errorWriter(CLASS_NAME, ERROR_MSG, errorMap, e.getMessage()); //에러메세지 출력
        return new CommonResult<>(ERROR, ERROR_MSG, errorMap);
    }

}
