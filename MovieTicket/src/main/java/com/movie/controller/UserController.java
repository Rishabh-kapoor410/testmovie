package com.movie.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.jboss.logging.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.common.Constants;
import com.movie.common.Response;
import com.movie.entity.vo.UserVO;
import com.movie.security.auth.JwtAuthenticationToken;
import com.movie.service.IUserService;

@RestController()
@RequestMapping(value = "/users")
public class UserController {

	static Logger logger = Logger.getLogger(UserController.class);
	static Marker confidentialMarker = MarkerFactory.getMarker("UserController");

	@Autowired
    IUserService userService;

	@PostMapping()
	@RequestMapping("/signUp")
	public  Response<?> postUser(JwtAuthenticationToken token, @RequestBody UserVO userVO) {
		Collection<UserVO> colUserVO = new ArrayList<>();
		try {
			
			UserVO rsltUserVO = userService.save( userVO);
			if (rsltUserVO.getId() != null) {
				colUserVO.add(rsltUserVO);
				return new Response<UserVO>("User Saved Successfull", colUserVO, Constants.success);
			}
			return new Response<UserVO>("User Save Unsuccessfull", Collections.EMPTY_LIST);
		} catch (Exception e) {
			logger.info(confidentialMarker + ",Exception in the class{} ," + e.getLocalizedMessage());
			return new Response<UserVO>("User Save Unsuccessfull " + e.getLocalizedMessage(), Collections.EMPTY_LIST);
		}

	}

}
