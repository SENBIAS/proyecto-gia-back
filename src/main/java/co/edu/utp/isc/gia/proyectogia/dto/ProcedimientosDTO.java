package co.edu.utp.isc.gia.proyectogia.dto;

import co.edu.utp.isc.gia.proyectogia.entities.HistoriaClinicaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProcedimientosDTO {

    private Long idProcedimientos;
    private String descripcion;
    private String tipoProcedimiento;
    private Long idTipoProcedimiento;
    private UsuarioMedicoDTO usuarioMedico;
    private HistoriaClinicaDTO historiaClinica;
}
