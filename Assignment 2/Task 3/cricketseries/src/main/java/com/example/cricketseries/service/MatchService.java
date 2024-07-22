package com.example.cricketseries.service;

import com.example.cricketseries.model.Match;
import com.example.cricketseries.repository.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private static final Logger logger = LoggerFactory.getLogger(MatchService.class);

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        logger.info("Fetching all matches.");
        try {
            List<Match> matches = matchRepository.findAll();
            logger.debug("Fetched {} matches", matches.size());
            return matches;
        } catch (Exception e) {
            logger.error("Error fetching all matches", e);
            throw e;
        }
    }

    public Match getMatchById(Long id) {
        logger.info("Fetching match with ID: {}", id);
        try {
            Match match = matchRepository.findById(id).orElse(null);
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

    public Match saveMatch(Match match) {
        logger.info("Saving match: {}", match);
        try {
            Match savedMatch = matchRepository.save(match);
            logger.debug("Saved match: {}", savedMatch);
            return savedMatch;
        } catch (Exception e) {
            logger.error("Error saving match: {}", match, e);
            throw e;
        }
    }

    public void deleteMatch(Long id) {
        logger.info("Deleting match with ID: {}", id);
        try {
            matchRepository.deleteById(id);
            logger.debug("Deleted match with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting match with ID: {}", id, e);
            throw e;
        }
    }
}
