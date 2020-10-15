package com.PixelHeartProduction.BrochureBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PixelHeartProduction.BrochureBackEnd.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{

}
