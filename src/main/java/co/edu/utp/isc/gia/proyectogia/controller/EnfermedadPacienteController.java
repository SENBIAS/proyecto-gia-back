package co.edu.utp.isc.gia.proyectogia.controller;

import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadPacienteDTO;
import co.edu.utp.isc.gia.proyectogia.services.EnfermedadPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enfermedadPaciente")
public class EnfermedadPacienteController {

    @Autowired
    private EnfermedadPacienteService enfermedadPacienteService;

    @PostMapping()
    public EnfermedadPacienteDTO crearEnfermedadPaciente(@RequestBody EnfermedadPacienteDTO enfermedadPacienteDTO){
        return enfermedadPacienteService.crearEnfermedadPaciente(enfermedadPacienteDTO);
    }

    @PutMapping()
    public boolean actualizarEnfermedadPaciente(@RequestBody EnfermedadPacienteDTO enfermedadPacienteDTO){
        return enfermedadPacienteService.actualizarEnfermedadPaciente(enfermedadPacienteDTO);
    }

    @DeleteMapping()
    public boolean eliminarEnfermedadPaciente(@RequestParam("id") Long id){
        return enfermedadPacienteService.eliminarEnfermedadPaciente(id);
    }
}
