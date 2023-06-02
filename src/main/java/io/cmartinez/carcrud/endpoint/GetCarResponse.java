package io.cmartinez.carcrud.endpoint;

import io.cmartinez.carcrud.repository.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCarResponse {
  private Car car;
}
