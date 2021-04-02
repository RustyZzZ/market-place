package diachuk.project.marketplace.filter;

import diachuk.project.marketplace.components.JwtUtils;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
	private final JwtUtils jwtUtils;
	private final UserDetailsService userDetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		try{
			var authorization = request.getHeader("Authorization");
			var token = StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")
						? authorization.substring(7)
						: null;
			Optional.ofNullable(token)
					.filter(jwtUtils::validate)
					.ifPresent(t -> {
						var username = jwtUtils.getUsernameFromJwtToken(t);
						var userDetails = userDetailsService.loadUserByUsername(username);
						var auth = new UsernamePasswordAuthenticationToken(userDetails, null,
								userDetails.getAuthorities());
						auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						auth.setAuthenticated(true);
						SecurityContextHolder.getContext().setAuthentication(auth);
					});


		}catch(Exception e){
			e.printStackTrace();
		}
		filterChain.doFilter(request,response);
	}
}
