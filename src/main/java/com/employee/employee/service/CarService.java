package com.employee.employee.service;

import com.employee.employee.entity.Car;
//import com.employee.employee.repository.AttributesRepository;
import com.employee.employee.repository.CarRepository;
//import com.employee.employee.repository.ImageRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

        public void savecar (Car car) throws IOException {
        String filePath = "src/main/resources/test.json";
        String file;
        StringBuilder stringBuilder = new StringBuilder();
        List<JSONObject> getcar = new ArrayList<>();
        JSONObject jsonObject2 = new JSONObject();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        while ((file = bufferedReader.readLine()) != null) {
            stringBuilder.append(file);
        }
        String fj = stringBuilder.toString();
        JSONObject jsonObject = new JSONObject(fj);
        JSONArray jsonArray = jsonObject.getJSONArray("products");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            if (jsonObject1.get("name").equals("fortuner")) {
                getcar.add(jsonObject1);
            }
            for(JSONObject  cc : getcar){
                Long id = Long.valueOf(cc.getString("id"));
                String category = cc.getString("category");
                String name = cc.getString("name");
                String description = cc.getString("description");
                String subCategory = cc.getString("subCategory");
                car.setId(id);
                car.setCategory(category);
                car.setName(name);
                car.setDescription(description);
                car.setSubCategory(subCategory);
            }
        }
            log.info("carId{}, Category{}, description{}, discountAmount{}, discountPercentage{}",
 car.getId(), car.getCategory(), car.getDescription(), car.getDiscountAmount(), car.getDiscountPercentage());

            carRepository.save(car);
    }

        }




