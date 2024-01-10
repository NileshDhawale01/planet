package com.jpamapping.relation.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "planet")
public class Planet {

	@Column(name = "planet_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planetId;
	
	@Column(name = "planet_name" , length = 200)
	private String planetName;
	
	@Column(name = "planet_mass" , length = 250)
	private Double planetMass;
	
	@Column(name = "planet_diameter" , length = 200)
	private Double planetDiameter;
	
	@Column(name = "planet_density" , length = 200)
	private Double planetDensity;
	
	@Column(name = "planet_gravity" , length = 200)
	private Double planetGravity;
	
	@Column(name = "planet_escape_velocity" , length = 200)
	private Double planetEscapeVelocity;
	
	@Column(name = "planet_rotation_period" , length = 200)
	private Double planetRotationPeriod;
	
	@Column(name = "planet_day_length" , length = 200)
	private Double planetDayLength;
	
	@Column(name = "planet_distance_from_sun",length = 200)
	private Double planetDistanceFromSun;
	
	@Column(name = "planet_orbital_period" , length = 200)
	private Double planetOrbitalPeriod;
	
	@Column(name = "planet_orbital_velocity" , length = 200)
	private Double planetOrbitalVelocity;
	
	@Column(name = "planet_oxial_tilt" , length = 200)
	private Double planetOxialTilt;
	
	@Column(name = "planet_mean_temperature" , length = 200)
	private Double plannetMeanTemperature;
	
	@Column(name = "planet_has_ring")
	private boolean planetHasRing;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH} , fetch = FetchType.LAZY)
	@JoinColumn(name = "sun_id" , nullable = false)
	private Sun sun;
	
	@OneToMany(mappedBy = "planet" , fetch = FetchType.LAZY)
	private List<Moon> moons;
	
	@OneToMany(mappedBy = "planet" , fetch = FetchType.LAZY)
	private List<Ring> rings;
}
