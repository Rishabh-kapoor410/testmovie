package com.movie.security.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author rishabh.kapoor
 */
public class UserContext {
    private final String username;
    private final List<GrantedAuthority> authorities;
    private final Long roleId;

    private UserContext(String username, List<GrantedAuthority> authorities, Long roleId) {
        this.username = username;
        this.authorities = authorities;
        this.roleId = roleId;
    }
    
    public static UserContext create(String username, List<GrantedAuthority> authorities, Long roleId) {
        if (StringUtils.isBlank(username)) throw new IllegalArgumentException("Username is blank: " + username);
        return new UserContext(username, authorities, roleId);
    }

    public String getUsername() {
        return username;
    }

    public Long getRoleId() {
		return roleId;
	}

	public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
