
package com.prueba1.service;

import com.prueba1.entity.Artista;
import com.prueba1.repository.ArtistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristopher Cedeño
 */
@Service
public class ArtistaService implements IArtistaService{
    
    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Artista> listArtista() {
        return (List<Artista>)artistaRepository.findAll();
    }
    
    
}
