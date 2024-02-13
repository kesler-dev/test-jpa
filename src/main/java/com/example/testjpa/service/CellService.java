package com.example.testjpa.service;

import com.example.testjpa.domain.Cell;

import java.util.List;

public interface CellService {
    void save(List<Cell> cells);
    List<Cell> findCells();
}
