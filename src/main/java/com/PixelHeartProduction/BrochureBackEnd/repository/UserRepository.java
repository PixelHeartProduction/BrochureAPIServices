package com.PixelHeartProduction.BrochureBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PixelHeartProduction.BrochureBackEnd.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User deleteById(long id);
	User findByUsername(String username);
}
