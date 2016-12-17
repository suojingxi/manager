package com.sonymm.manager.web.exception.handler;

import com.sonymm.manager.core.Response;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 15:22
 */
@ControllerAdvice()
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Response exceptionHandler(RuntimeException e){
        Response response = new Response();
        response.setCode(1);
        String errorMsg = e.getMessage();
        if(errorMsg.indexOf(":") > -1){
            errorMsg = errorMsg.split(":")[1];
        }
        response.setMsg(errorMsg);
        return response;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}
