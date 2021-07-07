package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.repository.VoteRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestaurantRestController.URL)
@AllArgsConstructor
@Slf4j
public class VoteRestController {

    static final String URL = "/api/votes";

    private final VoteRepository voteRepository;
}
