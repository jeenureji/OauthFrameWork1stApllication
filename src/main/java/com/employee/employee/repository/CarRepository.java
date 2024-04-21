package com.employee.employee.repository;


import com.employee.employee.entity.Car;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

//    @Query("SELECT c FROM Car c LEFT JOIN FETCH c.image LEFT JOIN FETCH c.attributes WHERE c.id = :id")
//    Optional<Car> findByIdWithImagesAndAttributes(@Param("id") Long id);



}
