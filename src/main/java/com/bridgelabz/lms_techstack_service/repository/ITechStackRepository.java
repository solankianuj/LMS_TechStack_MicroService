package com.bridgelabz.lms_techstack_service.repository;

import com.bridgelabz.lms_techstack_service.model.TechStackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * purpose:creating candidate technology repository
 */
@Repository
public interface ITechStackRepository extends JpaRepository<TechStackModel,Long> {
}
