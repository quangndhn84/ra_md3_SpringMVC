package ra.springmvc_crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//Quét các thư mục tìm các bean đóng vai trò là controller, service, repository để khởi tạo và nạp vào bean
@ComponentScan(basePackages = {"ra.springmvc_crud.controller","ra.springmvc_crud.serviceImp","ra.springmvc_crud.repositoryImp"})
public class AppConfig implements WebMvcConfigurer {
    //Cấu hình thư mục chứa các view của ứng dụng
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
