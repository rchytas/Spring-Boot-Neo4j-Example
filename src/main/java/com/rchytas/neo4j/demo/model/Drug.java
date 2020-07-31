package com.rchytas.neo4j.demo.model;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Drug {

	@Id
	private Long id;
	private String name;
	private String therapeuticArea;
	private String activeIngredient;

	@Relationship(type = "PRESCRIBED", direction = Relationship.INCOMING)
	private List<Condition> conditions;

	public List<Condition> getConditions() {
		return conditions;
	}

	public Drug() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTherapeuticArea() {
		return therapeuticArea;
	}

	public void setTherapeuticArea(String therapeuticArea) {
		this.therapeuticArea = therapeuticArea;
	}

	public String getActiveIngredient() {
		return activeIngredient;
	}

	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

}
