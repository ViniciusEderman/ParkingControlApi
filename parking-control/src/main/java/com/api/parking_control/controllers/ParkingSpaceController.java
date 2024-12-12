package com.api.parking_control.controllers;

import com.api.parking_control.dtos.ParkingSpaceDto;
import com.api.parking_control.models.ParkingSpaceModel;
import com.api.parking_control.services.ParkingSpaceService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-space") // ENDPOINT A NIVEL DE CLASSE
public class ParkingSpaceController {

    @Autowired
    ParkingSpaceService parkingSpaceService;

    @PostMapping // chamada do endpoint /parking-space com metodo (POST)
    public ResponseEntity<Object> saveParkingSpace(@RequestBody @Valid ParkingSpaceDto parkingSpaceDto) {

        if (parkingSpaceService.existsByPlateCar(parkingSpaceDto.getPlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Plate Car is already in use!");
        }
        if (parkingSpaceService.existsByParkingSpaceNumber(parkingSpaceDto.getParkingSpaceNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking SpaceNumber is already in use!");
        }
        if (parkingSpaceService.existsByApartmentAndApartmentBlock(parkingSpaceDto.getApartment(), parkingSpaceDto.getApartmentBlock())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
        }

        var parkingSpaceModel = new ParkingSpaceModel();
        BeanUtils.copyProperties(parkingSpaceDto, parkingSpaceModel); // conversao de dto para model(formato que vamos inserir)
        parkingSpaceModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpaceService.save(parkingSpaceModel)); // RETORNO do metodo save(service)
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpaceModel>> getAllParkingSpaces() {
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpaceService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {

        Optional<ParkingSpaceModel> parkingSpaceModelOptional = parkingSpaceService.findById(id);

        if (!parkingSpaceModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(parkingSpaceModelOptional.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpaceModel> parkingSpaceModelOptional = parkingSpaceService.findById(id);

        if (!parkingSpaceModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review your parking space ID");
        }

        parkingSpaceService.deleteById(parkingSpaceModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking space deleted");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> editById(
            @PathVariable(value = "id") UUID id,
            @RequestBody @Valid ParkingSpaceDto parkingSpaceDto) {

        Optional<ParkingSpaceModel> parkingSpaceModelOptional = parkingSpaceService.findById(id);

        if (!parkingSpaceModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review your parking space ID");
        }

        var parkingSpaceModel = parkingSpaceModelOptional.get();
        parkingSpaceModel.updateFields(parkingSpaceDto);
        parkingSpaceService.save(parkingSpaceModel);

        return ResponseEntity.status(HttpStatus.OK).body(parkingSpaceModel);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleInvalidUUID(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid UUID format");
    }
}
