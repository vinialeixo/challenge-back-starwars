package br.com.challenge.challengestarwars.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Getter
@Setter
public class PlanetResultsApi {
    private String name;
    private String climate;
    private String terrain;
    private List<Films> films;
}
