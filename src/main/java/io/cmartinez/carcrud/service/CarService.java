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
}
