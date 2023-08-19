package edu.miu.carfleet.Repository;
import edu.miu.carfleet.Domain.Car;
import edu.miu.carfleet.Domain.CarStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testFindByLicensePlate() {
        String licensePlate = "4ff";
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        entityManager.persist(car);
        entityManager.flush();
        Car found = carRepository.findByLicensePlate(licensePlate);
        assertEquals(licensePlate, found.getLicensePlate());
    }
     @Test
    public void testfindByStatus(){
         CarStatus status=CarStatus.AVAILABLE;
         Car car1= new Car();
         car1.setStatus(status);
         car1.setLicensePlate("ABCD");
         entityManager.persist(car1);
         entityManager.flush();

         List<Car> found =carRepository.findByStatus(status);
         // There are already 3 mock cars so the expected car count is 3 + 1
         assertEquals(4,found.size());
         assertEquals(status,found.get(0).getStatus());
     }
    @Test
    public void testCountByBrandAndCarType() {
        String brand = "Toyota";
        String carType = "Sedan";

            Car car = new Car();
            car.setLicensePlate("ABCD");
            car.setBrand(brand);
            car.setType(carType);
            entityManager.persist(car);
            entityManager.flush();

        long actualCount = carRepository.countByBrandAndCarType(brand, carType);
        assertEquals(1, actualCount);
    }
}


