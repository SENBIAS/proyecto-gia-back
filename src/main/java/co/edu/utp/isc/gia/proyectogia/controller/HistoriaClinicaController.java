package co.edu.utp.isc.gia.proyectogia.controller;

import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadPacienteDTO;
import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadesHereditariasDTO;
import co.edu.utp.isc.gia.proyectogia.dto.HistoriaClinicaDTO;
import co.edu.utp.isc.gia.proyectogia.dto.ProcedimientosDTO;
import co.edu.utp.isc.gia.proyectogia.services.EnfermedadPacienteService;
import co.edu.utp.isc.gia.proyectogia.services.EnfermedadesHereditariasService;
import co.edu.utp.isc.gia.proyectogia.services.HistoriaClinicaService;
import co.edu.utp.isc.gia.proyectogia.services.ProcedimientosService;
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

    @Autowired
    private ProcedimientosService procedimientosService;

    @Autowired
    private EnfermedadPacienteService enfermedadPacienteService;

    @PostMapping()
    public HistoriaClinicaDTO crearHistoriaClinica(@RequestBody HistoriaClinicaDTO historiaClinicaDTO){
        System.out.println(historiaClinicaDTO);
        return historiaClinica.crearHistoria(historiaClinicaDTO);
    }

    @GetMapping()
    public HistoriaClinicaDTO buscarPorId(@RequestParam("id") Long id){
        return historiaClinica.buscarPorId(id);
    }

    @GetMapping("enfermedadesHereditarias")
    public List<EnfermedadesHereditariasDTO> buscarEnfermedadesHereditarias(@RequestParam("id") Long id /*Id historia clinica*/){
        return enfermedadesHereditariasService.buscarPorIdHistoria(id);
    }

    @GetMapping("procedimientos")
    public List<ProcedimientosDTO> buscarProcedimientos(@RequestParam("id") Long id /*Id historia clinica*/){
        return procedimientosService.buscarProcedimientosHC(id);
    }

    @GetMapping("enfermedadesPaciente")
    public List<EnfermedadPacienteDTO> buscarEnfermedadesPaciente(@RequestParam("id") Long id /*Id historia clinica*/){
        return enfermedadPacienteService.buscarEnfermedadesPaciente(id);
    }
}
