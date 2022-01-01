package co.edu.utp.isc.gia.proyectogia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnfermedadesHereditariasDTO {

    private Long idHereditarias;
    private String enfermedad;
    private String parentescoFamiliar;
    private HistoriaClinicaDTO historiaClinica;
}
