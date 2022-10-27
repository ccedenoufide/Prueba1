package com.prueba1.controller;

import com.prueba1.entity.Artista;
import com.prueba1.entity.Evento;
import com.prueba1.entity.Lugar;
import com.prueba1.service.IArtistaService;
import com.prueba1.service.IEventoService;
import com.prueba1.service.ILugarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Cristopher Cedeño
 */
@Controller
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IArtistaService artistaService;

    @Autowired
    private ILugarService lugarService;

    @GetMapping("/evento")
    public String index(Model model) {
        List<Evento> listaEvento = eventoService.getAllEvento();
        model.addAttribute("titulo", "Tabla Eventos");
        model.addAttribute("eventos", listaEvento);
        return "evento";
    }

    @GetMapping("/eventoN")
    public String crearEvento(Model model) {
        List<Artista> listaArtistas = artistaService.listArtista();
        List<Lugar> listaLugares = lugarService.listLugar();
        model.addAttribute("evento", new Evento());
        model.addAttribute("artistas", listaArtistas);
        model.addAttribute("lugares", listaLugares);
        return "crear";
    }

    @PostMapping("/save")
    public String guardarEvento(@ModelAttribute Evento evento) {
        eventoService.saveEvento(evento);
        return "redirect:/evento";
    }

    @GetMapping("/editEvento/{id}")
    public String editarEvento(@PathVariable("id") Long idEvento, Model model) {
        Evento evento = eventoService.getEventoById(idEvento);
        List<Artista> listaArtistas = artistaService.listArtista();
        List<Lugar> listaLugares = lugarService.listLugar();
        model.addAttribute("evento", new Evento());
        model.addAttribute("artistas", listaArtistas);
        model.addAttribute("lugares", listaLugares);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarEvento(@PathVariable("id") Long idEvento) {
        eventoService.delete(idEvento);
        return "redirect:/evento";
    }

}
