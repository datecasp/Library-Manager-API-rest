package dev.datecasp.libraryManager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.datecasp.libraryManager.helpers.Enumerations;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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
//    @Column(name = "description", length = 100)
//    private String description;
//    @Column(name = "year")
//    private Integer year;
    @Column(name = "avaliable")
    private Boolean avaliable; //If the book is choosable to lend




}
