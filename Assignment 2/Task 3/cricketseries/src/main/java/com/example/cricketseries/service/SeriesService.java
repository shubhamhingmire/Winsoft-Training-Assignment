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
        try {
            List<Series> seriesList = seriesRepository.findAll();
            logger.debug("Fetched {} series", seriesList.size());
            return seriesList;
        } catch (Exception e) {
            logger.error("Error fetching all series", e);
            throw e;
        }
    }

    public Series getSeriesById(Long id) {
        logger.info("Fetching series with ID: {}", id);
        try {
            Series series = seriesRepository.findById(id).orElse(null);
            if (series != null) {
                logger.debug("Fetched series: {}", series);
            } else {
                logger.debug("No series found with ID: {}", id);
            }
            return series;
        } catch (Exception e) {
            logger.error("Error fetching series with ID: {}", id, e);
            throw e;
        }
    }

    public Series saveSeries(Series series) {
        logger.info("Saving series: {}", series);
        try {
            Series savedSeries = seriesRepository.save(series);
            logger.debug("Saved series: {}", savedSeries);
            return savedSeries;
        } catch (Exception e) {
            logger.error("Error saving series: {}", series, e);
            throw e;
        }
    }

    public void deleteSeries(Long id) {
        logger.info("Deleting series with ID: {}", id);
        try {
            seriesRepository.deleteById(id);
            logger.debug("Deleted series with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting series with ID: {}", id, e);
            throw e;
        }
    }
}
