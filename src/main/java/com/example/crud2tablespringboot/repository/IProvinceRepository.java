package com.example.crud2tablespringboot.repository;

import com.example.crud2tablespringboot.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends JpaRepository<Province,Long> {
}
