package com.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import com.movie.common.Constants;

@Entity
@Table(name = "APP_USER_ROLES", uniqueConstraints = {
        
})
public class Role {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    @NaturalId
	    @Column(length = 60)
	    private Constants.Role name;

	    public Role() {

	    }

	    public Role(Constants.Role name) {
	        this.name = name;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Constants.Role getName() {
	        return name;
	    }

	    public void setName(Constants.Role name) {
	        this.name = name;
	    }

	
}
