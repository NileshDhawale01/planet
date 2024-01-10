package com.jpamapping.relation.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sun")
public class Sun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sun_id")
	private Integer sunId;

	@Column(name = "sun_mass", length = 200)
	private Double sunMass;

	@Column(name = "sun_diameter", length = 200)
	private Double sunDiameter;

	@Column(name = "sun_surface_temperature", length = 200)
	private Double sunSurfaceTemperature;

	@Column(name = "sun_luminosity", length = 200)
	private Double sunLuminosity;

	@Column(name = "sun_age", length = 200)
	private Double sunAge;

	@Column(name = "sun_spectral_class", length = 200)
	private String sunSpectralClass;

	@Column(name = "sun_rotation_period", length = 200)
	private Double sunRotationPeriod;

	@OneToMany(mappedBy = "sun" , fetch = FetchType.LAZY )
	private List<Planet> planets;
}
