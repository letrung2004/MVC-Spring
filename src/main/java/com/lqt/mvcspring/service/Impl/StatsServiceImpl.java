package com.lqt.mvcspring.service.Impl;

import com.lqt.mvcspring.repository.StatsRepository;
import com.lqt.mvcspring.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StatsServiceImpl implements StatsService {
    private final StatsRepository statsRepository;

    @Autowired
    public StatsServiceImpl(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    @Override
    public List<Objects[]> countProByCate() {
        return statsRepository.countProByCate();
    }
}
