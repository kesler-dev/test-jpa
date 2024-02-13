package com.example.testjpa;

import com.example.testjpa.domain.Cell;
import com.example.testjpa.domain.Link;
import com.example.testjpa.service.CellService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class TestJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJpaApplication.class, args);
    }

    @Autowired
    CellService cellService;

    @PostConstruct
    public void exec() {
        log.info("exec");
        List<Cell> cells = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Cell cell = new Cell();
            cell.setSinceVersion(1);
            cell.setLinks(List.of(new Link()));
            cells.add(cell);
        }
        long start = System.currentTimeMillis();
        cellService.save(cells);
        log.info("saved 100 cells in {} ms", System.currentTimeMillis() - start);
    }

}
