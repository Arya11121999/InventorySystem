package com.lti.cld.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product_tbl")
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	
	private String productName;
	private String description;
	private int quantity;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_iamges",
    joinColumns = {
    		@JoinColumn(name = "product_Id")
    },inverseJoinColumns = {
    		@JoinColumn(name = "image_id")
    })
	private Set<ImageModel> productImages;
	
	
	public Set<ImageModel> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ImageModel> productImages) {
		this.productImages = productImages;
	}

	@ManyToOne
	@JoinColumn(name = "factory_id")
	Factory factory;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@JsonIgnore
	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
