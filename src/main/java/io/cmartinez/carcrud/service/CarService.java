package io.cmartinez.carcrud.service;

import io.cmartinez.carcrud.repository.Car;
import io.cmartinez.carcrud.repository.DataBaseCars;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarService {
  public List<Car> getAllCars(){
    return DataBaseCars.getAllCars();
  }

  public Car findCarById(int id){
    List<Car> cars = DataBaseCars.getAllCars();
    for(Car car: cars){
      if(car.getId() == id){
        return car;
      }
    }
    return null;
  }
}
