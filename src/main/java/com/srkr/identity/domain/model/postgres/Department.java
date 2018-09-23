package com.srkr.identity.domain.model.postgres;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table (name="Department")
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="dateupdated")
	private Date dateUpdated;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="DEPARTMENTLAB",
				joinColumns= {@JoinColumn(referencedColumnName="id")},
				inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
	private Set<Lab> labs = new HashSet<Lab>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Set<Lab> getLabs() {
		return labs;
	}

	public void setLabs(Set<Lab> labs) {
		this.labs = labs;
	}	
	
}
