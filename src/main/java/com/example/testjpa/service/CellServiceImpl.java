package com.example.testjpa.service;

import com.example.testjpa.domain.Cell;
import com.example.testjpa.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CellServiceImpl implements CellService {

    @Autowired
    private CellRepository cellRepository;

    @Override
    @Transactional
    public void save(List<Cell> cells) {
        cells.forEach(cell -> cellRepository.save(cell));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cell> findCells() {
        return cellRepository.findCells(1);
    }
}
