package co.edu.uniquindio.microservicios.repository;

import co.edu.uniquindio.microservicios.model.entity.EstadoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Long> {

    @Query("SELECT e FROM EstadoEnvio e WHERE e.numeroSeguimiento = :numeroSeguimiento")
    EstadoEnvio findByNumeroSeguimiento(@Param("numeroSeguimiento") Long numeroSeguimiento);
}
