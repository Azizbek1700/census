package uz.bakhodirov.census.repository.quarter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.bakhodirov.census.entity.quarter.Quarter;
import uz.bakhodirov.census.entity.todo.Todo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface QuarterRepository extends JpaRepository<Quarter,Long> {

    boolean existsByNameAndDeletedFalse(String name);

    Optional<Quarter> findByIdAndDeletedFalse(Long id);


    @Transactional
    @Modifying
    @Query(value = "update quarter t set deleted=true where  t.id=?1 and not t.deleted",nativeQuery = true)
    void delete(Long id);

    List<Quarter> findAllByDeletedFalse();


}
