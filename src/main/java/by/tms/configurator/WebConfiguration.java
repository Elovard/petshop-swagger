package by.tms.configurator;

import by.tms.interceptor.AdminInterceptor;
import by.tms.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry
                .addInterceptor(userInterceptor)
                .excludePathPatterns("/store/order")
                .addPathPatterns("/user/findAll");

        registry
                .addInterceptor(adminInterceptor)
                .addPathPatterns("/tag")
                .addPathPatterns("/pet")
                .addPathPatterns("/pet/{id}")
                .addPathPatterns("/pet/findAllByStatus");
    }
}
