package com.jpamapping.relation.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ring")
public class Ring {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ring_id")
	private Integer ringId;

	@Column(name = "ring_name", length = 200)
	private String ringName;

	@Column(name = "ring_inner_radius", length = 200)
	private Double ringInnerRedius;

	@Column(name = "ring_outer_radius", length = 200)
	private Double ringOuterRadius;

	@Column(name = "ring_thickness", length = 200)
	private Double ringThickness;

	@Column(name = "ring_composition", length = 200)
	private String ringComposition;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "planet_id", nullable = false)
	private Planet planet;
}
