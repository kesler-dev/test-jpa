/*
 *  Copyright 2019 Russian Post
 *
 *  This source code is Russian Post Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package com.example.testjpa.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NamedEntityGraph(name = "Cell.links",
        attributeNodes = {
                @NamedAttributeNode("links")
        })
@Table(name = "cell")
public class Cell implements CellInfo {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "nsi-sequence-generator")
    private Long id;

    @Basic
    private String value;

    @Basic(optional = false)
    private Integer sinceVersion;

    @Basic
    private Integer deleteVersion;

    @Basic
    private Integer rowNumber;

    @Column(name = "id_field")
    private Long fieldId;

    @OneToMany(mappedBy = "destCell", cascade = CascadeType.ALL)
    private List<Link> links;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSinceVersion() {
        return sinceVersion;
    }

    public void setSinceVersion(Integer sinceVersion) {
        this.sinceVersion = sinceVersion;
    }

    public Integer getDeleteVersion() {
        return deleteVersion;
    }

    public void setDeleteVersion(Integer deleteVersion) {
        this.deleteVersion = deleteVersion;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
