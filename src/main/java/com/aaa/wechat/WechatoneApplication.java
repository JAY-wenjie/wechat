package com.aaa.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@MapperScan("com.aaa.wechat.domain.mapper")
public class WechatoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(WechatoneApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet){
		ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<DispatcherServlet>(dispatcherServlet);
		servletServletRegistrationBean.addUrlMappings("*.do");
		return servletServletRegistrationBean;
	}
}
