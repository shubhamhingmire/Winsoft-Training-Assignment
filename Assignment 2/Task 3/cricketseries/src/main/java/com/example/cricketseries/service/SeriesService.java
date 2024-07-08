package com.example.cricketseries.service;

import com.example.cricketseries.model.Series;
import com.example.cricketseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;

    public Series createSeries(Series series) {
        return seriesRepository.save(series);
    }

    public Optional<Series> getSeriesById(Long id) {
        return seriesRepository.findById(id);
    }

    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    public Series updateSeries(Long id, Series series) {
        if (seriesRepository.existsById(id)) {
            series.setId(id);
            return seriesRepository.save(series);
        }
        return null;
    }

    public void deleteSeries(Long id) {
        seriesRepository.deleteById(id);
    }
}
