package exps.component.excel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import exps.component.excel.view.ExcelXlsView;
import exps.component.excel.view.ExcelXlsxStreamingView;
import exps.component.excel.view.ExcelXlsxView;

/**
 *  
 * 컨트롤러에서 엑셀다운로드를 간편하게 하기 위한 설정
 */
@Configuration
public class ExcelConfig implements WebMvcConfigurer {

    @Autowired
    private ExcelXlsView excelXlsView;

    @Autowired
    private ExcelXlsxView excelXlsxView;

    @Autowired
    private ExcelXlsxStreamingView excelXlsxStreamingView;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(excelXlsxStreamingView, excelXlsxView, excelXlsView);
    }
}