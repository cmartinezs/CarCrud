package io.cmartinez.carcrud.endpoint;

import io.cmartinez.carcrud.repository.Car;
import io.cmartinez.carcrud.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
  @Autowired
  private CarService carService;

  @GetMapping("/cars")
  public ResponseEntity<GetCarsResponse> get(){
    GetCarsResponse response = new GetCarsResponse();
    response.setCars(carService.getAllCars());
    return ResponseEntity.ok(response);
  }

  @GetMapping("/cars/{id}")
  public ResponseEntity<GetCarResponse> get(@PathVariable int id){
    Car foundCar = carService.findCarById(id);

    if(foundCar != null){
      GetCarResponse response = new GetCarResponse();
      response.setCar(foundCar);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
