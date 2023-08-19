package edu.miu.carfleet.Integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.carfleet.Domain.Car;
import edu.miu.carfleet.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CarDataJMSListener {

    @Autowired
    private CarRepository carRepository;


    @JmsListener(destination = "carFleet")
    public void onCarRentEvent(String data) throws JsonProcessingException {

//        ObjectMapper mapper = new ObjectMapper();
//        CarDataJSMEvent carEventData = mapper.readValue(data, CarDataJSMEvent.class);
        ObjectMapper mapper = new ObjectMapper();
        CarDataJSMEvent carEventData = mapper.readValue(data, CarDataJSMEvent.class);
//        logger.info("-> JMS message received: " + dacarEventDatata);

        System.out.println("-> JMS message received: " + carEventData);
        Car car= carRepository.findByLicensePlate(carEventData.getLicensePlate());

        if(car!=null){
            car.setStatus(carEventData.getAvailability());
            carRepository.save(car);
            System.out.println(car);
        }else{
            System.out.println("car NO FOUND");
        }

//        frequentRenterService.addPoint(carEventData.getCustomerId(), carEventData.getPoint());
//        System.out.println("data : " + data);
    }

//    @JmsListener(destination = "rentalSystem")
//    public void onCarRentEvent(String data) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
////        CarEventData carEventData = mapper.readValue(data, CarEventData.class);
////        logger.info("-> JMS message received: " + data);
////        frequentRenterService.addPoint(carEventData.getCustomerId(), carEventData.getPoint());
//        System.out.println("data : " +data);
//    }

}
