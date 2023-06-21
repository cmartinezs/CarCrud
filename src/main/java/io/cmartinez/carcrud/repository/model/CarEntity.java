package io.cmartinez.carcrud.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cars")
@Getter
@Setter
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(nullable = false, length = 6)
  private String plateCode; //plate_code
  @Column(nullable = false, length = 30)
  private String brand;
  @Column(nullable = false, length = 30)
  private String model;
  @Column(nullable = false, length = 10)
  private String color;
}
