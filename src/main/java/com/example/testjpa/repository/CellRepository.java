package com.example.testjpa.repository;

import com.example.testjpa.domain.Cell;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CellRepository extends JpaRepository<Cell, Long> {

    @Query(value = "SELECT c FROM Cell AS c" +
            " WHERE c.sinceVersion <= :dataVersion" +
            " AND (c.deleteVersion > :dataVersion OR c.deleteVersion IS NULL)")
    @EntityGraph(value = "Cell.links")
    List<Cell> findCells(@Param("dataVersion") Integer dataVersion);
}
