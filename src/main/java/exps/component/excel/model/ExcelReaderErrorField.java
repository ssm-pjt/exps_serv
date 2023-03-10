package exps.component.excel.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 엑셀 업로드 에러 필드
 *  
 *
 * Sample
 [
   {
     "errorType": "TYPE",
     "errorRow": 2,
     "errorFieldName": "test",
     "errorFieldHeaderName": "테스트",
     "errorInputData": "안녕",
     "errorMessage": "잘못된 데이터 타입: 데이터 필드타입 - Integer, 입력된 필드타입 - String",
     "exceptionMessage": "NumberFormatException: For input string: \"안녕\""
   }
 ]
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Tag(name="엑셀 업로드 에러 필드 객체")
public class ExcelReaderErrorField {
    @Schema(description = "ERROR 타입 (TYPE: 잘못된 데이터 타입, EMPTY: 필수 입력값 누락, VALID: 유효성 검증 실패, UNKNOWN: 알수 없는 에러)")
    private String type;
    @Schema(description = "ERROR 행 번호")
    private Integer row;
    @Schema(description = "ERROR 필드명")
    private String field;
    @Schema(description = "ERROR 필드 Header명")
    private String fieldHeader;
    @Schema(description = "ERROR 입력값")
    private String inputData;
    @Schema(description = "ERROR 메세지")
    private String message;
    @Schema(description = "EXCEPTION MESSAGE")
    private String exceptionMessage;

    @Builder
    public ExcelReaderErrorField(String type, Integer row, String field, String fieldHeader, String inputData, String message, String exceptionMessage) {
        this.type = type;
        this.row = row;
        this.field = field;
        this.fieldHeader = fieldHeader;
        this.inputData = inputData;
        this.message = message;
        this.exceptionMessage = exceptionMessage;
    }
}