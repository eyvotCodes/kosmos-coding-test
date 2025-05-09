package com.eyvot.kctapp.repository;

import com.eyvot.kctapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {}
