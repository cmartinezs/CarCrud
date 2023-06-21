package io.cmartinez.carcrud.service;

import io.cmartinez.carcrud.endpoint.model.Car;
import io.cmartinez.carcrud.repository.CarRepository;
import io.cmartinez.carcrud.repository.DataBaseCars;
import io.cmartinez.carcrud.repository.model.CarEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
  @Autowired
  private CarRepository carRepository;

  public List<Car> getAllCars(){
    List<Car> finalCars = new ArrayList<>();
    List<CarEntity> cars = (List<CarEntity>)carRepository.findAll();
    for(CarEntity entity: cars){
      Car car = new Car();
      car.setId(entity.getId());
      car.setPlateCode(entity.getPlateCode());
      car.setBrand(entity.getBrand());
      car.setModel(entity.getModel());
      car.setColor(entity.getColor());
      finalCars.add(car);
    }
    return finalCars;
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
