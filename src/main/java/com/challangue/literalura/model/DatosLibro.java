package com.challangue.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        //Json alias nos permite leer y con jsonproperty nos permite leer y escribir
        @JsonAlias("Id") String id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autores
) {

}
