package com.example.cricketseries.controller;

import com.example.cricketseries.model.Match;
import com.example.cricketseries.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private static final Logger logger = LoggerFactory.getLogger(MatchController.class);

    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<Match> getAllMatches() {
        logger.info("Received request to fetch all matches.");
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        logger.info("Received request to fetch match with ID: {}", id);
        return matchService.getMatchById(id);
    }

    @PostMapping
    public Match saveMatch(@RequestBody Match match) {
        logger.info("Received request to save match: {}", match);
        return matchService.saveMatch(match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        logger.info("Received request to delete match with ID: {}", id);
        matchService.deleteMatch(id);
    }
}
