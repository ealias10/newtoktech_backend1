package com.example.demo.modal;
import lombok.*;

import javax.persistence.*;

@Table(name = "daily_attendance")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class daily_attendance {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cdate", nullable = false)
    private Data cdate;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    @ToString.Exclude
    private staf_information staf_information;

}
