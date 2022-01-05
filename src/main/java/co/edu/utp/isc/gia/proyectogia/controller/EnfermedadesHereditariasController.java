package co.edu.utp.isc.gia.proyectogia.controller;


import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadesHereditariasDTO;
import co.edu.utp.isc.gia.proyectogia.services.EnfermedadesHereditariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enfermedadesHereditarias")
public class EnfermedadesHereditariasController {

    @Autowired
    private EnfermedadesHereditariasService enfermedadesHereditariasService;

    @PostMapping()
    public EnfermedadesHereditariasDTO crearEnfermedadHereditaria(@RequestBody EnfermedadesHereditariasDTO enfermedadHereditariaDTO){
        return enfermedadesHereditariasService.crearEnfermedadHereditaria(enfermedadHereditariaDTO);
    }

    @PutMapping()
    public boolean actualizarEnfermedadesHereditarias(@RequestBody EnfermedadesHereditariasDTO enfermedadesHereditariasDTO){
        return enfermedadesHereditariasService.actualizarEnfermedadHereditaria(enfermedadesHereditariasDTO);
    }

    @DeleteMapping()
    public boolean eliminarEnfermedadHereditaria(@RequestParam("id") Long id){
        return enfermedadesHereditariasService.eliminarEnfermedadHereditaria(id);
    }
}
