package br.com.challenge.challengestarwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.challengestarwars.dto.PlanetRequestDTO;
import br.com.challenge.challengestarwars.model.Planet;
import br.com.challenge.challengestarwars.repository.PlanetRepository;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;


    public Planet createPlanet(PlanetRequestDTO body){

        Planet newPlanet  = new Planet(body.name(), body.weather(), body.land());
      return  planetRepository.save(newPlanet);
    }

    public List<Planet> getAllPlanet(){
        return planetRepository.findAll();
    }
}
