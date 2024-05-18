package br.com.challenge.challengestarwars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.challenge.challengestarwars.model.PlanetResponse;
import br.com.challenge.challengestarwars.model.PlanetResultsApi;

@Service
public class SwapiApiService {
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private PlanetService planetService;

        public void getAllPlanetFromApi(){
            try {
                String url = "https://swapi.dev/api/planets/";
                List<PlanetResultsApi> allPlanets = new ArrayList<>();
                ResponseEntity<PlanetResponse> response;

                while (url !=null) {
                    response = restTemplate.getForEntity(url, PlanetResponse.class);
                    PlanetResponse planetResponse = response.getBody();
                    if (planetResponse != null) {
                        allPlanets.addAll(planetResponse.getPlanets());
                        url = planetResponse.getNext();
                    }else{
                        url = null;
                    }    
                }
                planetService.transferPlanetFromApitoBD(allPlanets);
            } catch (HttpClientErrorException e) {
                // Handle errors appropriately
               throw new RuntimeException("Failed to fetch planets: " + e.getStatusCode());
            }
        }

}
