package co.edu.utp.isc.gia.proyectogia.services.impl;

import co.edu.utp.isc.gia.proyectogia.dto.UsuarioMedicoDTO;
import co.edu.utp.isc.gia.proyectogia.dto.UsuarioPacienteDTO;
import co.edu.utp.isc.gia.proyectogia.entities.UsuarioMedicoEntity;
import co.edu.utp.isc.gia.proyectogia.entities.UsuarioPacienteEntity;
import co.edu.utp.isc.gia.proyectogia.exceptions.UserNotFoundException;
import co.edu.utp.isc.gia.proyectogia.repository.UsuarioPacienteRepository;
import co.edu.utp.isc.gia.proyectogia.services.UsuarioPacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioPacienteServiceImpl implements UsuarioPacienteService {

    @Autowired
    private UsuarioPacienteRepository usuarioPacienteRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UsuarioPacienteDTO agregarPaciente(UsuarioPacienteDTO usuarioPacienteDTO) {
        UsuarioPacienteEntity usuarioPacienteEntity = modelMapper.map(usuarioPacienteDTO, UsuarioPacienteEntity.class);
        UsuarioPacienteEntity usuarioPacienteEntityPer = usuarioPacienteRepository.save(usuarioPacienteEntity);
        UsuarioPacienteDTO usuarioPacienteDTO1 = modelMapper.map(usuarioPacienteEntityPer,UsuarioPacienteDTO.class);
        return usuarioPacienteDTO1;
    }

    @Override
    public boolean eliminarPaciente(Long id) {
        if(usuarioPacienteRepository.existsById(id)){
            usuarioPacienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean actualizarPaciente(UsuarioPacienteDTO usuarioPacienteDTO) {
        if(usuarioPacienteRepository.existsById(usuarioPacienteDTO.getIdPaciente())){
            usuarioPacienteRepository.save(modelMapper.map(usuarioPacienteDTO, UsuarioPacienteEntity.class));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public UsuarioPacienteDTO buscarPorId(Long id) {
        if(usuarioPacienteRepository.existsById(id)){
            UsuarioPacienteEntity usuarioPacienteEntity = usuarioPacienteRepository.findById(id).get();
            return modelMapper.map(usuarioPacienteEntity, UsuarioPacienteDTO.class);
        }else{
            throw new UserNotFoundException("EL usuario no existe");
        }
    }

    @Override
    public List<UsuarioPacienteDTO> buscarTodos() {
        Iterable<UsuarioPacienteEntity> usuarioPacienteEntities = usuarioPacienteRepository.findAll();
        List<UsuarioPacienteDTO> usuarioPacienteDTOS = new ArrayList<>();

        for(UsuarioPacienteEntity usuarioPacienteEntity: usuarioPacienteEntities){
            usuarioPacienteDTOS.add(modelMapper.map(usuarioPacienteEntity,UsuarioPacienteDTO.class ));
        }
        return usuarioPacienteDTOS;
    }
}
