package co.edu.utp.isc.gia.proyectogia.repository;

import co.edu.utp.isc.gia.proyectogia.entities.HistoriaClinicaEntity;
import co.edu.utp.isc.gia.proyectogia.entities.UsuarioMedicoEntity;
import org.springframework.data.repository.CrudRepository;

public interface HistoriaClinicaRepository extends CrudRepository<HistoriaClinicaEntity, Long> {
    HistoriaClinicaEntity findByUsuarioPaciente_IdPaciente(Long id);
    boolean existsByUsuarioPaciente_IdPaciente(Long id);
}
