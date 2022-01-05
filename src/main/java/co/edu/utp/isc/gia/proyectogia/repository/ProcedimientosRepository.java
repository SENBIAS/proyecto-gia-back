package co.edu.utp.isc.gia.proyectogia.repository;

import co.edu.utp.isc.gia.proyectogia.entities.ProcedimientosEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcedimientosRepository extends CrudRepository<ProcedimientosEntity, Long> {
    List<ProcedimientosEntity> findByHistoriaClinica_IdHistoriaClinica(Long id);
    boolean existsByHistoriaClinica_IdHistoriaClinica(Long id);
}
