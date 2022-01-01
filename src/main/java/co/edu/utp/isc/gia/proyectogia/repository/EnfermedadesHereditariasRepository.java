package co.edu.utp.isc.gia.proyectogia.repository;

import co.edu.utp.isc.gia.proyectogia.entities.EnfermedadesHereditariasEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnfermedadesHereditariasRepository extends CrudRepository<EnfermedadesHereditariasEntity, Long> {
    List<EnfermedadesHereditariasEntity> findByHistoriaClinica_IdHistoriaClinica(Long id);
    boolean existsByHistoriaClinica_IdHistoriaClinica(Long id);
}
