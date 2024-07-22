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
        try {
            List<Match> matches = matchService.getAllMatches();
            logger.debug("Fetched {} matches", matches.size());
            return matches;
        } catch (Exception e) {
            logger.error("Error fetching all matches", e);
            throw e;
        }
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        logger.info("Received request to fetch match with ID: {}", id);
        try {
            Match match = matchService.getMatchById(id);
            if (match != null) {
                logger.debug("Fetched match: {}", match);
            } else {
                logger.debug("No match found with ID: {}", id);
            }
            return match;
        } catch (Exception e) {
            logger.error("Error fetching match with ID: {}", id, e);
            throw e;
        }
    }

    @PostMapping
    public Match saveMatch(@RequestBody Match match) {
        logger.info("Received request to save match: {}", match);
        try {
            Match savedMatch = matchService.saveMatch(match);
            logger.debug("Saved match: {}", savedMatch);
            return savedMatch;
        } catch (Exception e) {
            logger.error("Error saving match: {}", match, e);
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        logger.info("Received request to delete match with ID: {}", id);
        try {
            matchService.deleteMatch(id);
            logger.debug("Deleted match with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting match with ID: {}", id, e);
            throw e;
        }
    }
}
