package co.edu.utp.isc.gia.proyectogia.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enfermedad_hereditaria")
public class EnfermedadesHereditariasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHereditarias;
    private String enfermedad;
    private String parentescoFamiliar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_historia_clinica", referencedColumnName = "idHistoriaClinica")
    private HistoriaClinicaEntity historiaClinica;
}
