package exps.api.sample.packet;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 샘플 객체
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Tag(name="파일 업로드 요청 FORM 객체")
public class ReqFileDataFormSample {
    private List<ReqFileDataSample> dataList = new ArrayList<>();
}
