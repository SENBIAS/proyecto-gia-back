package co.edu.utp.isc.gia.proyectogia.services.impl;

import co.edu.utp.isc.gia.proyectogia.dto.ProcedimientosDTO;
import co.edu.utp.isc.gia.proyectogia.entities.ProcedimientosEntity;
import co.edu.utp.isc.gia.proyectogia.exceptions.UserNotFoundException;
import co.edu.utp.isc.gia.proyectogia.repository.ProcedimientosRepository;
import co.edu.utp.isc.gia.proyectogia.services.ProcedimientosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean actualizarProcedimiento(ProcedimientosDTO procedimientosDTO) {
        if(procedimientosRepository.existsById(procedimientosDTO.getIdProcedimientos())){
            procedimientosRepository.save(modelMapper.map(procedimientosDTO, ProcedimientosEntity.class));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean eliminarProcedimiento(Long id) {
        if(procedimientosRepository.existsById(id)){
            procedimientosRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<ProcedimientosDTO> buscarProcedimientosHC(Long id) {
        if(procedimientosRepository.existsByHistoriaClinica_IdHistoriaClinica(id)){
            List<ProcedimientosEntity> procedimientosEntities = procedimientosRepository.findByHistoriaClinica_IdHistoriaClinica(id);
            List<ProcedimientosDTO> procedimientosDTOS = new ArrayList<>();

            for(ProcedimientosEntity procedimientosEntity: procedimientosEntities){
                procedimientosDTOS.add(modelMapper.map(procedimientosEntity, ProcedimientosDTO.class));
            }

            return procedimientosDTOS;
        }else{
            throw new UserNotFoundException("No se encontro procedimiento perteneciente a la historia clinica");
        }
    }
}
