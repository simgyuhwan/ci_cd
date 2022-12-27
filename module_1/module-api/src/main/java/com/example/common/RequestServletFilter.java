package com.example.common;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * RequestServletFilter.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.27
 */
@Component
public class RequestServletFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestServletWrapper servletWrapper = new RequestServletWrapper((HttpServletRequest) request);

        chain.doFilter(servletWrapper, response);
    }
}
