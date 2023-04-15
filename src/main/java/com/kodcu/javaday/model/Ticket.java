package com.kodcu.javaday.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public abstract class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne(cascade = CascadeType.ALL)
    protected Person person;
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    protected Set<Participant> participants;
    protected BigDecimal price = BigDecimal.ZERO;
    protected BigDecimal paidPrice = BigDecimal.ZERO;
    @Column(name = "discount_code")
    protected String discountCode;
    @Column(name = "is_paid")
    protected boolean isPaid;


}
