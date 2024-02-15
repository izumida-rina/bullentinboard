package com.bulletinboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "division")
public class Division {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    

}
