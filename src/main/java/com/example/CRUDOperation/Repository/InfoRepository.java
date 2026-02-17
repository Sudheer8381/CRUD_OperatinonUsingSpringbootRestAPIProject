package com.example.CRUDOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUDOperation.Model.ModelClass;

public interface InfoRepository extends JpaRepository<ModelClass, Long> {

}
