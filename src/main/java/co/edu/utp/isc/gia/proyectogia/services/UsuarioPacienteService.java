package co.edu.utp.isc.gia.proyectogia.services;

import co.edu.utp.isc.gia.proyectogia.dto.UsuarioPacienteDTO;

import java.util.List;

public interface UsuarioPacienteService {
    UsuarioPacienteDTO agregarPaciente(UsuarioPacienteDTO usuarioPacienteDTO);

    boolean eliminarPaciente(Long id);

    boolean actualizarPaciente(UsuarioPacienteDTO usuarioPacienteDTO);

    UsuarioPacienteDTO buscarPorId(Long id);

    List<UsuarioPacienteDTO> buscarTodos();
}
