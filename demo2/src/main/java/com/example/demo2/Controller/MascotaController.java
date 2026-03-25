package com.example.demo2.Controller;

import com.example.demo2.Model.Mascota;
import com.example.demo2.Service.MascotaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Mascotas")
public class MascotaController {

    private final MascotaServiceImp mascotaService;

    public MascotaController(MascotaServiceImp mascotaService) {
        this.mascotaService = mascotaService;
    }

    @PostMapping
    public ResponseEntity<Mascota> guardarMas(@RequestBody Mascota mascota)
    {
        Mascota guardarMas = mascotaService.guardarMas(mascota);
        return new ResponseEntity<>(guardarMas, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Mascota> mostrarTodos()
    {
        return mascotaService.encontrarMasAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> encontrarConId(@PathVariable Long id)
    {
        return mascotaService.encontrarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizarMasId(@PathVariable Long id, @RequestBody Mascota mascota)
    {
        if(!mascotaService.existenciaById(id))
        {
            return ResponseEntity.notFound().build();
        }
        mascota.setId(id);
        Mascota actualizarMasId = mascotaService.guardarMas(mascota);
        return ResponseEntity.ok(actualizarMasId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Mascota> eliminarMasId(@PathVariable Long id)
    {
        if(!mascotaService.existenciaById(id))
        {
            return ResponseEntity.notFound().build();
        }
        mascotaService.eliminarMasById(id);
        return ResponseEntity.noContent().build();
    }

}
