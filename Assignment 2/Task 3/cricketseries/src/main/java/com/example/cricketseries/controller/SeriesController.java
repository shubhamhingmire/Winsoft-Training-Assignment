package com.example.cricketseries.controller;

import com.example.cricketseries.model.Series;
import com.example.cricketseries.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/series")
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    @PostMapping
    public ResponseEntity<Series> createSeries(@RequestBody Series series) {
        Series createdSeries = seriesService.createSeries(series);
        return new ResponseEntity<>(createdSeries, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Series> getSeriesById(@PathVariable Long id) {
        Optional<Series> series = seriesService.getSeriesById(id);
        return series.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Series>> getAllSeries() {
        List<Series> seriesList = seriesService.getAllSeries();
        return ResponseEntity.ok(seriesList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Series> updateSeries(@PathVariable Long id, @RequestBody Series series) {
        Series updatedSeries = seriesService.updateSeries(id, series);
        return updatedSeries != null ? ResponseEntity.ok(updatedSeries) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeries(@PathVariable Long id) {
        seriesService.deleteSeries(id);
        return ResponseEntity.noContent().build();
    }
}
