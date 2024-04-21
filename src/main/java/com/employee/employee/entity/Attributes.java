package com.employee.employee.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attributes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attributes {

    @Id
    @Column(name = "productMedia")
    private String productMedia;
    @Column(name = "pageUrl")
    private String pageUrl;
    @Column(name = "productLocation")
    private String productLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;
}
