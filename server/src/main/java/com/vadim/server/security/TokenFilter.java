package com.vadim.server.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@AllArgsConstructor
public class TokenFilter implements Filter {

    private final TokenValidator tokenValidator;

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(
            final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain
    ) throws IOException, ServletException {

        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final String token = httpServletRequest.getHeader(AUTHORIZATION);
        final TokenAuthentication tokenAuthentication = new TokenAuthentication(token);

        if (token != null && tokenValidator.validateAccessToken(token)) {
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
