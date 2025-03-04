package com.lqt.mvcspring.repository;

import java.util.List;
import java.util.Objects;

public interface StatsRepository {
    List<Objects[]> countProByCate();
}
