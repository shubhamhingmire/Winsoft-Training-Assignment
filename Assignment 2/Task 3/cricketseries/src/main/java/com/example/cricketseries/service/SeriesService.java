package com.example.cricketseries.service;

import com.example.cricketseries.model.Series;
import com.example.cricketseries.repository.SeriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {

    private static final Logger logger = LoggerFactory.getLogger(SeriesService.class);

    @Autowired
    private SeriesRepository seriesRepository;

    public List<Series> getAllSeries() {
        logger.info("Fetching all series.");
        return seriesRepository.findAll();
    }

    public Series getSeriesById(Long id) {
        logger.info("Fetching series with ID: {}", id);
        return seriesRepository.findById(id).orElse(null);
    }

    public Series saveSeries(Series series) {
        logger.info("Saving series: {}", series);
        return seriesRepository.save(series);
    }

    public void deleteSeries(Long id) {
        logger.info("Deleting series with ID: {}", id);
        seriesRepository.deleteById(id);
    }
}
