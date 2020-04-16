package com.example.demo.model;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table
public class Customer {
	@Id
	@Column(length = 36)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(length = 36, unique = true)
	@NotNull(message = "CIF cannot be null")
//	@NotEmpty(message = "CIF cannot be empty")
	private String cif;
	
	@NotNull(message = "Name cannot be null")
//	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 2, max = 255)
	private String name;
	
	@NotNull(message = "Address cannot be null")
//	@NotEmpty(message = "Address cannot be empty")
	@Size(min = 2, max = 1000)
	private String address;
}
