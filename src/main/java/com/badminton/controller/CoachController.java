package com.badminton.controller;

import com.badminton.domain.CoachDTO;
import com.badminton.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")

public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/addCoach")
    public ResponseEntity<Void> addCoach(@RequestBody CoachDTO coachDTO){
        coachService.addCoach(coachDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getCoachById/{id}")
    public ResponseEntity<CoachDTO> getCoachById(@PathVariable Long id){
        coachService.getOoachById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllCoaches")
    public ResponseEntity<List<CoachDTO>> getAllCoaches(){
        coachService.getAllCoaches();
        return new ResponseEntity<List<CoachDTO>>(HttpStatus.OK);
    }

    @PutMapping("/updateCoach")
    public ResponseEntity<Void> updateCoach(@PathVariable Long id, @RequestBody CoachDTO coachDTO){
        coachDTO.setId(id);
        coachService.addCoach(coachDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/daleteCoach/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id){
        coachService.deleteCoachById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
