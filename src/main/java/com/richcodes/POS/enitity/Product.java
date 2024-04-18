package com.richcodes.POS.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


enum Stocks {
    INSTOCKS,
    NOTINSTOCKS,
}


@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;
    private String description;
    private int qty;
    private Double costPrice;
    private Double sellingPrice;
    private LocalDateTime manufacturedDate;
    private LocalDateTime expirationDate;
    private LocalDateTime dateCreated;
    private String barcode;
    @Enumerated
    private Stocks instocks;
    @ManyToOne( cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn() // column in the db
    private Shop shops;

    public Product() {
    }

    public Product(String name, String category, String description
            , int qty, Double costPrice, Double sellingPrice
            , LocalDateTime manufacturedDate, LocalDateTime expirationDate,
                   String barcode, Stocks instocks, Shop shops) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.qty = qty;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.manufacturedDate = manufacturedDate;
        this.expirationDate = expirationDate;
        this.barcode = barcode;
        this.instocks = instocks;
        this.shops = shops;
        this.dateCreated=LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", costPrice=" + costPrice +
                ", sellingPrice=" + sellingPrice +
                ", manufacturedDate=" + manufacturedDate +
                ", expirationDate=" + expirationDate +
                ", dateCreated=" + dateCreated +
                ", barcode='" + barcode + '\'' +
                ", instocks=" + instocks +
                ", shops=" + shops +
                '}';
    }
}
