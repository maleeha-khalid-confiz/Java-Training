package com.example.Assignment3.services;

import com.example.Assignment3.entities.Candidate;
import com.example.Assignment3.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates(){
        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidateById(int id){
        return candidateRepository.findById(id);
    }

    public void addCandidate(Candidate candidate){
         candidateRepository.save(candidate);
    }
    public void updateCandidate(Candidate candidate){
        candidateRepository.save(candidate);
    }
    public void deleteCandidateById(int id){
        candidateRepository.deleteById(id);
    }
}
