package com.niit.bean;

import javax.persistence.*;
@Entity
@Table
public class Model {
	@Id
	@GeneratedValue
	int ModelId;
	String PhoneName;
	float Cost;
	public int getModelId() {
		return ModelId;
	}
	public void setModelId(int modelId) {
		ModelId = modelId;
	}
	public String getPhoneName() {
		return PhoneName;
	}
	public void setPhoneName(String phoneName) {
		PhoneName = phoneName;
	}
	public float getCost() {
		return Cost;
	}
	public void setCost(float cost) {
		Cost = cost;
	}
	

}

