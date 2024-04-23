package com.employee.employee.controller;


import com.employee.employee.dto.CarDto;
import com.employee.employee.entity.Attributes;
import com.employee.employee.entity.Car;
import com.employee.employee.entity.Image;
import com.employee.employee.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("carApi/v1/")
public class CarController {

    private CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping("/savecar")
    public ResponseEntity<String> saveCar(@RequestBody CarDto carDto) {
        String message = "saved the body";
        Car car = carDto.getCar();
        Image image = carDto.getImage();
        Attributes attributes = carDto.getAttributes();
        carService.saveCar(car, image, attributes);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);

    }

    @PostMapping("/saveAttribute")
    public ResponseEntity<String> saveCar(@RequestBody Attributes attributes)  {
        String message = "saved the body";
        carService.saveAttribute(attributes);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PostMapping("/saveImage")
    public ResponseEntity<String> saveCar(@RequestBody Image image) {
        String message = "saved the body";
        carService.saveImage(image);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/getCarById")
    public ResponseEntity<Optional<Car>> getCarByid(@RequestParam(value = "carId") Long carId){
       Optional<Car> car = carService.getCarById(carId);
       return new ResponseEntity<>(car, HttpStatus.FOUND);
    }

    @GetMapping("/getAttributeId")
    public ResponseEntity<Optional<Attributes>> getCarByid(@RequestParam(value = "attId") String attId){
        Optional<Attributes> att = carService.getCarByAttId(attId);
        return new ResponseEntity<>(att, HttpStatus.FOUND);
    }

    @GetMapping("/getCarByImgId")
    public ResponseEntity<Optional<Image>> getCarByid(@RequestParam(value = "carId") Integer carId){
        Optional<Image> car = carService.getCarByImgId(carId);
        return new ResponseEntity<>(car, HttpStatus.FOUND);
    }
}
