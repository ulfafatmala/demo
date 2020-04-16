package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerDAO extends PagingAndSortingRepository<Customer, String>{
//	@Query(value = "select c  from Customer c where c.cif like %:sSearch% ")
//	Page<Customer> getPageable(@Param("sSearch") String sSearch, Pageable pageable);
}
