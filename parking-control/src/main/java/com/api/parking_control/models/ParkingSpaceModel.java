package com.api.parking_control.models;

import com.api.parking_control.dtos.ParkingSpaceDto;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PARKING_SPACE")
public class ParkingSpaceModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpaceNumber;
    @Column(nullable = false, unique = true, length = 7)
    private String plateCar;
    @Column(nullable = false, length = 70)
    private String brandCar;
    @Column(nullable = false, length = 70)
    private String modelCar;
    @Column(nullable = false, length = 70)
    private String colorCar;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 130)
    private String responsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String apartmentBlock;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public void setParkingSpaceNumber(String parkingSpaceNumber) {
        this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public String getPlateCar() {
        return plateCar;
    }

    public void setPlateCar(String plateCar) {
        this.plateCar = plateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getApartmentBlock() {
        return apartmentBlock;
    }

    public void setApartmentBlock(String apartmentBlock) {
        this.apartmentBlock = apartmentBlock;
    }

    public void updateFields(ParkingSpaceDto dto) {
        this.parkingSpaceNumber = dto.getParkingSpaceNumber();
        this.plateCar = dto.getPlateCar();
        this.brandCar = dto.getBrandCar();
        this.modelCar = dto.getModelCar();
        this.colorCar = dto.getColorCar();
        this.responsibleName = dto.getResponsibleName();
        this.apartment = dto.getApartment();
        this.apartmentBlock = dto.getApartmentBlock();
    }
}
