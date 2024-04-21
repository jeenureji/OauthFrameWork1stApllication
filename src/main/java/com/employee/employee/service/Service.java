package com.employee.employee.service;

import com.employee.employee.entity.Entity;
import com.employee.employee.repository.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.OnClose;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;

@org.springframework.stereotype.Service

public class Service {

    private static final Logger log = LoggerFactory.getLogger(Service.class);
    @Autowired
    Repository repository;

public void postNewEntity(Entity entity){
    repository.save(entity);
}

    public List<Entity> getEntity(Integer empId){
        List<Entity> entities = new ArrayList<>();
    repository.findById(empId).ifPresentOrElse(a ->{
        if(a.getFirstName().equals(a.getFirstName().toLowerCase())) {
            String firstname = a.getFirstName().toUpperCase();
            a.setFirstName(firstname);
        }
            entities.add(a);

    }, () -> {
        throw new RuntimeException();
    });
return entities;
    }

    public JSONArray getEntityOf() {
        List<Entity> entities = repository.findAll();
        JSONArray jsonArray = new JSONArray();

        if (entities.isEmpty()) {
            // Log a message if no entities are found
            System.out.println("No entities found");
        } else {
            // Convert each Entity object to JSONObject and add to JSONArray
            for (Entity entity : entities) {
                if (entity.getId() == 81) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("emp_id", entity.getId());
                    jsonObject.put("emp_firstName", entity.getFirstName());
                    jsonObject.put("emp_lastName", entity.getLastName());
                    jsonObject.put("emp_dateTime", entity.getTimeDate());

                    jsonArray.put(jsonObject);
                }
            }
        }

        return jsonArray;
    }









public static void main(String[] args) throws IOException {

    String filePath = "src/main/resources/test.json";

    String file;
    StringBuilder stringBuilder = new StringBuilder();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

    while((file = bufferedReader.readLine()) != null){
        stringBuilder.append(file);
    }
    String getValue = stringBuilder.toString();

    JSONObject jsonObject = new JSONObject(getValue);

    JSONArray jsonArray = jsonObject.getJSONArray("products");

    List<Object> image = new ArrayList<>();
    Map<String, String> latestData = new HashMap<>();
      for(int i =0; i < jsonArray.length(); i++){
        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//        System.out.println(jsonObject1);
        if(jsonObject1.getString("category").equals("car")){
                  if(jsonObject1.get("image") != null) {
                      image.add(jsonObject1.get("image"));
                  }
           }
        }
      latestData.put("patela", "jeenu");
      image.add(latestData);
      image.forEach(a -> System.out.println(a));

    }



//    Iterator<Object> jsonObjectIterator = jsonArray.iterator();
//    while (jsonObjectIterator.hasNext()){
//      jsonObjectIterator.forEachRemaining( a -> {
//          System.out.println(a.toString());
//      });
//    }


}




