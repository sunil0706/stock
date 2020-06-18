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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * @author SUNIL NAYAK
 *
 */
@Entity
@Table
public class Store implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@NotBlank(message = "Store name is required")
	private String store_name;
	@Column
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
    message="Mobile number is invalid")
	private Long store_contact;
	@Column
	@NotBlank(message = "Store email is required")
	@Email
	private String email;
	@Column
	@NotBlank(message = "Store gstno is required")
	private String gstNo;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public Long getStore_contact() {
		return store_contact;
	}
	public void setStore_contact(Long store_contact) {
		this.store_contact = store_contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Store [id=" + id + ", store_name=" + store_name + ", store_contact=" + store_contact + ", email="
				+ email + ", gstNo=" + gstNo + ", address=" + address + "]";
	}
	
	public Store() {
		
	}
	public Store(String store_name, Long store_contact, String email, String gstNo) {
		this.store_name = store_name;
		this.store_contact = store_contact;
		this.email = email;
		this.gstNo = gstNo;
	}
}
