package com.example.demo2.Service;

import com.example.demo2.Model.Mascota;
import com.example.demo2.Repository.MascotaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MascotaServiceImp implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImp(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public Mascota guardarMas(Mascota mascota)
    {
        return mascotaRepository.save(mascota);
    }
    @Override
    public List<Mascota> encontrarMasAll()
    {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> encontrarById(Long id)
    {
        return mascotaRepository.findById(id);
    }
    @Override
    public boolean existenciaById(Long id)
    {
        return mascotaRepository.existsById(id);
    }
    @Override
    public void eliminarMasById(Long id)
    {
        mascotaRepository.deleteById(id);
    }

}
