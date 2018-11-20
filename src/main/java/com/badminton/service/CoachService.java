package com.badminton.service;

import com.badminton.domain.CoachDTO;
import com.badminton.entity.CoachEntity;

import java.util.List;

public interface CoachService {

    void addCoach(CoachDTO coachDTO);

    List<CoachDTO> getAllCoaches ();

    CoachDTO getOoachById(Long id);

    void deleteCoachById(Long id);
}
