package com.api.parking_control.repositories;

import com.api.parking_control.models.ParkingSpaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceModel, UUID> {
    boolean existsByPlateCar(String plateCar);
    boolean existsByParkingSpaceNumber(String parkingSpaceNumber);
    boolean existsByApartmentAndApartmentBlock(String apartment, String apartmentBlock);
}
