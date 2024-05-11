package br.com.challenge.challengestarwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.challenge.challengestarwars.model.Planet;

@Repository
public interface PlanetRepository extends JpaRepository <Planet,Long>   {

}
