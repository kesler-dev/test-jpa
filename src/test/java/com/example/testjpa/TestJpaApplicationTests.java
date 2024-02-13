package com.example.testjpa;

import com.example.testjpa.domain.Cell;
import com.example.testjpa.domain.Link;
import com.example.testjpa.service.CellService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class TestJpaApplicationTests {

    @Autowired
    private CellService cellService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSave() {
        List<Cell> cells = new ArrayList<>();

        int num = 10;
        int linksNum = 10;
        for (int i = 0; i < num; i++) {
            Cell cell = new Cell();
            cell.setSinceVersion(1);
            List<Link> links = new ArrayList<>();
            for (int j = 0; j < linksNum; j++) {
                links.add(new Link());
            }
            cell.setLinks(links);
            cells.add(cell);
        }
        long startSaving = System.currentTimeMillis();
        log.info("Saving cells..");
        cellService.save(cells);
        log.info("Complete saving {} cells in {} ms", num, System.currentTimeMillis() - startSaving);

        long startReading = System.currentTimeMillis();
        log.info("Reading cells..");
        List<Cell> savedCells = cellService.findCells();
//        savedCells.forEach(c -> c.getLinks().size());
        log.info("Complete reading {} cells in {} ms", savedCells.size(), System.currentTimeMillis() - startReading);

    }



}
