
package com.prueba1.service;

import com.prueba1.entity.Evento;
import java.util.List;

/**
 *
 * @author Cristopher Cedeño
 */
public interface IEventoService {
    public List<Evento> getAllEvento();
    public Evento getEventoById (long id);
    public void saveEvento (Evento evento);
    public void delete(long id);
}
