package com.PixelHeartProduction.BrochureBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PixelHeartProduction.BrochureBackEnd.model.Visitor;


@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Long>{

}
