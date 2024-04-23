package com.employee.employee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> image = new ArrayList<>();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attributes> attributes = new ArrayList<>();

    // Rest of your code



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

    @Column(name = "category")
    private String category;


    @Column(name = "localDateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    @PrePersist
    public void prePersist() {
        this.localDateTime = LocalDateTime.now();
        System.out.println("date & time : " + this.localDateTime);
    }



}
