package kp.ogel.services;

import kp.ogel.entity.IProductionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatuerService {
    @Override
    public Integer searchTheHighestTemperatureInPeroidOfTime(IProductionRepository productionRepository,
                                                             String machineName, LocalDateTime from, LocalDateTime to) {
        List<Object> temperatures = new ArrayList<>();
        switch (machineName) {
            case "4x2 brick mould":

                temperatures = productionRepository.searchProductionDataDueToVariable(
                        "4x2 brick mould",
                        "CORE TEMPERATURE", from, to);

            case "3x2 brick mould":
                temperatures = productionRepository.searchProductionDataDueToVariable(
                        "3x2 brick mould",
                        "CORE TEMPERATURE", from, to);


            case "2x2 brick mould":
                temperatures = productionRepository.searchProductionDataDueToVariable(
                        "2x2 brick mould",
                        "CORE TEMPERATURE", from, to);
        }
        Integer maxTemperature = 0;
        for (Object coreTemperature : temperatures
                ) {

            if ((Integer) coreTemperature > maxTemperature) {
                maxTemperature = (Integer) coreTemperature;
            }


        }
        return maxTemperature;
    }

}
