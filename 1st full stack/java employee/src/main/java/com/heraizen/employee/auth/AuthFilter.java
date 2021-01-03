package com.heraizen.employee.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class AuthFilter extends OncePerRequestFilter{
	
//	@Autowired
//	private JwtUtil jwtUtil;
//	
//	@Autowired
//	private UserDetailsService appUserService;
//	
//	
//	
//	
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		
//		
//		System.out.println("inside dofilter");
//			 String authorizationHeader = request.getHeader("Authorization");
//			
//			System.out.println("AUTHOIZATION"+authorizationHeader);
//			
//			String jwt = null;
//			String username = null;
//			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//				
//				System.out.println("inside 1st First");
//				
//				jwt = authorizationHeader.substring(7);
//				username = jwtUtil.extractUsername(jwt);
//			}
//			
//			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//				UserDetails userDetails = appUserService.loadUserByUsername(username);
//				if (jwtUtil.validateToken(jwt, userDetails)) {
//					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//							userDetails, null, userDetails.getAuthorities());
//					usernamePasswordAuthenticationToken
//							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//				}
//			}
//			
//			filterChain.doFilter(request, response);
//		
//	}
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserDetailsService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		    System.out.println("request :");
			final String authorizationHeader = request.getHeader("Authorization");
			String username = null;
			String jwt = null;
			if(authorizationHeader != null && authorizationHeader.trim().startsWith("Bearer ")) {
					jwt = authorizationHeader.substring(7);
					username = jwtUtil.extractUsername(jwt);
				
			}
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
		
				UserDetails userDetails = userService.loadUserByUsername(username);
				if(jwtUtil.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
							new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
		
			filterChain.doFilter(request, response);
		
	}

}
