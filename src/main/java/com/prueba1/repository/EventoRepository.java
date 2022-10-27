
package com.prueba1.repository;

import com.prueba1.entity.Evento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cristopher Cedeño
 */
public interface EventoRepository extends CrudRepository<Evento,Long> {
    
}
