package com.challangue.literalura.services;

public interface iConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
