package co.edu.uniquindio.microservicios.service;

import co.edu.uniquindio.microservicios.model.entity.CancelarEnvio;
import co.edu.uniquindio.microservicios.repository.CancelarEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CancelarEnvioService {

    @Autowired
    private CancelarEnvioRepository cancelarEnvioRepository;

    public List<CancelarEnvio> findAll() {
        return cancelarEnvioRepository.findAll();
    }

    public CancelarEnvio findById(Long id) {
        return cancelarEnvioRepository.findById(id).orElse(null);
    }

    public CancelarEnvio save(CancelarEnvio cancelarEnvio) {
        return cancelarEnvioRepository.save(cancelarEnvio);
    }

    public void deleteById(Long id) {
        cancelarEnvioRepository.deleteById(id);
    }
}
