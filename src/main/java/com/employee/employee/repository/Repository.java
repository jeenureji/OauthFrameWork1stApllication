package com.employee.employee.repository;

import com.employee.employee.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Entity, Integer> {
//    void save(List<Entity> entityList);

}
