package co.edu.utp.isc.gia.proyectogia.controller;

import co.edu.utp.isc.gia.proyectogia.services.UsuarioMedicoService;
import co.edu.utp.isc.gia.proyectogia.services.impl.UsuarioMedicoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.utp.isc.gia.proyectogia.dto.UsuarioMedicoDTO;

import java.util.List;

@RestController
@RequestMapping("usuarioMedico")
public class UsuarioMedicoController {

    @Autowired
    private UsuarioMedicoService usuarioMedico;

    @PostMapping()
    public UsuarioMedicoDTO agregarMedico(@RequestBody UsuarioMedicoDTO usuarioMedicoDTO){
        return usuarioMedico.agregarMedico(usuarioMedicoDTO);
    }

    @DeleteMapping()
    public boolean eliminarMedico(@RequestParam("id") Long id){
        return usuarioMedico.eliminarMedicoId(id);
    }

    @PutMapping()
    public boolean actualizarMedico(@RequestBody UsuarioMedicoDTO usuarioMedicoDTO){
        return usuarioMedico.actualizarMedico(usuarioMedicoDTO);
    }

    @GetMapping()
    public UsuarioMedicoDTO buscarPorId(@RequestParam("id") Long id){
        return usuarioMedico.buscarPorId(id);
    }

    @GetMapping("mostrarTodos")
    public List<UsuarioMedicoDTO> buscarTodos(){
        return usuarioMedico.buscarTodos();
    }
}
