package com.villagebiz.chit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name="appuser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "muser_id")
    @SequenceGenerator(name = "muser_id", sequenceName = "public.muser_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private Boolean isactive;
}
