package kp.ogel.services;

import kp.ogel.entity.IProductionRepository;
import kp.ogel.entity.Production;

import java.time.LocalDateTime;
import java.util.List;

public interface NetProductionService {

//    public List<Production> findByMachine_name(String machine_name);

    Integer calculateTotalNetProductionFromOneMachineInSpecificPeroidOfTime(IProductionRepository productionRepository,
                                                                            String machineName,
                                                                            LocalDateTime from, LocalDateTime to);



}
