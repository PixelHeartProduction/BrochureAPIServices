package com.pixelHeartProduction.APIServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixelHeartProduction.APIServices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
