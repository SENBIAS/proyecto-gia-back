package co.edu.utp.isc.gia.proyectogia.controller;

import co.edu.utp.isc.gia.proyectogia.dto.HistoriaClinicaDTO;
import co.edu.utp.isc.gia.proyectogia.services.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("historiaClinica")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinica;

    @PostMapping()
    public HistoriaClinicaDTO crearHistoriaClinica(@RequestBody HistoriaClinicaDTO historiaClinicaDTO){
        return historiaClinica.crearHistoria(historiaClinicaDTO);
    }

    @GetMapping
    public HistoriaClinicaDTO buscarPorId(@RequestParam("id") Long id){
        return historiaClinica.buscarPorId(id);
    }
}
