package co.edu.utp.isc.gia.proyectogia.services;

import co.edu.utp.isc.gia.proyectogia.dto.HistoriaClinicaDTO;

public interface HistoriaClinicaService {
    HistoriaClinicaDTO crearHistoria(HistoriaClinicaDTO historiaClinicaDTO);

    HistoriaClinicaDTO buscarPorId(Long id);
}
