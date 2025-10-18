package com.aditya;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.aditya"})
public class ParkingLotApplication implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(ParkingLotApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Parking Lot Open..................");
  }
}
