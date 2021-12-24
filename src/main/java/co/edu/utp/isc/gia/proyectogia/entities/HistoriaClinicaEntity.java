package co.edu.utp.isc.gia.proyectogia.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historia_clinica;

    @JoinColumn(name="id_paciente", referencedColumnName = "idPaciente")
    @OneToOne(cascade = CascadeType.ALL)
    private UsuarioPacienteEntity usuarioPaciente;

}
