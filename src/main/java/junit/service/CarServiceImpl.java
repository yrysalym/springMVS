package junit.service;

import jakarta.transaction.Transactional;
import junit.model.Car;
import junit.repository.CarRepository;
import junit.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * springMVS
 * 16.02.2023
 * user
 * чт
 **/
@Service
@Transactional
public class CarServiceImpl implements CarService{
    private  final CarRepository carRepository;
    private final CompanyRepository companyRepository;
    public CarServiceImpl(CarRepository carRepository, CompanyRepository companyRepository) {
        this.carRepository = carRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public Car save(Car newCar) {
        newCar.setCompany(companyRepository.findBiId(newCar.getCompanyId()));
        return carRepository.save(newCar);
    }
}
