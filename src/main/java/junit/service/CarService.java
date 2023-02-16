package junit.service;


import junit.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;


public interface CarService {
    List<Car> findAll( );

    Car save(Car car);
}
