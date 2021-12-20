package co.edu.utp.isc.gia.proyectogia.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario_medico")
public class UsuarioMedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;
    private String numeroDocumento;
    private String especialidad;
    private String genero;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String ips;
    private Date fechaNacimiento;
}
