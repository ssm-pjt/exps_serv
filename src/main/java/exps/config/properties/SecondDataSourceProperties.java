package exps.config.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * Second DataSource Yaml 설정 객체
 *  
 */
@Getter
@Setter
// @ConfigurationProperties(prefix = "spring.datasource.second")
public class SecondDataSourceProperties {

    private String xaDataSourceClassName;
    private String url;
    private String username;
    private String password;

}
