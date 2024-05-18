package br.com.challenge.challengestarwars.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="planet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Planet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="planet_name", length=40)
    private String name;

    @Column(name="planet_weather", length=40)
    private String weather;

    @Column(name="planet_land", length=40)
    private String land;

    @Column (name = "qdte_movies_apperead", length = 5)
    private int films;

    public Planet(String name, String weather, String land) {
        this.name = name;
        this.weather = weather;
        this.land = land;
    }


    
}
