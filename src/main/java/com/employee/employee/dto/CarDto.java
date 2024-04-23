package com.employee.employee.dto;

import com.employee.employee.entity.Attributes;
import com.employee.employee.entity.Car;
import com.employee.employee.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CarDto {
    private Car car;
    private Image image;
    private Attributes attributes;
}
