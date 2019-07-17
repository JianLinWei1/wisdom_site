package com.jian;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @ClassName:  Swagger2   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年1月8日 下午1:40:25   
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	public  Docket  resetApi(){
		
		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("Authorization").description("权限校验")
		.modelRef(new ModelRef("string")).parameterType("header")
		.required(false).defaultValue("Bearer").build();
		pars.add(ticketPar.build());
		
		return new Docket(DocumentationType.SWAGGER_2)
				.forCodeGeneration(true)
                .useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
	}
	
	
	/*
	 * 文档信息
	 */
	 private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                //页面标题
	                .title("系统API")
	                //创建人
	                .contact(new Contact("JianLinWei", "www.lingjunzhineng.cn", ""))
	                //版本号
	                .version("1.0")
	                //描述
	                .description("API 描述")
	                .build();
	    }
}
