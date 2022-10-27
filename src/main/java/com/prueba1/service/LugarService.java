
package com.prueba1.service;

import com.prueba1.entity.Lugar;
import com.prueba1.repository.LugarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristopher Cedeño
 */
@Service
public class LugarService implements ILugarService{
    
    @Autowired
    private LugarRepository lugarRepository;

    @Override
    public List<Lugar> listLugar() {
        return (List<Lugar>)lugarRepository.findAll();
    }
    
}
