package com.example.crud2tablespringboot.repository;

import com.example.crud2tablespringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
