package com.kodcu.javaday.model;

import com.kodcu.javaday.enums.TicketType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @Email
    @NotBlank
    private String email;
    @Column(name = "ticket_type")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return name.equals(that.name) && lastname.equals(that.lastname) && email.equals(that.email) && ticketType == that.ticketType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, email, ticketType);
    }
}
