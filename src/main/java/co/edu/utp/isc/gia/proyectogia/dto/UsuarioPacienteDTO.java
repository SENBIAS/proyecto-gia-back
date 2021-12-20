package co.edu.utp.isc.gia.proyectogia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioPacienteDTO implements Serializable {
    private Long idPaciente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Date fechaNacimiento;
    private String direccion;
    private String estadoCivil;
    private String numeroDocumento;
    private String descripcion;
}
