package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;

@Service
public class CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class.getName());

	@Autowired
	public CustomerDAO customerDAO;
	
	public void saveCustomer(Customer c){
		customerDAO.save(c);
	}
	
	public void deleteCustomer(String id){
		customerDAO.delete(id);
	}
	
	public List<Customer> getAll() throws Exception {
		return (List<Customer>) customerDAO.findAll();
    }
	
	public Customer getById(String id){
		Customer cById = customerDAO.findOne(id);
		return cById;
	}
	
}
