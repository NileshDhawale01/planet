package com.jpamapping.relation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "moon")
public class Moon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "moon_id")
	private Integer moonId;

	@Column(name = "moon_name", length = 200)
	private String moonName;

	@Column(name = "moon_mass", length = 200)
	private Double moonMass;

	@Column(name = "moon_diameter", length = 200)
	private Double moonDiameter;

	@Column(name = "moon_distance_from_planet", length = 200)
	private Double moonDistanceFromPlanet;

	@Column(name = "moon_orbital_period", length = 200)
	private Double moonOrbitalPeriod;

	@Column(name = "moon_surface_temperature", length = 200)
	private Double moonSurfaceTemperature;

	@Column(name = "moon_has_atmospere")
	private boolean moonHasAtmosphere;
}
