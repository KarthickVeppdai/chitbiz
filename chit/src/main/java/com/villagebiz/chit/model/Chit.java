package com.villagebiz.chit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="chit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chitid")
    @SequenceGenerator(name = "chitid", sequenceName = "public.chit_seq", allocationSize = 1)
    private Long id;
    @NotBlank(message = "Please provide a Chit Name")
    private String name;
    private Date creation_date;
    private Integer amount;
    private Integer noofmemeber;
    private Integer balance;
    private Integer status;
    private Integer ongoingstatus;

    @OneToMany(mappedBy = "chit",fetch = FetchType.LAZY)
    private Set<ChitMappedMember> chitMappedMembers;
}
