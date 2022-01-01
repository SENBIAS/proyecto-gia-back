package co.edu.utp.isc.gia.proyectogia.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enfermedad_paciente")
public class EnfermedadPacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnfermedadPaciente;
    private String enfermedad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinicaEntity historiaClinica;
}
