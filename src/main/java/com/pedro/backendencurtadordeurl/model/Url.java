package com.pedro.backendencurtadordeurl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Url implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Integer id;
    @Getter private String urlOriginal;
    @Getter @Setter private String hashUrl;
    @Getter @Setter private String urlEncurtada;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Getter private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Getter private Usuario usuario;

    public Url(String urlOriginal, String urlEncurtada, Date dataCriacao, Usuario usuario) {
        this.urlOriginal = urlOriginal;
        this.urlEncurtada = urlEncurtada;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
    }
}