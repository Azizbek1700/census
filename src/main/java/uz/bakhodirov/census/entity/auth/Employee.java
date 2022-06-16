package uz.bakhodirov.census.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.bakhodirov.census.entity.base.Auditable;
import uz.bakhodirov.census.entity.employmentStatus.*;
import uz.bakhodirov.census.entity.quarter.Quarter;
import uz.bakhodirov.census.enums.FamilyStatus;
import uz.bakhodirov.census.enums.Gender;
import uz.bakhodirov.census.enums.Role;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Where(clause = "deleted is false")
public class Employee extends Auditable  {

    @Column(nullable = false)
    private String fullName;



    @Column(nullable = false,unique = true)
    private String phoneNumber;



    @Column(nullable = false)
    private String passportInfo;


    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FamilyStatus familyStatus;


    // MFY

    @OneToOne(cascade = CascadeType.ALL)
    private Quarter quarter;

    @Column(nullable = false)
    private String address;

    @OneToOne(fetch = FetchType.EAGER)
    private EmploymentStatus employmentStatus;

    @OneToOne(fetch = FetchType.EAGER)
    private Educationalnfo educationalnfo;

    @OneToOne(fetch = FetchType.EAGER)
    private HealthStatus healthStatus;

    @OneToOne(fetch = FetchType.EAGER)
    private YouthNotebook youthNotebook;

    @OneToMany(fetch = FetchType.EAGER)
    private List<SocialStatus>  socialStatus;



}
