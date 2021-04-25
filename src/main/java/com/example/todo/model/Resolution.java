package com.example.todo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "resolution")
public class Resolution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resolution_id;
	
	@Column(name = "resolution_text")
	private String resolution_text;


	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="resolution")
	private Set<SubResolution> subResolutions;
		
	public Long getResolution_id() {
		return resolution_id;
	}

	public void setResolution_id(Long resolution_id) {
		this.resolution_id = resolution_id;
	}

	public String getResolution_text() {
		return resolution_text;
	}
	
	public void setResolution_text(String resolution_text) {
		this.resolution_text = resolution_text;
	}
	
}
