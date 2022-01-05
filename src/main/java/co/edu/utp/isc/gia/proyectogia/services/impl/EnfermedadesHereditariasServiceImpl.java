package co.edu.utp.isc.gia.proyectogia.services.impl;

import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadesHereditariasDTO;
import co.edu.utp.isc.gia.proyectogia.entities.EnfermedadesHereditariasEntity;
import co.edu.utp.isc.gia.proyectogia.entities.HistoriaClinicaEntity;
import co.edu.utp.isc.gia.proyectogia.exceptions.UserNotFoundException;
import co.edu.utp.isc.gia.proyectogia.repository.EnfermedadesHereditariasRepository;
import co.edu.utp.isc.gia.proyectogia.repository.HistoriaClinicaRepository;
import co.edu.utp.isc.gia.proyectogia.services.EnfermedadesHereditariasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnfermedadesHereditariasServiceImpl implements EnfermedadesHereditariasService {
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private EnfermedadesHereditariasRepository enfermedadesHereditariasRepository;

    @Override
    public EnfermedadesHereditariasDTO crearEnfermedadHereditaria(EnfermedadesHereditariasDTO enfermedadHereditariaDTO) {
        EnfermedadesHereditariasEntity enfermedadesHereditariasEntity = modelMapper.map(enfermedadHereditariaDTO, EnfermedadesHereditariasEntity.class);
        EnfermedadesHereditariasEntity enfermedadesHereditariasEntityPer = enfermedadesHereditariasRepository.save(enfermedadesHereditariasEntity);
        EnfermedadesHereditariasDTO enfermedadesHereditariasDTO = modelMapper.map(enfermedadesHereditariasEntityPer, EnfermedadesHereditariasDTO.class);
        return enfermedadesHereditariasDTO;
    }

    @Override
    public boolean actualizarEnfermedadHereditaria(EnfermedadesHereditariasDTO enfermedadesHereditariasDTO) {
       if(enfermedadesHereditariasRepository.existsById(enfermedadesHereditariasDTO.getIdHereditarias())){
           enfermedadesHereditariasRepository.save(modelMapper.map(enfermedadesHereditariasDTO, EnfermedadesHereditariasEntity.class));
           return true;
       }else{
           return false;
       }
    }

    @Override
    public List<EnfermedadesHereditariasDTO> buscarPorIdHistoria(Long id) {
        if(enfermedadesHereditariasRepository.existsByHistoriaClinica_IdHistoriaClinica(id)){
            List<EnfermedadesHereditariasEntity> enfermedadesHereditarias = enfermedadesHereditariasRepository.findByHistoriaClinica_IdHistoriaClinica(id);
            List<EnfermedadesHereditariasDTO> enfermedadesHereditariasDTOS = new ArrayList<>();


            for(EnfermedadesHereditariasEntity enfermedadesHereditariasEntity: enfermedadesHereditarias){
                enfermedadesHereditariasDTOS.add(modelMapper.map(enfermedadesHereditariasEntity,EnfermedadesHereditariasDTO.class));
            }

            return enfermedadesHereditariasDTOS;
        }else{
            throw new UserNotFoundException("No se encontro ninguna enfermedad hereditaria relacionada a la historia clinica");
        }
    }
    @Override
    public boolean eliminarEnfermedadHereditaria(Long id) {
        if(enfermedadesHereditariasRepository.existsById(id)){
            enfermedadesHereditariasRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
