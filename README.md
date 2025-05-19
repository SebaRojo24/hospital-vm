
# Hospital V&M – Gestión de Pacientes y Atenciones

Este proyecto simula un sistema de gestión para el **Hospital Vida y Meditación** de Puerto Montt, el cual integra prácticas médicas tradicionales con terapias naturales. El sistema fue desarrollado en Java utilizando Spring Boot y JPA para modelar relaciones entre entidades como médicos, pacientes y atenciones.

## 🩺 Objetivo

Proveer una base para el desarrollo de una futura app móvil que permita:
- Registrar pacientes y médicos.
- Gestionar atenciones médicas.
- Generar reportes personalizados.

## ⚙️ Funcionalidades principales

- CRUD completo para **Pacientes**, **Médicos**, **Atenciones**, **Tipo de Usuario**, **FichaPaciente**.
- Relación entre entidades usando JPA:
  - `@OneToOne` entre Paciente y FichaPaciente.
  - `@OneToMany` y `@ManyToOne` para Atenciones.
- Validaciones de datos con anotaciones.
- Pruebas y verificación vía Postman.

## 📊 Reportes implementados

- Atenciones por paciente o por médico.
- Historial completo del paciente.
- Costos agrupados por tipo de usuario.
- Médicos con sus especialidades.
- Atenciones agrupadas por fecha.

## 🚀 Tecnologías

- Java 17
- Spring Boot
- Maven
- MySQL
- Postman

## 📁 Estructura recomendada

```
src/
├── controller/
├── model/
├── repository/
├── service/
└── dto/
```

## 📝 Autor

Desarrollado como actividad práctica para la Escuela de Administración y Negocios – Duoc UC.
