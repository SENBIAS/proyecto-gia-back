package co.edu.utp.isc.gia.proyectogia.controller;

import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadesHereditariasDTO;
import co.edu.utp.isc.gia.proyectogia.dto.HistoriaClinicaDTO;
import co.edu.utp.isc.gia.proyectogia.services.EnfermedadesHereditariasService;
import co.edu.utp.isc.gia.proyectogia.services.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("historiaClinica")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinica;

    @Autowired
    private EnfermedadesHereditariasService enfermedadesHereditariasService;

    @PostMapping()
    public HistoriaClinicaDTO crearHistoriaClinica(@RequestBody HistoriaClinicaDTO historiaClinicaDTO){
        System.out.println(historiaClinicaDTO);
        return historiaClinica.crearHistoria(historiaClinicaDTO);
    }

    @GetMapping
    public HistoriaClinicaDTO buscarPorId(@RequestParam("id") Long id){
        return historiaClinica.buscarPorId(id);
    }

    @GetMapping("enfermedadesHereditarias")
    public List<EnfermedadesHereditariasDTO> buscarEnfermedadesHereditarias(@RequestParam("id") Long id /*Id historia clinica*/){
        return enfermedadesHereditariasService.buscarPorIdHistoria(id);
    }
}
