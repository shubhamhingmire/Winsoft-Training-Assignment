package com.example.cricketseries.controller;

import com.example.cricketseries.model.Series;
import com.example.cricketseries.service.SeriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private static final Logger logger = LoggerFactory.getLogger(SeriesController.class);

    @Autowired
    private SeriesService seriesService;

    @GetMapping
    public List<Series> getAllSeries() {
        logger.info("Received request to fetch all series.");
        try {
            List<Series> seriesList = seriesService.getAllSeries();
            logger.debug("Fetched {} series", seriesList.size());
            return seriesList;
        } catch (Exception e) {
            logger.error("Error fetching all series", e);
            throw e;
        }
    }

    @GetMapping("/{id}")
    public Series getSeriesById(@PathVariable Long id) {
        logger.info("Received request to fetch series with ID: {}", id);
        try {
            Series series = seriesService.getSeriesById(id);
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

    @PostMapping
    public Series saveSeries(@RequestBody Series series) {
        logger.info("Received request to save series: {}", series);
        try {
            Series savedSeries = seriesService.saveSeries(series);
            logger.debug("Saved series: {}", savedSeries);
            return savedSeries;
        } catch (Exception e) {
            logger.error("Error saving series: {}", series, e);
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSeries(@PathVariable Long id) {
        logger.info("Received request to delete series with ID: {}", id);
        try {
            seriesService.deleteSeries(id);
            logger.debug("Deleted series with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting series with ID: {}", id, e);
            throw e;
        }
    }
}
