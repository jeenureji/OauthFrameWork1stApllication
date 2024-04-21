package com.employee.employee.controller;


import com.employee.employee.entity.Car;
import com.employee.employee.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("carApi/v1/")
public class CarController {

    private CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping("/savecar")
    public void saveCar(@RequestBody Car car) throws IOException {
        carService.savecar(car);
    }




}
