package com.example.esercizioSpringRepositories1.repository;


import com.example.esercizioSpringRepositories1.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {

}
