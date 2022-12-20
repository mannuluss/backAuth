package com.example.turismoapppro.models.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "publicaciones")
public class Publicacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name="usuario_id")
    private Long Id_user;

    @Column(name="municipio_id")
    private Long Id_municipio;

    @Column(name="url_image")
    private String url_image;


    @JsonIgnoreProperties({"publicaciones", "hibernateLazyInitializer", "handler", "password"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

//    @JsonIgnoreProperties({"publicacion", "hibernateLazyInitializer", "handler"})
//    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL )
//    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
//    private List<Imagen> Imagenes;

    @JsonIgnoreProperties({"publicaciones", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipio_id", insertable = false, updatable = false)
    private Municipio municipio;

//    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(insertable = false, updatable = false)
//    private List<Resenia> resenias;
}
