package school.minyeling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@MapperScan("school.minyeling")
@ServletComponentScan //过滤器
public class MinyelingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinyelingApplication.class, args);
    }

}
