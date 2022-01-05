package co.edu.utp.isc.gia.proyectogia.entities;

import co.edu.utp.isc.gia.proyectogia.dto.HistoriaClinicaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "procedimientos")
public class ProcedimientosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcedimientos;
    private String descripcion;
    private String tipoProcedimiento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_historia_clinica",referencedColumnName = "idHistoriaClinica")
    private HistoriaClinicaEntity historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_medico",referencedColumnName = "idMedico")
    private UsuarioMedicoEntity usuarioMedico;
}
