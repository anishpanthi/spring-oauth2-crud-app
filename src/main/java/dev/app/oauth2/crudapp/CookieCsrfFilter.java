package dev.app.oauth2.crudapp;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Anish Panthi
 */
public class CookieCsrfFilter extends OncePerRequestFilter {
    /**
     * @param request     - HttpServletRequest
     * @param response    - HttpServletResponse
     * @param filterChain - FilterChain
     * @throws ServletException - ServletException
     * @throws IOException      - IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
        filterChain.doFilter(request, response);

    }
}
