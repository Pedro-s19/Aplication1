package com.example.demo2.Service;

import com.example.demo2.Model.Mascota;
import jdk.jfr.Category;

import java.util.List;
import java.util.Optional;

public interface MascotaService {

    Mascota guardarMas(Mascota mascota);
    List<Mascota> encontrarMasAll();
    Optional<Mascota> encontrarById(Long id);
    void eliminarMasById(Long id);
    boolean existenciaById(Long id);


}
