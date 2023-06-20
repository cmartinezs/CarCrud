package io.cmartinez.carcrud.endpoint;

import io.cmartinez.carcrud.endpoint.model.Car;
import io.cmartinez.carcrud.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Comentario de prueba
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

  @DeleteMapping("/cars/{id}")
  public ResponseEntity<GetCarResponse> delete(@PathVariable int id){
    Car deletedCar = carService.deleteCarById(id);
    if(deletedCar != null){
      GetCarResponse response = new GetCarResponse();
      response.setCar(deletedCar);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/cars")
  public ResponseEntity<GetCarResponse> post(@RequestBody Car aCar){
    boolean added = carService.addCar(aCar);
    if(added){
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping("/cars/{id}")
  public ResponseEntity<GetCarResponse> put(@PathVariable("id") int id, @RequestBody Car aCar){
    Car updated = carService.updateCarById(id, aCar);
    if (updated != null) {
      GetCarResponse response = new GetCarResponse();
      response.setCar(updated);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
