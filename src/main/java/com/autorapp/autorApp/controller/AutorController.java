package com.autorapp.autorApp.controller;

import com.autorapp.autorApp.model.Autor;
import com.autorapp.autorApp.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/autori", "user/autori", "admin/autori"})
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/sviautori")
    public ResponseEntity<List<Autor>> dohvatiSveAutore()
    {
        List<Autor> autori = autorService.pronadiSveAutore();
        return new ResponseEntity<>(autori, HttpStatus.OK);
    }
    @GetMapping("/pronadi/{idBroj}")
    public ResponseEntity<Object> pronadiPoId(@PathVariable("idBroj") Long id)
    {
        Optional<Autor> pronadeniAutor = autorService.pronadiPoId(id);
        return new ResponseEntity<>(pronadeniAutor, HttpStatus.OK);
    }

    @PostMapping("/dodaj")
    public ResponseEntity<Autor> dodajAutora(@RequestBody Autor autor)
    {
        Autor noviAutor = autorService.dodajAutora(autor);
        return new ResponseEntity<>(noviAutor, HttpStatus.CREATED);
    }

    @PutMapping("/promjeni")
    public ResponseEntity<Autor> promjeniAutora(@RequestBody Autor autor)
    {
        Autor noviAutor = autorService.promjeniAutora(autor);
        return new ResponseEntity<>(noviAutor, HttpStatus.OK);
    }





    @DeleteMapping("/user/izbrisi/{idBroj}")
    public ResponseEntity<?> izbrisiAutoraPoId(@PathVariable("idBroj") Long idBroj)
    {
        autorService.izbrisiAutora(idBroj);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}