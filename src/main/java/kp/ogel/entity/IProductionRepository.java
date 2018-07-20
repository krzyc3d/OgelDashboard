package kp.ogel.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IProductionRepository extends CrudRepository<Production,Long>{



    @Query(value = "SELECT SUM(value) FROM Production p WHERE (p.machine_name=:machine_name AND p.variable_name=:variable_name)AND (p.datetime_from>=:datetime_from )AND (p.datetime_from<:datetime_ending )")
    Integer countProductionDueToVariable(@Param(value = "machine_name")String machine_name,
                                         @Param(value = "variable_name")String variable,
                                         @Param(value = "datetime_from")LocalDateTime datetime_from,
                                         @Param(value = "datetime_ending")LocalDateTime datetime_ending);


        @Query(value = "SELECT value FROM Production p WHERE (p.machine_name=:machine_name AND p.variable_name=:variable_name)AND (p.datetime_from>=:datetime_from )AND (p.datetime_from<:datetime_ending )")
        List<Object> searchProductionDataDueToVariable(@Param(value = "machine_name")String machine_name,
                                         @Param(value = "variable_name")String variable,
                                         @Param(value = "datetime_from")LocalDateTime datetime_from,
                                         @Param(value = "datetime_ending")LocalDateTime datetime_ending);

}
