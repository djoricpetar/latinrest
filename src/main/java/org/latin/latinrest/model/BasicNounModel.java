package org.latin.latinrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.latin.common.Gender;
import org.latin.noun.BasicNoun;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="noun")
public class BasicNounModel extends BasicNoun implements Serializable {

	private static final long serialVersionUID = 1L;

	public BasicNounModel() { }
	
	public BasicNounModel(String nominativeSingular, String genitiveSingular, Gender gender) {
		super(nominativeSingular, genitiveSingular, gender);
	}
	
	@Id
	public String getNominativeSingular() { 
		return nominativeSingular;
	}
	
	public void setNominativeSingular(String nominativeSingular) {
		this.nominativeSingular = nominativeSingular;
	}
	
	public String getGenitiveSingular() { 
		return genitiveSingular;
	}
	
	public void setGenitiveSingular(String genitiveSingular) { 
		this.genitiveSingular = genitiveSingular;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="VARCHAR(1)")
	public Gender getGender() { 
		return gender;
	}
	
	public void setGender(Gender gender) { 
		this.gender = gender;
	}
	
	// TODO delete
	@Transient
	@JsonIgnore
	public Class<?> getAdjectiveClassName() { 
		return super.getAdjectiveClassName();
	}
}
