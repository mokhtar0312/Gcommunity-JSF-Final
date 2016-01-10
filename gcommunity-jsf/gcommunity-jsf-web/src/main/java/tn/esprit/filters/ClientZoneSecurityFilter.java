package tn.esprit.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.bean.IdentityBean;

@WebFilter("/client/*")
public class ClientZoneSecurityFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		IdentityBean identity = (IdentityBean) req.getSession().getAttribute(
				"identity");
		Boolean letGo = false;
		if (identity != null && identity.getIdentifiedUser() != null
				&& identity.hasRole("Client")) {
			letGo = true;
		}
		if (letGo) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/Login.jsf");
		}
	}

	@Override
	public void destroy() {
	}

}
