package com.oce.springboot.training.d03.s01.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * A sample of a security {@link javax.servlet.Filter}
 *
 * @author bogdan.solga
 */
public class SampleFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                         final FilterChain filterChain)
            throws IOException, ServletException {
    }

    @Override
    public void destroy() {
    }
}
