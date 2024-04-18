package com.richcodes.POS.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String status;
    @OneToMany( mappedBy = "shops",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH
                    ,CascadeType.PERSIST,CascadeType.REFRESH}) //refers to "instructor" in course class
    private List<Product> products;

    public Shop() {
    }

    public Shop(String name, String address, String phoneNumber, String status) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }




}
