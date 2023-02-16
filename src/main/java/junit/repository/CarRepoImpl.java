package junit.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import junit.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class CarRepoImpl implements CarRepository{
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Car> findAll() {
        return entityManager.createQuery("select  c from Car c",Car.class).getResultList();
    }

    @Override
    public Car save(Car newCar) {

         entityManager.persist(newCar);
         return newCar;
    }
}
