package com.hospital_vm.cl.hospital_vm.controller;

import com.hospital_vm.cl.hospital_vm.model.Atencion;
import com.hospital_vm.cl.hospital_vm.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atenciones")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<Atencion>> listar() {
        List<Atencion> atenciones = atencionService.findAll();
        if (atenciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }

    @PostMapping
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion) {
        Atencion atencionNueva = atencionService.save(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(atencionNueva);
        //      return new ResponseEntity<>(atencionNueva, HttpStatus.ACCEPTED;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> buscar(@PathVariable Integer id) {
        try {
            Atencion atencion = atencionService.findById(id);
            return ResponseEntity.ok(atencion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(@PathVariable Integer id, @RequestBody Atencion atencion) {
        try {
            Atencion aten = atencionService.findById(id);
            aten.setIdAtencion(id);
            aten.setFechaAtencion(atencion.getFechaAtencion());
            aten.setHoraAtencion(atencion.getHoraAtencion());
            aten.setCosto(atencion.getCosto());
            aten.setPaciente(atencion.getPaciente());
            aten.setMedico(atencion.getMedico());
            aten.setComentario(atencion.getComentario());

            atencionService.save(aten);
            return ResponseEntity.ok(atencion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id) {
        try {
            atencionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}