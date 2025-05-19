package com.hospital_vm.cl.hospital_vm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ficha_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FichaPaciente {

    @Id
    @Column(name = "id_paciente", nullable = false)
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @Column(name = "datos_personales", nullable = false, length = 100)
    private String datosPersonales;

    @Column(name = "datos_personales2", nullable = false, length = 100)
    private String datosPersonales2;

    @Column(name = "datos_personales3", nullable = false, length = 100)
    private String datosPersonales3;

    @Column(name = "datos_personales4", nullable = false, length = 100)
    private String datosPersonales4;

    @Column(name = "datos_personales5", nullable = false, length = 100)
    private String datosPersonales5;
}
