package io.cmartinez.carcrud.endpoint;

import io.cmartinez.carcrud.repository.DataBaseCars;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
  @GetMapping("/cars")
  public ResponseEntity<GetCarsResponse> get(){
    GetCarsResponse response = new GetCarsResponse();
    response.setCars(DataBaseCars.getAllCars());
    return ResponseEntity.ok(response);
  }
}
