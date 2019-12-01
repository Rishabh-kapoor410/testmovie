package com.movie.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.common.Response;
import com.movie.entity.vo.JwtAuthenticationResponse;
import com.movie.security.JwtTokenProvider;
import com.movie.security.auth.ajax.AjaxAuthenticationProvider;
import com.movie.security.auth.ajax.LoginRequest;
import com.movie.service.IUserService;
import com.movie.user.repository.RoleRepository;
import com.movie.user.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	static Logger logger = Logger.getLogger(UserController.class);
	static Marker confidentialMarker = MarkerFactory.getMarker("UserController");

	@Autowired
	AjaxAuthenticationProvider authenticationProvider;

	@Autowired
	IUserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {

		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					loginRequest.getUsername(), loginRequest.getPassword());
			token.setDetails(new WebAuthenticationDetails(request));
			Authentication authentication = this.authenticationProvider.authenticate(token);
			if (authentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = tokenProvider.generateToken(authentication);
				return ResponseEntity.ok(
						new Response<>((new JwtAuthenticationResponse(jwt)).getAccessToken(), Collections.EMPTY_LIST));
			}
		} catch (AuthenticationException e) {

			logger.info(confidentialMarker + ",Exception in the class{} ," + e.getLocalizedMessage());
			return ResponseEntity.ok().body(
					(new Response<>("Token Generation -Failure Invalid Username Password", Collections.EMPTY_LIST)));

		}
		return ResponseEntity.ok()
				.body((new Response<>("Token Generation -Failure Invalid Username Password", Collections.EMPTY_LIST)));

	}

}
