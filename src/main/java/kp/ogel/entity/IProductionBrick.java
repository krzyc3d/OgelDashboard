package kp.ogel.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductionBrick  extends CrudRepository<ProductionBrick,Long> {
    @Override
    Optional<ProductionBrick> findById(Long aLong);
}
