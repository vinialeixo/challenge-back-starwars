package br.com.challenge.challengestarwars.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Getter
@Setter
public class PlanetResponse {
    
    private int count;
    private String next;
    private String previous;
    
    @JsonProperty("results")
    private List<PlanetResultsApi> planets;
    


}

    


