package com.movie.assembler;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.movie.entity.User;
import com.movie.entity.vo.UserVO;

public final class EntityTOVOAssembler {

	static Logger logger = Logger.getLogger(EntityTOVOAssembler.class);
	static Marker confidentialMarker = MarkerFactory.getMarker("EntityTOVOAssembler");

	public static UserVO fillUserVO(User user) {
		UserVO userVO = new UserVO();
		Optional.ofNullable(user.getId()).ifPresent(x -> userVO.setId(x));
		Optional.ofNullable(user.getUsername()).ifPresent(x -> userVO.setUsername(x));
		Optional.ofNullable(user.getEmails()).ifPresent(x -> userVO.setEmail(x));
		return userVO;
	}
}