package com.employee.employee.controller;

//import okhttp3.OkHttpClient;
//import okhttp3.Response;
import com.employee.employee.entity.Entity;
import com.employee.employee.service.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.HTTP;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service service;


    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody List<Entity> entity){
        String message = "save the body";
        for(Entity entity1 : entity) {
            service.postNewEntity(entity1);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(message);

    }

        @GetMapping("/getEmployee")
    public ResponseEntity<List<Entity>> getEmp(@RequestParam(name = "empId") Integer empId){
       List<Entity> entities = service.getEntity(empId);
       return new ResponseEntity<>(entities, HttpStatus.FOUND);

    }
    @GetMapping("/jsonEmployee")
    public ResponseEntity<JSONArray> getJson() {
        JSONArray jsonArray = service.getEntityOf();
        if (jsonArray.isEmpty()) {
            // Return 404 Not Found if the JSONArray is empty
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(jsonArray);
        }
    }

}
