package io.cmartinez.carcrud.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
  private int id;
  private String plateCode;
  private String brand;
  private String model;
  private String color;
}