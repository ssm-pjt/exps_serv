package exps.component.file.domain;

import lombok.*;

/**
 *  
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
