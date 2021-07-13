package org.babareko.graduationBoot.service;

import org.babareko.graduationBoot.model.Vote;
import org.babareko.graduationBoot.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    public static final Logger LOG = LoggerFactory.getLogger(VoteService.class);

    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> findAll() {
        return voteRepository.findAll();
    }
}
