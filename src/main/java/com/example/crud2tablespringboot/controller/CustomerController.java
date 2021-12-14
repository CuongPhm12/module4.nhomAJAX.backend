package com.example.crud2tablespringboot.controller;

import com.example.crud2tablespringboot.model.Customer;
import com.example.crud2tablespringboot.model.Province;
import com.example.crud2tablespringboot.service.customer.ICustomerService;
import com.example.crud2tablespringboot.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {
@Autowired
    private ICustomerService customerService;

@Autowired
    private IProvinceService provinceService;

@ModelAttribute("provinceList")
    public Iterable<Province> provinces(){
    return provinceService.findAll();
}

@GetMapping("/list")
    public ResponseEntity<Iterable<Customer>> listCustomer(){
    return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
}
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }




}
