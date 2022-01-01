package co.edu.utp.isc.gia.proyectogia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoriaClinica;

    @JoinColumn(name="id_paciente", referencedColumnName = "idPaciente")
    @OneToOne(cascade = CascadeType.ALL)
    private UsuarioPacienteEntity usuarioPaciente;

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ProcedimientosEntity> procedimientosEntities;

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<EnfermedadesHereditariasEntity> enfermedadesHereditariasEntities;

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<EnfermedadPacienteEntity> enfermedadPacienteEntities;
}
