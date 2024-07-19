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
        return seriesService.getAllSeries();
    }

    @GetMapping("/{id}")
    public Series getSeriesById(@PathVariable Long id) {
        logger.info("Received request to fetch series with ID: {}", id);
        return seriesService.getSeriesById(id);
    }

    @PostMapping
    public Series saveSeries(@RequestBody Series series) {
        logger.info("Received request to save series: {}", series);
        return seriesService.saveSeries(series);
    }

    @DeleteMapping("/{id}")
    public void deleteSeries(@PathVariable Long id) {
        logger.info("Received request to delete series with ID: {}", id);
        seriesService.deleteSeries(id);
    }
}
