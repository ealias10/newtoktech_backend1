package com.example.demo.modal;


import lombok.*;

import javax.persistence.*;

@Table(name = "staf_information")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class staf_information {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "email", unique = true)
    private String email;





}
