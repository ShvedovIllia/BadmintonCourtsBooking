package com.badminton.service.impl;

import com.badminton.domain.CoachDTO;
import com.badminton.entity.CoachEntity;
import com.badminton.repository.CoachRepository;
import com.badminton.service.CoachService;
import com.badminton.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;


    @Override
    public void addCoach(CoachDTO coachDTO) {
        coachRepository.save(modelMapper.map(coachDTO, CoachEntity.class));
    }

    @Override
    public List<CoachDTO> getAllCoaches() {
        return modelMapper.mapAll(coachRepository.findAll(), CoachDTO.class);
    }

    @Override
    public CoachDTO getOoachById(Long id) {
        return modelMapper.map(coachRepository.findById(id), CoachDTO.class);
    }

    @Override
    public void deleteCoachById(Long id) {
        coachRepository.deleteById(id);
    }
}
