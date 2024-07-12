package com.challangue.literalura.services;

import com.challangue.literalura.model.Libro;
import com.challangue.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repository;

}
