package com.pixelHeartProduction.APIServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixelHeartProduction.APIServices.model.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{

}
