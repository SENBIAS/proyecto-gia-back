package co.edu.utp.isc.gia.proyectogia.controller;

import co.edu.utp.isc.gia.proyectogia.dto.ProcedimientosDTO;
import co.edu.utp.isc.gia.proyectogia.services.ProcedimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("procedimientos")
public class ProcedimientosController {

    @Autowired
    private ProcedimientosService procedimientos;

    @PostMapping()
    public ProcedimientosDTO crearProcedimiento(@RequestBody ProcedimientosDTO procedimientoDTO){
        return procedimientos.crearProcedimiento(procedimientoDTO);
    }

    @PutMapping()
    public boolean actualizarProcedimiento(@RequestBody ProcedimientosDTO procedimientosDTO){
        return procedimientos.actualizarProcedimiento(procedimientosDTO);
    }

    @DeleteMapping()
    public boolean eliminarProcedimiento(@RequestParam("id") Long id){
        return procedimientos.eliminarProcedimiento(id);
    }
}
