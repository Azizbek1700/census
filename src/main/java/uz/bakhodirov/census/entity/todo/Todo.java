package uz.bakhodirov.census.entity.todo;


import lombok.Getter;
import lombok.Setter;
import uz.bakhodirov.census.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Todo extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private Long userId;


}
