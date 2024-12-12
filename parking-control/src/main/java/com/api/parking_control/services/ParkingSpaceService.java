package com.api.parking_control.services;

import com.api.parking_control.models.ParkingSpaceModel;
import com.api.parking_control.repositories.ParkingSpaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpaceService {

    @Autowired
    ParkingSpaceRepository parkingSpaceRepository;

    @Transactional
    public ParkingSpaceModel save(ParkingSpaceModel parkingSpaceModel) {
        return parkingSpaceRepository.save(parkingSpaceModel);
    }

    public boolean existsByPlateCar(String plateCar) {
        return parkingSpaceRepository.existsByPlateCar(plateCar);
    }

    public boolean existsByParkingSpaceNumber(String parkingSpaceNumber) {
        return parkingSpaceRepository.existsByParkingSpaceNumber(parkingSpaceNumber);
    }

    public boolean existsByApartmentAndApartmentBlock(String apartment, String apartmentBlock) {
        return parkingSpaceRepository.existsByApartmentAndApartmentBlock(apartment, apartmentBlock);
    }

    public List<ParkingSpaceModel> findAll() {
        return parkingSpaceRepository.findAll();
    }

    public Optional<ParkingSpaceModel> findById(UUID id) {
        return parkingSpaceRepository.findById(id);
    }

    @Transactional
    public void deleteById(ParkingSpaceModel parkingSpaceModel) {
        parkingSpaceRepository.delete(parkingSpaceModel);
    }
}
