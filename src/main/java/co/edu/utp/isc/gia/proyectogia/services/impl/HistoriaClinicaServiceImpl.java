package co.edu.utp.isc.gia.proyectogia.services.impl;

import co.edu.utp.isc.gia.proyectogia.dto.HistoriaClinicaDTO;
import co.edu.utp.isc.gia.proyectogia.entities.HistoriaClinicaEntity;
import co.edu.utp.isc.gia.proyectogia.exceptions.UserNotFoundException;
import co.edu.utp.isc.gia.proyectogia.repository.HistoriaClinicaRepository;
import co.edu.utp.isc.gia.proyectogia.services.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public HistoriaClinicaDTO crearHistoria(HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinicaEntity historiaClinicaEntity = modelMapper.map(historiaClinicaDTO, HistoriaClinicaEntity.class);
        HistoriaClinicaEntity historiaClinicaEntityPer = historiaClinicaRepository.save(historiaClinicaEntity);
        HistoriaClinicaDTO historiaClinicaDTO1 = modelMapper.map(historiaClinicaEntityPer, HistoriaClinicaDTO.class);

        System.out.println(historiaClinicaDTO1);
        return historiaClinicaDTO1;
    }

    @Override
    public HistoriaClinicaDTO buscarPorId(Long id) {
        if(historiaClinicaRepository.existsByUsuarioPaciente_IdPaciente(id)) {
            HistoriaClinicaEntity historiaClinicaEntity = historiaClinicaRepository.findByUsuarioPaciente_IdPaciente(id);
            return modelMapper.map(historiaClinicaEntity, HistoriaClinicaDTO.class);
        }else{
            throw new UserNotFoundException("No existe historia clinica para ese paciente");
        }
    }
}
