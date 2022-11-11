package dev.datecasp.libraryManager.entities;

import dev.datecasp.libraryManager.helpers.Enumerations;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Primary Key autoincrementally generated, type Long")
    private Long bookId;
    @Column(name = "tittle", length = 25)
    private String tittle;
    @Column(name = "author", length = 25)
    private String author;
    @Column(name = "category")
    private Enumerations.categories category;
    @Column(name = "description", length = 100)
    private String description;
    @Column(name = "year")
    private Integer year;
    @Column(name = "avaliable")
    private Boolean avaliable; //If the book is choosable to lend


}
