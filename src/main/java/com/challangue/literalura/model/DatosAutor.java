package com.challangue.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        //Json alias nos permite leer y con jsonproperty nos permite leer y escribir
        @JsonAlias("name") String nombreAutor,
        @JsonAlias("birth_year") String añoNac,
        @JsonAlias("death_year") String añoDef
) {
}
