package junit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * springMVS
 * 16.02.2023
 * user
 * чт
 **/
@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "company_id_gen")
    @SequenceGenerator(name = "company_id_gen",sequenceName = "company_id_seq",allocationSize = 1,initialValue = 10)
    private Long id;
    private String name;
    private String country;
    private String logo;
    @OneToMany(mappedBy = "company",cascade = {CascadeType.ALL})
    private List<Car> carList;

}
