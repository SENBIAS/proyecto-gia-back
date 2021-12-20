package co.edu.utp.isc.gia.proyectogia.services.impl;

import co.edu.utp.isc.gia.proyectogia.dto.UsuarioMedicoDTO;
import co.edu.utp.isc.gia.proyectogia.entities.UsuarioMedicoEntity;
import co.edu.utp.isc.gia.proyectogia.repository.UsuarioMedicoRespository;
import co.edu.utp.isc.gia.proyectogia.services.UsuarioMedicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.utp.isc.gia.proyectogia.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioMedicoServiceImpl implements UsuarioMedicoService {

    @Autowired
    private UsuarioMedicoRespository usuarioMedicoRespository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UsuarioMedicoDTO agregarMedico(UsuarioMedicoDTO usuarioMedicoDTO) {
        UsuarioMedicoEntity usuarioMedicoEntity = modelMapper.map(usuarioMedicoDTO, UsuarioMedicoEntity.class);
        UsuarioMedicoEntity usuarioMedicoEntityPer = usuarioMedicoRespository.save(usuarioMedicoEntity);
        UsuarioMedicoDTO usuarioMedicoDTO1 = modelMapper.map(usuarioMedicoEntityPer,UsuarioMedicoDTO.class);
        return usuarioMedicoDTO1;
    }

    @Override
    public boolean eliminarMedicoId(Long id) {
        if(usuarioMedicoRespository.existsById(id)){
            usuarioMedicoRespository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean actualizarMedico(UsuarioMedicoDTO usuarioMedicoDTO) {
        if(usuarioMedicoRespository.existsById(usuarioMedicoDTO.getIdMedico())){
            usuarioMedicoRespository.save(modelMapper.map(usuarioMedicoDTO, UsuarioMedicoEntity.class));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public UsuarioMedicoDTO buscarPorId(Long id) {
        if(usuarioMedicoRespository.existsById(id)){
            UsuarioMedicoEntity usuarioMedicoEntity = usuarioMedicoRespository.findById(id).get();
            return modelMapper.map(usuarioMedicoEntity, UsuarioMedicoDTO.class);
        }else{
            throw new UserNotFoundException("EL usuario no existe");
        }
    }

    @Override
    public List<UsuarioMedicoDTO> buscarTodos() {
        Iterable<UsuarioMedicoEntity> usuarioMedicoEntities = usuarioMedicoRespository.findAll();
        List<UsuarioMedicoDTO> usuarioMedicoDTOS = new ArrayList<>();

        for(UsuarioMedicoEntity usuarioMedicoEntity: usuarioMedicoEntities){
            usuarioMedicoDTOS.add(modelMapper.map(usuarioMedicoEntity, UsuarioMedicoDTO.class));
        }
        return usuarioMedicoDTOS;
    }

}
