package com.pedro.backendencurtadordeurl.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedro.backendencurtadordeurl.model.Url;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
public class UrlDTO {

    @Getter private String urlOriginal;
    @Getter private String urlEncurtada;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Getter private Date dataCriacao;
    @Getter private UsuarioDTO usuarioDTO;

    public Url dtoFromObject() {
        return new Url(urlOriginal, urlEncurtada, dataCriacao);
    }
}
