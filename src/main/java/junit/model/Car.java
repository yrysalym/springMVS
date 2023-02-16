package junit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.java.BigDecimalTypeDescriptor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.math.BigDecimal;

/**
 * springMVS
 * 16.02.2023
 * user
 * чт
 **/
@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "car_id_gen")
    @SequenceGenerator(name = "car_id_gen",sequenceName = "car_id_seq",allocationSize = 1)
    private Long id;
    private String model;
    private BigDecimal decimal;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
    private Company company;
    @Transient
    private Long companyId;
}
