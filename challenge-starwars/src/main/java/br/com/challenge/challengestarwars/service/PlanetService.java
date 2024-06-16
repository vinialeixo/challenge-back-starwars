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
        List <Planet> planets = new ArrayList<>();
        
        for (PlanetResultsApi planetResult : planetsBody) {
            Planet planet = new Planet();
            planet.setName(planetResult.getName());
            planet.setWeather(planetResult.getClimate());
            planet.setLand(planetResult.getTerrain());
            
            int filmCount = countFilmsByPlanet(planetResult.getFilms());
            planet.setFilms(filmCount);
        }
        planetRepository.saveAll(planets);
    }

    public int countFilmsByPlanet(List<Films> films){
        return films.size();
    }
}
