package com.example.cricketseries.repository;

import com.example.cricketseries.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
