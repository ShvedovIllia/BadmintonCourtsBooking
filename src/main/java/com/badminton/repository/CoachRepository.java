package com.badminton.repository;

import com.badminton.entity.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CoachRepository extends JpaRepository<CoachEntity, Long> {
}
