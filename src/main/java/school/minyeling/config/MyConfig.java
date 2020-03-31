package school.minyeling.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import school.minyeling.interceptor.MyInterceptor;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        注册自定义类型拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
