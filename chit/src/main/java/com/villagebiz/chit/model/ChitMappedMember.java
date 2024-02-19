package com.villagebiz.chit.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="chit_mapped_member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChitMappedMember implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chitmappedmember_id")
    @SequenceGenerator(name = "chitmappedmember_id", sequenceName = "public.chit_mapped_member_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chit_id")
    private Chit chit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
