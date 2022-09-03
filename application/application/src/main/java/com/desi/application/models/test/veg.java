package com.desi.application.models.test;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="forest_clearance_part_b_density_of_vegetation",schema = "master")
public class veg{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
//	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "fc_partb_id", nullable = true)
//	@JsonIgnore
//	private ForestClearanceBBasicDetails forestClearanceBBasicDetails;
	
	@Column(nullable = false)
	private Double vegetation_area;
	
	@Column(nullable = false)
	private Double vegetation_canopy_density;
	
	@Column(length = 100,nullable = false)
	private String vegetation_eco_class;

	private Boolean is_active;
	
	private Boolean is_deleted;
	
	public veg() {
		this.is_active=true;
		this.is_deleted=false;
	}
}
