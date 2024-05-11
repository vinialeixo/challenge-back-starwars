package br.com.challenge.challengestarwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.challengestarwars.dto.PlanetRequestDTO;
import br.com.challenge.challengestarwars.model.Planet;
import br.com.challenge.challengestarwars.service.PlanetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/planet/")
public class ControllerPlanet {
    @Autowired
    private PlanetService planetService;

    @PostMapping("create")
    public ResponseEntity<Planet> createPlanet(@Valid @RequestBody PlanetRequestDTO body ) {     

        Planet planet =  planetService.createPlanet(body);
        return new ResponseEntity<Planet>(planet, HttpStatus.CREATED);
    }
    
    @GetMapping("get")
    public ResponseEntity<List<Planet>> getAllPlanet() {
        List<Planet> planets = planetService.getAllPlanet();
        return ResponseEntity.ok(planets);
    }
    
    
}
