package co.edu.utp.isc.gia.proyectogia.controller;

import co.edu.utp.isc.gia.proyectogia.dto.UsuarioMedicoDTO;
import co.edu.utp.isc.gia.proyectogia.dto.UsuarioPacienteDTO;
import co.edu.utp.isc.gia.proyectogia.repository.UsuarioPacienteRepository;
import co.edu.utp.isc.gia.proyectogia.services.UsuarioPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarioPaciente")
public class UsuarioPacienteController {

    @Autowired
    private UsuarioPacienteService usuarioPaciente;

    @PostMapping()
    public UsuarioPacienteDTO agregarPaciente(@RequestBody UsuarioPacienteDTO usuarioPacienteDTO){
        return usuarioPaciente.agregarPaciente(usuarioPacienteDTO);
    }

    @DeleteMapping()
    public boolean eliminarPaciente(@RequestParam("id") Long id){
        return usuarioPaciente.eliminarPaciente(id);
    }

    @PutMapping()
    public boolean actualizarPaciente(@RequestBody UsuarioPacienteDTO usuarioPacienteDTO){
        return usuarioPaciente.actualizarPaciente(usuarioPacienteDTO);
    }

    @GetMapping()
    public UsuarioPacienteDTO buscarPorId(@RequestParam("id") Long id){
        return usuarioPaciente.buscarPorId(id);
    }

    @GetMapping("mostrarTodos")
    public List<UsuarioPacienteDTO> buscarTodos(){
        return usuarioPaciente.buscarTodos();
    }
}
