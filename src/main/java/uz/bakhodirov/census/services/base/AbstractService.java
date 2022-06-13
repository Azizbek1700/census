package uz.bakhodirov.census.services.base;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bakhodirov.census.mapper.base.BaseMapper;

/**
 * @param <R> Repository
 * @param <M> Mapper
 */
public abstract class AbstractService<R extends JpaRepository, M extends BaseMapper> {

    protected R repository;
    protected M mapper;


    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    protected AbstractService() {
    }
}
