package exps.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * @author moon.seong.soo
 * Swwager( Springdoc기반 ) 으로 API 명세서 설저
 * springfox 도 있지만 현재는 업그레이드 안되고 있어 springdoc을 사용  
 */
@OpenAPIDefinition(
	    info = @Info(
	        title = "EXPENSE API 명세서",
	        description = "EXPENSE에 포함되어 있는 API들 명세서",
	        version = "v1",
	        contact = @Contact(
	            name = "moon seong soo",
	            email = "gobooky@gmail.com"
	        )
	    )
	)
@Configuration
public class OpenApiConfig {

	/**
	 * sampleOpenApi.
	 * 
	 * @return GroupedOpenApi
	 */
	@Bean
	public GroupedOpenApi sampleOpenApi() {
		String[] paths = { "/sample/**" };
		return GroupedOpenApi.builder().group("sample API").pathsToMatch(paths).build();
	}
	
	/**
	 * corpCardOpenApi
	 * 
	 * @return GroupedOpenApi
	 */
	@Bean
	public GroupedOpenApi corpCardOpenApi() {
		String[] paths = { "/api/card/**" };
		return GroupedOpenApi.builder().group("법인카드 관련 API").pathsToMatch(paths).build();
	}
	
	/**
	 * approvalOpenApi
	 * 
	 * @return GroupedOpenApi
	 */
	@Bean
	public GroupedOpenApi approvalOpenApi() {
		String[] paths = { "/api/aprv/**" };
		return GroupedOpenApi.builder().group("결재 관련 API").pathsToMatch(paths).build();
	}
}
