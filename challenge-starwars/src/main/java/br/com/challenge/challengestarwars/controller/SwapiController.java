package br.com.challenge.challengestarwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.challengestarwars.model.PlanetResponse;
import br.com.challenge.challengestarwars.service.SwapiApiService;

@RestController
@RequestMapping("/api")
public class SwapiController {

    @Autowired
    private SwapiApiService swapiService;

    @GetMapping("/planets")
    public void getAllPlanetFromApi() {
        swapiService.getAllPlanetFromApi();
    }
}
