package co.edu.utp.isc.gia.proyectogia.services;

import co.edu.utp.isc.gia.proyectogia.dto.UsuarioMedicoDTO;

import java.util.List;

public interface UsuarioMedicoService {
    UsuarioMedicoDTO agregarMedico(UsuarioMedicoDTO usuarioMedicoDTO);

    boolean eliminarMedicoId(Long id);

    boolean actualizarMedico(UsuarioMedicoDTO usuarioMedicoDTO);

    UsuarioMedicoDTO buscarPorId(Long id);

    List<UsuarioMedicoDTO> buscarTodos();
}
