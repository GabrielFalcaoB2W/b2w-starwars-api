package io.b2w.starwars.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.validation.constraints.NotBlank;

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
@Document(collection = "planets")
public class Planet {

	@Id
	@JsonProperty(access = Access.READ_ONLY)
	private String id;
	
	@NotBlank(message = "The attribute name is required")
	private String name;
	@NotBlank(message = "The attribute climate is required")
	private String climate;
	@NotBlank(message = "The attribute terrain is required")
	private String terrain;
	private int timesOnMovies;
}
