package com.richcodes.POS.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


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
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private int qty;
    private Double costPrice;
    private Double sellingPrice;
    private LocalDate manufacturedDate;
    private LocalDate expirationDate;
    @CreationTimestamp
    private LocalDate dateCreated;
    private String barcode;
    @Enumerated
    private Stocks instocks;
    @ManyToOne( cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "shops_id") // column in the db
    private Shop shops;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Product() {
    }

    public Product(String name, Category category, String description, int qty, Double costPrice,
                   Double sellingPrice, LocalDate manufacturedDate, LocalDate expirationDate,
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
        this.dateCreated=LocalDate.now();
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
