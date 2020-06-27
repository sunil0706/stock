/**
 * 
 */
package com.exsgi.api;

import java.io.Serializable;

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
import javax.validation.constraints.NotBlank;


/**
 * @author SUNIL NAYAK
 *
 */
@Entity
@Table
public class Toy implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "toy_name")
	@NotBlank(message = "Toy name  is required")
	private String name;
	@Column(name = "toy_type")
	@NotBlank(message = "Toy type is required")
	private String type;
	@Column(name = "age")
	@NotBlank(message = "Age is required")
	private String age;
	@Column(name = "toy_price")
	@NotBlank(message = "Toy price gstno is required")
	private double price;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STORE_ID", updatable = true, insertable = true)
	private Store store;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Toy [id=" + id + ", name=" + name + ", type=" + type + ", age=" + age + ", price=" + price + "]";
	}
}	
