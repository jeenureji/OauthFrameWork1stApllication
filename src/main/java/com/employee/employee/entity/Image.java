package com.employee.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "thumbail1")
    private String thumbail1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;




}
