package co.edu.uniquindio.microservicios.service;

import co.edu.uniquindio.microservicios.model.entity.EstadoEnvio;
import co.edu.uniquindio.microservicios.repository.EstadoEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EstadoEnvioService {

    @Autowired
    private EstadoEnvioRepository estadoEnvioRepository;

    public List<EstadoEnvio> findAll() {
        return estadoEnvioRepository.findAll();
    }

    public EstadoEnvio findById(Long id) {
        return estadoEnvioRepository.findById(id).orElse(null);
    }

    public EstadoEnvio save(EstadoEnvio estadoEnvio) {
        return estadoEnvioRepository.save(estadoEnvio);
    }

    public void deleteById(Long id) {
        estadoEnvioRepository.deleteById(id);
    }

    public EstadoEnvio findByNumeroSeguimiento(Long numeroSeguimiento) {
        return estadoEnvioRepository.findByNumeroSeguimiento(numeroSeguimiento);
    }

}
