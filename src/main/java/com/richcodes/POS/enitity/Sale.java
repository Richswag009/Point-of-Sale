package com.richcodes.POS.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String salesId;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<Product> products;
    private int qty;
    private double totalAmount;
    private  String paymentType;
    @CreationTimestamp
    private LocalDate dateCreated;
    private double amountTender;

    public Sale(Customer customer, String salesId, Category category, List<Product> products,
                int qty, double totalAmount, String paymentType, double amountTender) {
        this.customer = customer;
        this.salesId = generateSaleId();
//        this.category = category;
        this.products = products;
        this.qty = qty;
        this.totalAmount = totalAmount;
        this.paymentType = paymentType;
        this.amountTender = amountTender;
        this.dateCreated= LocalDate.now();
    }

    // Method to generate a unique sale ID (can be customized based on requirements)
    private String generateSaleId() {
        // Implementation to generate a unique sale ID (e.g., using UUID)
        return "SALE-" + LocalDateTime.now().toString();
    }
    public void addProduct(Product product) {
        if(products == null){
            products= new ArrayList<>();
        }
        products.add(product);
        totalAmount += product.getSellingPrice() * product.getQty();
    }



}
