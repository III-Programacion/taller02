package com.fernando6489.taller02.repository;

import com.fernando6489.taller02.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {

}