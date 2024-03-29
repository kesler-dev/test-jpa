/*
 * Copyright 2022 Russian Post
 *
 *  This source code is Russian Post Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package com.example.testjpa.domain;

/**
 * Сокращённая сущность для ячейки,
 * для получения значений ячеек без резолва ссылок
 */
public interface CellInfo {
    Long getId();
    String getValue();
    Integer getRowNumber();
    Long getFieldId();
}
