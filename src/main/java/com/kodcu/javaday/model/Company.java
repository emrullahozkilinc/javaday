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
public class Company extends Ticket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "invoice_address")
    private String invoiceAddress;
    private String city;
    @Column(name = "is_kdv_liability")
    private boolean isKDVLiability;
    @Column(name = "tax_id")
    private String taxId;
    @Column(name = "tax_office")
    private String taxOffice;
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
        Company company = (Company) o;
        return isKDVLiability == company.isKDVLiability && Objects.equals(id, company.id) && Objects.equals(companyName, company.companyName) && invoiceAddress.equals(company.invoiceAddress) && Objects.equals(city, company.city) && Objects.equals(taxId, company.taxId) && Objects.equals(taxOffice, company.taxOffice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, invoiceAddress, city, isKDVLiability, taxId, taxOffice);
    }
}
