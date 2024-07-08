package com.example.cricketseries.repository;

import com.example.cricketseries.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
