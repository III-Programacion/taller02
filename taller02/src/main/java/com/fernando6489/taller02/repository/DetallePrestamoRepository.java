package com.fernando6489.taller02.repository;

import com.fernando6489.taller02.model.DetallePrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo, Long> {

}