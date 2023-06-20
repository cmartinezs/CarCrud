package io.cmartinez.carcrud.service;

import io.cmartinez.carcrud.endpoint.model.Car;
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

  public Car deleteCarById(int id) {
    List<Car> cars = DataBaseCars.getAllCars();
    for(Car car: cars){
      if(car.getId() == id){
        cars.remove(car);
        return car;
      }
    }
    return null;
  }

  public boolean addCar(Car aCar) {
    List<Car> cars = DataBaseCars.getAllCars();
    int id = cars.size() + 1;
    aCar.setId(id);
    cars.add(aCar);
    return true;
  }

  public Car updateCarById(int id, Car aCar) {
    List<Car> cars = DataBaseCars.getAllCars();
    for (Car car : cars) {
      if (car.getId() == id) {
        car.setBrand(aCar.getBrand());
        car.setColor(aCar.getColor());
        car.setModel(aCar.getModel());
        car.setPlateCode(aCar.getPlateCode());
        return car;
      }
    }
    return null;
  }
}
