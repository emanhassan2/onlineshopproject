package edu.miu.cs425.onlineshoppingapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shoppingCartId;
    @Column(nullable = false)
    private LocalDate createdDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "shoppingCart")
    private List<CartItem> cartItem;
}
