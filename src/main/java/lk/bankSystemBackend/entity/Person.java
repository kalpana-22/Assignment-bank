package lk.bankSystemBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(nullable = false)
    private Integer phoneNumber;
    @Column(nullable = false)
    private String nic;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String gender;

    @JoinTable(name = "Bank_Person",
              joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "id"))
    @ManyToMany
    private Set<Bank> banks = new HashSet<>();

}
