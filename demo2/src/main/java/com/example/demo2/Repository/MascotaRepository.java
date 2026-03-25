package com.example.demo2.Repository;

import com.example.demo2.Model.Mascota;
import com.example.demo2.Service.MascotaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {

}
