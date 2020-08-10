package io.b2w.starwars.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Planet {

	private Long id;
	private String name;
	private String climate;
	private String terrain;
	private Integer timesOnMovies;
}
