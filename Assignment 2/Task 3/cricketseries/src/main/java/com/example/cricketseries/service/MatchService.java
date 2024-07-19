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
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        logger.info("Fetching match with ID: {}", id);
        return matchRepository.findById(id).orElse(null);
    }

    public Match saveMatch(Match match) {
        logger.info("Saving match: {}", match);
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        logger.info("Deleting match with ID: {}", id);
        matchRepository.deleteById(id);
    }
}
