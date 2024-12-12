package com.api.parking_control.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = false)
public class ParkingSpaceDto {
    @NotBlank
    private String parkingSpaceNumber;
    @NotBlank
    @Size(max = 7)
    private String plateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String apartmentBlock;


    public @NotBlank String getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public void setParkingSpaceNumber(@NotBlank String parkingSpaceNumber) {
        this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public @NotBlank @Size(max = 7) String getPlateCar() {
        return plateCar;
    }

    public void setPlateCar(@NotBlank @Size(max = 7) String plateCar) {
        this.plateCar = plateCar;
    }

    public @NotBlank String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(@NotBlank String brandCar) {
        this.brandCar = brandCar;
    }

    public @NotBlank String getModelCar() {
        return modelCar;
    }

    public void setModelCar(@NotBlank String modelCar) {
        this.modelCar = modelCar;
    }

    public @NotBlank String getColorCar() {
        return colorCar;
    }

    public void setColorCar(@NotBlank String colorCar) {
        this.colorCar = colorCar;
    }

    public @NotBlank String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(@NotBlank String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public @NotBlank String getApartment() {
        return apartment;
    }

    public void setApartment(@NotBlank String apartment) {
        this.apartment = apartment;
    }

    public @NotBlank String getApartmentBlock() {
        return apartmentBlock;
    }

    public void setApartmentBlock(@NotBlank String apartmentBlock) {
        this.apartmentBlock = apartmentBlock;
    }
}
