package com.employee.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    private Long id;
//    @OneToMany(mappedBy = "image")
//    @JsonIgnore
//    private Image image;
    @Column(name = "subCategory")
    private String subCategory;
    @Column(name = "taxExempt")
    private  boolean taxExempt;
    @Column(name =  "available")
    private String available;
    @Column(name = "description")
    private String description;
    @Column(name = "discountAmount")
    private Integer discountAmount;

    @Column(name = "active")
    private boolean active;

    @Column(name = "discountPercentage")
    private Integer discountPercentage;
    @Column(name = "price")
    private Integer price;
    @Column(name = "name")
    private String name;
//    @OneToMany(mappedBy = "attributes")
//    @JsonIgnore
//    private Attributes attributes;
    @Column(name = "category")
    private String category;
    @Column(name = "localDateTime")
    private LocalDateTime localDateTime;

}
