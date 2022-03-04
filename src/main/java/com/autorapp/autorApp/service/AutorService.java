package com.autorapp.autorApp.service;

import com.autorapp.autorApp.model.Autor;
import com.autorapp.autorApp.repo.AutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepo autorRepo;

    @Autowired
    public AutorService(AutorRepo autorRepo) {
        this.autorRepo = autorRepo;
    }

    public Autor dodajAutora (Autor autor)
    {
        return autorRepo.save(autor);
    }

    public List<Autor> pronadiSveAutore()
    {
        return autorRepo.findAll();
    }

    public Autor promjeniAutora (Autor autor)
    {
        return autorRepo.save(autor);
    }

    public void izbrisiAutora(Long idBroj)
    {
        autorRepo.deleteById(idBroj);
    }

    public Optional<Autor> pronadiPoId(Long id)
    {
        return autorRepo.findById(id);
    }





}