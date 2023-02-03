package exps.component.file.domain;

import org.springframework.core.io.InputStreamResource;

import java.io.InputStream;

/**
 * 
 */
public class FileInputStreamResource extends InputStreamResource {

    private long contentLength;

    public FileInputStreamResource(InputStream inputStream, long contentLength) {
        super(inputStream);
        this.contentLength = contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    @Override
    public long contentLength() {
        return contentLength;
    }
}
