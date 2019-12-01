package com.movie.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movie.entity.User;

/**
 * UserRepository
 * 
 * @author rishabh.kapoor
 */
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u left join fetch u.roles r where u.username=:username")
	public Optional<User> findByUsername(@Param("username") String username);

	Optional<User> findByEmail(String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	List<User> findByIdIn(List<Long> userIds);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
