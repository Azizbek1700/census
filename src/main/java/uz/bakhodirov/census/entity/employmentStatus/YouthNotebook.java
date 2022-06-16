package uz.bakhodirov.census.entity.employmentStatus;


import lombok.Getter;
import lombok.Setter;
import uz.bakhodirov.census.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class YouthNotebook implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false,unique = true)
    String code;

    @ManyToOne(optional = false)
    YouthNotebook youthNotebook;

}
