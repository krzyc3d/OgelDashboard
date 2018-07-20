package kp.ogel.services;

import kp.ogel.entity.IProductionRepository;

import java.time.LocalDateTime;

public interface TemperatuerService {
    Integer searchTheHighestTemperatureInPeroidOfTime(IProductionRepository productionRepository,
                                                      String machineName,
                                                      LocalDateTime from,
                                                      LocalDateTime to) ;

}
