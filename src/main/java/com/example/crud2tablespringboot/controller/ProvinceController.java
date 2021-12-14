package com.example.crud2tablespringboot.controller;

import com.example.crud2tablespringboot.model.Province;
import com.example.crud2tablespringboot.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin("*")
@Controller
@RequestMapping("/provinces")
public class ProvinceController {
@Autowired
    private IProvinceService provinceService;

@GetMapping("")
    public ResponseEntity<Iterable<Province>> findAllProvince(){
    return new ResponseEntity<>(provinceService.findAll(), HttpStatus.OK);

}
}
