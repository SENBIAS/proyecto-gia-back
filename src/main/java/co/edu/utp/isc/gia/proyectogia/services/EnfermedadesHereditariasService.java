package co.edu.utp.isc.gia.proyectogia.services;

import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadesHereditariasDTO;

import java.util.List;

public interface EnfermedadesHereditariasService {
    EnfermedadesHereditariasDTO crearEnfermedadHereditaria(EnfermedadesHereditariasDTO enfermedadHereditariaDTO);

    boolean actualizarEnfermedadHereditaria(EnfermedadesHereditariasDTO enfermedadesHereditariasDTO);

    List<EnfermedadesHereditariasDTO> buscarPorIdHistoria(Long id);
}
