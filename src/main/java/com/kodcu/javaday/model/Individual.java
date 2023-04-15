package com.kodcu.javaday.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Individual extends Ticket{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "invoice_address")
    private String invoiceAddress;
    private String city;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual that = (Individual) o;
        return Objects.equals(id, that.id) && Objects.equals(nationalId, that.nationalId) && invoiceAddress.equals(that.invoiceAddress) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalId, invoiceAddress, city);
    }
}
