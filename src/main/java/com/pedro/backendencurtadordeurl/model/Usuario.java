package com.pedro.backendencurtadordeurl.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(force = true)
@EqualsAndHashCode(of = "id")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Integer id;
    @Column(unique = true)
    @Getter private String username;
    @Getter @Setter private String password;

    @OneToMany(mappedBy = "usuario")
    @Getter @Setter private List<Url> urls;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
