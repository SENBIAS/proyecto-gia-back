package co.edu.utp.isc.gia.proyectogia.services;

import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadPacienteDTO;

import java.util.List;

public interface EnfermedadPacienteService {
    EnfermedadPacienteDTO crearEnfermedadPaciente(EnfermedadPacienteDTO enfermedadPacienteDTO);

    boolean actualizarEnfermedadPaciente(EnfermedadPacienteDTO enfermedadPacienteDTO);

    boolean eliminarEnfermedadPaciente(Long id);

    List<EnfermedadPacienteDTO> buscarEnfermedadesPaciente(Long id);
}
