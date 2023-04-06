package com.assignment3.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment3.entities.Zipcode;

public interface ZipcodeRepository extends JpaRepository<Zipcode, Long>{
	Optional<Zipcode> findByZipcode(String zipcode);
}
