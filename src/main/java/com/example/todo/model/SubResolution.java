package com.example.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sub_resolution")
public class SubResolution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sub_resolution_id;
	
	@Column(name = "sub_resolution_text")
	private String sub_resolution_text;
	
	@ManyToOne
	@JoinColumn(name = "resolution_id", nullable = false)
	@JsonBackReference
	private Resolution resolution;
    
	public Long getSub_resolution_id() {
		return sub_resolution_id;
	}

	public void setSub_resolution_id(Long sub_resolution_id) {
		this.sub_resolution_id = sub_resolution_id;
	}

	public String getSub_resolution_text() {
		return sub_resolution_text;
	}

	public void setSub_resolution_text(String sub_resolution_text) {
		this.sub_resolution_text = sub_resolution_text;
	}

}

