package com.villagebiz.chit.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberid")
    @SequenceGenerator(name = "memberid", sequenceName = "public.member_seq", allocationSize = 1)
    private Long Id;

    @NotBlank(message = "Please provide a Member Name")
    private String name;

    @Pattern(regexp="(^$|[0-9]{10})",message = "Please enter proper Mobile Number")
    @NotBlank(message = "Please provide a Member Mobile No")
    private String membermobileno;

    @NotBlank(message = "Please provide a Member Name")
    private String guardian;

    @Pattern(regexp="(^$|[0-9]{10})",message = "Please enter proper Mobile Number")
    @NotBlank(message = "Please provide a Member Mobile No")
    private String guardianmobileno;

    @NotBlank(message = "Please provide a Member Address")
    private String address;
}
