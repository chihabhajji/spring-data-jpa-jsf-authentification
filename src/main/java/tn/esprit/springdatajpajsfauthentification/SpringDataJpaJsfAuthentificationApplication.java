package tn.esprit.springdatajpajsfauthentification;



import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import sun.rmi.runtime.Log;
import tn.esprit.springdatajpajsfauthentification.config.LoginFilter;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

@SpringBootApplication
@ComponentScan({"tn.esprit.springdatajpajsfauthentification.controller,tn.esprit.springdatajpajsfauthentification.service"})
public class SpringDataJpaJsfAuthentificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaJsfAuthentificationApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean(servlet, "*.jsf");
    }
    @Bean
    public FilterRegistrationBean<RewriteFilter> rewriteFilter() {
        FilterRegistrationBean<RewriteFilter> rwFilter = new FilterRegistrationBean<>(new RewriteFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> lgFilter = new FilterRegistrationBean<>(new LoginFilter());
        lgFilter.addUrlPatterns("/*");
        return lgFilter;
    }
}
