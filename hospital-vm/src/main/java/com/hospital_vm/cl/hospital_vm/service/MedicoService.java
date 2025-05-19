package com.hospital_vm.cl.hospital_vm.service;

import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.hospital_vm.cl.hospital_vm.model.Atencion;
import com.hospital_vm.cl.hospital_vm.model.Medico;
import com.hospital_vm.cl.hospital_vm.repository.AtencionRepository;
import com.hospital_vm.cl.hospital_vm.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() { return medicoRepository.findAll(); }

    public Medico findById(long id) {
        return medicoRepository.findById(id).get();
    }
    public Medico save(Medico medico) { return medicoRepository.save(medico); }

    public void delete(long id) {medicoRepository.deleteById(id);}
}
