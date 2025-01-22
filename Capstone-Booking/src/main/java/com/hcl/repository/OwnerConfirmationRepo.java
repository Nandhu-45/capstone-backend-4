package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.OwnerConfirmation;

@Repository
public interface OwnerConfirmationRepo extends JpaRepository<OwnerConfirmation, Integer>{

}
