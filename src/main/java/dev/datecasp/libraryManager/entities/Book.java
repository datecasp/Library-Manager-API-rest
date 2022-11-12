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

    //Constructors

    public Book()
    {
    }

    public Book(String tittle, String author, Enumerations.categories category)
    {
        this.tittle = tittle;
        this.author = author;
        this.category = category;
        this.avaliable = true;
    }

    //Getters and Setters

    public Long getBookId()
    {
        return bookId;
    }

    public String getTittle()
    {
        return tittle;
    }

    public void setTittle(String tittle)
    {
        this.tittle = tittle;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Enumerations.categories getCategory()
    {
        return category;
    }

    public void setCategory(Enumerations.categories category)
    {
        this.category = category;
    }

    public Boolean getAvaliable()
    {
        return avaliable;
    }

    public void setAvaliable(Boolean avaliable)
    {
        this.avaliable = avaliable;
    }

    //ToString()

    @Override
    public String toString()
    {
        return "Book{" +
                "bookId=" + bookId +
                ", tittle='" + tittle + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", avaliable=" + avaliable +
                '}';
    }
}
