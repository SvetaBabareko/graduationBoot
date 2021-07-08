package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.model.Vote;
import org.babareko.graduationBoot.repository.VoteRepository;
import org.babareko.graduationBoot.service.VoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(VoteRestController.URL)
@AllArgsConstructor
@Slf4j
public class VoteRestController {

    static final String URL = "/api/votes";

    private final VoteService voteService;

    @GetMapping()
    public List<Vote> getAll() {
        log.info("getAll");
        return voteService.findAll();
    }
}
