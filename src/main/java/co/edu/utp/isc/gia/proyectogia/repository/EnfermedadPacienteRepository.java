package co.edu.utp.isc.gia.proyectogia.repository;

import co.edu.utp.isc.gia.proyectogia.dto.EnfermedadPacienteDTO;
import co.edu.utp.isc.gia.proyectogia.entities.EnfermedadPacienteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnfermedadPacienteRepository extends CrudRepository<EnfermedadPacienteEntity, Long> {
    List<EnfermedadPacienteEntity> findByHistoriaClinica_IdHistoriaClinica(Long id);
    boolean existsByHistoriaClinica_IdHistoriaClinica(Long id);

}
