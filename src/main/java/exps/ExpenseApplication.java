package exps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gobooky
 *
 * SpringBoot 기반 first expense settle system
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class ExpenseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseApplication.class, args);
    }

}


//DB 접속을 하지 않는 Application 설정 옵션
//https://www.baeldung.com/spring-data-disable-auto-config
//(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})