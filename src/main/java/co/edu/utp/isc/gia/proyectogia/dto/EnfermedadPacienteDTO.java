package co.edu.utp.isc.gia.proyectogia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnfermedadPacienteDTO {

    private String enfermedad;
    private Long idEnfermedadPaciente;
    private HistoriaClinicaDTO historiaClinica;
}
