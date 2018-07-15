package com.joshimo.cinema.enity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "row")
public class Row implements Serializable {

    @Id
    @Basic
    @Column(name = "row_number")
    private Integer rowNumber;

    @Basic
    @Column(name = "cost")
    private Double cost;

    public Row() {
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Double getCost() {
        return cost;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
