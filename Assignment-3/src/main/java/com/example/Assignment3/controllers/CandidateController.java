package com.example.Assignment3.controllers;

import com.example.Assignment3.entities.Candidate;
import com.example.Assignment3.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "hi";

    }

    @GetMapping("/candidates")
    @ResponseBody
    public List<Candidate> getCandidatesById(){
        return candidateService.getAllCandidates();

    }

    @GetMapping("/candidate/{id}")
    @ResponseBody
    public Optional<Candidate> getCandidatesById(@PathVariable("id") int id){
        return candidateService.getCandidateById(id);
    }

    @PostMapping("/candidate")
    @ResponseBody
    public void addCandidate(@RequestBody Candidate candidate){
        candidateService.addCandidate(candidate);
    }

    @PutMapping("/candidate")
    @ResponseBody
    public void updateCandidate(@RequestBody Candidate candidate){
        candidateService.updateCandidate(candidate);
    }

    @DeleteMapping("/candidate/{id}")
    @ResponseBody
    public void deleteCandidateBy(@PathVariable("id") int id){
        candidateService.deleteCandidateById(id);
    }
}
