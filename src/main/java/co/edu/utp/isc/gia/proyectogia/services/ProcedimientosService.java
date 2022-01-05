package co.edu.utp.isc.gia.proyectogia.services;

import co.edu.utp.isc.gia.proyectogia.dto.ProcedimientosDTO;

import java.util.List;

public interface ProcedimientosService {
    ProcedimientosDTO crearProcedimiento(ProcedimientosDTO procedimientoDTO);

    boolean actualizarProcedimiento(ProcedimientosDTO procedimientosDTO);

    boolean eliminarProcedimiento(Long id);

    List<ProcedimientosDTO> buscarProcedimientosHC(Long id);
}
