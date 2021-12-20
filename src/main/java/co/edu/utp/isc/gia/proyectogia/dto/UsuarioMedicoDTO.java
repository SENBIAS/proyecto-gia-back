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
public class UsuarioMedicoDTO implements Serializable {
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
