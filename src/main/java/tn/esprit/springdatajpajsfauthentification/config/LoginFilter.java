package tn.esprit.springdatajpajsfauthentification.config;

import tn.esprit.springdatajpajsfauthentification.controller.EmployeController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public LoginFilter() { }
    public void destroy() { }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest= (HttpServletRequest)request;
        HttpServletResponse hresponse= (HttpServletResponse)response;

        EmployeController employecontroller=(EmployeController)hrequest.getSession().getAttribute("employeController");

        if (employecontroller!=null && employecontroller.getLoggedIn())
        {chain.doFilter(request, response);}

        else
        { hresponse.sendRedirect(hrequest.getContextPath()+"/");
        }
    }
    public void init(FilterConfig fConfig) throws ServletException {
    }
}
