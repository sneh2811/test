package com.eduboooks.test.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A user.
 */
@Entity
@Table(name = "isbn")
@XmlRootElement
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "isbn", length = 60)
    private String isbn;

    @Column(name = "call_time", length = 60)
    private String callTime;

    @Column(name = "title", length = 60)
    private String title;

    @Column(name = "author", length = 60)
    private String author;

    @Column(name = "ship_weight", length = 60)
    private String shipWeight;

    @Column(name = "sellers", length = 60)
    private String sellers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShipWeight() {
        return shipWeight;
    }

    public void setShipWeight(String shipWeight) {
        this.shipWeight = shipWeight;
    }

    public String getSellers() {
        return sellers;
    }

    public void setSellers(String sellers) {
        this.sellers = sellers;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "ISBN{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
