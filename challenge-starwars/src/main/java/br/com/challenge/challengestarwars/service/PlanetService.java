package br.com.challenge.challengestarwars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.challengestarwars.dto.PlanetRequestDTO;
import br.com.challenge.challengestarwars.model.Films;
import br.com.challenge.challengestarwars.model.Planet;
import br.com.challenge.challengestarwars.model.PlanetResultsApi;
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

    public void transferPlanetFromApitoBD(List<PlanetResultsApi> planetsBody){

        for (PlanetResultsApi planet : planetsBody) {
            Planet planetBase = new Planet();
            planetBase.setName(planet.getName());
            planetBase.setWeather(planet.getClimate());
            planetBase.setLand(planet.getTerrain());
            
            planetBase.setFilms(countFilmsByPlanet(planet.getFilms()));
            planetRepository.save(planetBase);
        }
    }

    public int countFilmsByPlanet(List<Films> films){
        return films.size();
    }
}
