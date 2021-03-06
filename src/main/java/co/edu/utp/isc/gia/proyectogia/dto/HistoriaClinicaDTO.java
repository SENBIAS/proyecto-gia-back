package co.edu.utp.isc.gia.proyectogia.dto;

import co.edu.utp.isc.gia.proyectogia.entities.ProcedimientosEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HistoriaClinicaDTO {
    private Long idHistoriaClinica;
    private UsuarioPacienteDTO usuarioPaciente;
}
