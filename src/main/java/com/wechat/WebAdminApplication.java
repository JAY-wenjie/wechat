package com.wechat;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@MapperScan(basePackages = "com.wechat.domain.mapper")
public class WebAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAdminApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet){
		ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<DispatcherServlet>(dispatcherServlet);
		servletServletRegistrationBean.addUrlMappings("*.do");
		return servletServletRegistrationBean;
	}

}
