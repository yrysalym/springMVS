package junit.repository;


import junit.model.Car;
import junit.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CarRepository {
    List<Car> findAll();
    Car save(Car newCar);




}
