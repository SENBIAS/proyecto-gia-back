package co.edu.utp.isc.gia.proyectogia.services.impl;

import co.edu.utp.isc.gia.proyectogia.dto.ProcedimientosDTO;
import co.edu.utp.isc.gia.proyectogia.entities.ProcedimientosEntity;
import co.edu.utp.isc.gia.proyectogia.repository.ProcedimientosRepository;
import co.edu.utp.isc.gia.proyectogia.services.ProcedimientosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedimientosServiceImpl implements ProcedimientosService {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProcedimientosRepository procedimientosRepository;

    @Override
    public ProcedimientosDTO crearProcedimiento(ProcedimientosDTO procedimientoDTO) {
        ProcedimientosEntity procedimientosEntity = modelMapper.map(procedimientoDTO, ProcedimientosEntity.class);
        ProcedimientosEntity procedimientosEntityPer = procedimientosRepository.save(procedimientosEntity);
        ProcedimientosDTO procedimientosDTO01 = modelMapper.map(procedimientosEntityPer, ProcedimientosDTO.class);

        return procedimientosDTO01;
    }
}
