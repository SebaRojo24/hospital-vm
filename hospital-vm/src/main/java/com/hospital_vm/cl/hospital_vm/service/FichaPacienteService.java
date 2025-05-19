package com.hospital_vm.cl.hospital_vm.service;

import com.hospital_vm.cl.hospital_vm.model.FichaPaciente;
import com.hospital_vm.cl.hospital_vm.model.Paciente;
import com.hospital_vm.cl.hospital_vm.repository.FichaPacienteRepository;
import com.hospital_vm.cl.hospital_vm.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FichaPacienteService {

    @Autowired
    private FichaPacienteRepository fichaPacienteRepository;

    public List<FichaPaciente> findAll() {
        return fichaPacienteRepository.findAll();
    }

    public FichaPaciente findById(long id) {
        return fichaPacienteRepository.findById(id).get();
    }

    public FichaPaciente save(FichaPaciente fichaPaciente) {
        return fichaPacienteRepository.save(fichaPaciente);
    }

    public void delete(Long id) {
        fichaPacienteRepository.deleteById(id);
    }
}
