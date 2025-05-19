package com.hospital_vm.cl.hospital_vm.controller;

import com.hospital_vm.cl.hospital_vm.model.FichaPaciente;
import com.hospital_vm.cl.hospital_vm.service.FichaPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fichaPacientes")
public class FichaPacienteController {
    @Autowired
    private FichaPacienteService fichaPacienteService;

    @GetMapping
    public ResponseEntity<List<FichaPaciente>> listar() {
        List<FichaPaciente> fichaPacientes = fichaPacienteService.findAll();
        if (fichaPacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fichaPacientes);
    }

    @PostMapping
    public ResponseEntity<FichaPaciente> guardar(@RequestBody FichaPaciente fichaPaciente) {
        FichaPaciente fichaPacienteNuevo = fichaPacienteService.save(fichaPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(fichaPacienteNuevo);
        //      return new ResponseEntity<>(fichaPacienteNuevo, HttpStatus.ACCEPTED;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaPaciente> buscar(@PathVariable Integer id) {
        try {
            FichaPaciente fichaPaciente = fichaPacienteService.findById(id);
            return ResponseEntity.ok(fichaPaciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaPaciente> actualizar(@PathVariable Integer id, @RequestBody FichaPaciente fichaPaciente) {
        try {
            FichaPaciente ficha = fichaPacienteService.findById(id);
            ficha.setId(id);
            ficha.setDatosPersonales(fichaPaciente.getDatosPersonales());
            ficha.setDatosPersonales2(fichaPaciente.getDatosPersonales2());
            ficha.setDatosPersonales3(fichaPaciente.getDatosPersonales3());
            ficha.setDatosPersonales4(fichaPaciente.getDatosPersonales4());
            ficha.setDatosPersonales5(fichaPaciente.getDatosPersonales5());

            fichaPacienteService.save(ficha);
            return ResponseEntity.ok(fichaPaciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id) {
        try {
            fichaPacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
