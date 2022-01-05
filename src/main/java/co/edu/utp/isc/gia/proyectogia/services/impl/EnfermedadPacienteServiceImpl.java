package co.edu.utp.isc.gia.proyectogia.services.impl;

import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadPacienteDTO;
import co.edu.utp.isc.gia.proyectogia.entities.EnfermedadPacienteEntity;
import co.edu.utp.isc.gia.proyectogia.exceptions.UserNotFoundException;
import co.edu.utp.isc.gia.proyectogia.repository.EnfermedadPacienteRepository;
import co.edu.utp.isc.gia.proyectogia.services.EnfermedadPacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnfermedadPacienteServiceImpl implements EnfermedadPacienteService {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private EnfermedadPacienteRepository enfermedadPacienteRepository;

    @Override
    public EnfermedadPacienteDTO crearEnfermedadPaciente(EnfermedadPacienteDTO enfermedadPacienteDTO) {
        EnfermedadPacienteEntity enfermedadPacienteEntity = modelMapper.map(enfermedadPacienteDTO, EnfermedadPacienteEntity.class);
        EnfermedadPacienteEntity enfermedadPacienteEntityPer = enfermedadPacienteRepository.save(enfermedadPacienteEntity);
        EnfermedadPacienteDTO enfermedadPacienteDTO1 = modelMapper.map(enfermedadPacienteEntityPer, EnfermedadPacienteDTO.class);
        return  enfermedadPacienteDTO1;
    }

    @Override
    public boolean actualizarEnfermedadPaciente(EnfermedadPacienteDTO enfermedadPacienteDTO) {
        if(enfermedadPacienteRepository.existsById(enfermedadPacienteDTO.getIdEnfermedadPaciente())){
            enfermedadPacienteRepository.save(modelMapper.map(enfermedadPacienteDTO, EnfermedadPacienteEntity.class));
            return true;
        }else{
            throw new UserNotFoundException("No existe esta enfermedad");
        }
    }

    @Override
    public boolean eliminarEnfermedadPaciente(Long id) {
        if(enfermedadPacienteRepository.existsById(id)){
            enfermedadPacienteRepository.deleteById(id);
            return true;
        }else{
            throw new UserNotFoundException("No existe enfermedad de paciente con este ID");
        }
    }

    @Override
    public List<EnfermedadPacienteDTO> buscarEnfermedadesPaciente(Long id) {
        if(enfermedadPacienteRepository.existsByHistoriaClinica_IdHistoriaClinica(id)){
            List<EnfermedadPacienteEntity> enfermedadPacienteEntities = enfermedadPacienteRepository.findByHistoriaClinica_IdHistoriaClinica(id);
            List<EnfermedadPacienteDTO> enfermedadPacienteDTOS = new ArrayList<>();

            for(EnfermedadPacienteEntity enfermedadPacienteEntity: enfermedadPacienteEntities){
                enfermedadPacienteDTOS.add(modelMapper.map(enfermedadPacienteEntity, EnfermedadPacienteDTO.class));
            }
            return enfermedadPacienteDTOS;
        }else{
            throw new UserNotFoundException("No se encontro enfermedad paciente asociada a la historia clinica");
        }
    }
}
