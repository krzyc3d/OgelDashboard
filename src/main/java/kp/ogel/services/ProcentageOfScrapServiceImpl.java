package kp.ogel.services;

import kp.ogel.entity.IProductionRepository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Service
public class ProcentageOfScrapServiceImpl implements ProcentageOfScrapService {

    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private Double productionGross = 0.0;
    private Double productionScrap = 0.0;

    @Override
    public String calculateTheProcenatgeOfScrapFromOneMachineInSpecificPeroidOfTime(
            IProductionRepository productionRepository,
            String machineName,
            LocalDateTime from,
            LocalDateTime to) {

        switch (machineName) {
            case "4x2 brick mould":

                productionGross = Double.valueOf(productionRepository.countProductionDueToVariable(
                        "4x2 brick mould",
                        "PRODUCTION", from, to));
                productionScrap = Double.valueOf(productionRepository.countProductionDueToVariable(
                        "4x2 brick mould",
                        "SCRAP", from, to));

                return decimalFormat.format((productionScrap / productionGross) * 100) + "%";
            case "3x2 brick mould":
                productionGross = Double.valueOf(productionRepository.countProductionDueToVariable(
                        "3x2 brick mould",
                        "PRODUCTION", from, to));
                productionScrap = Double.valueOf(productionRepository.countProductionDueToVariable(
                        "3x2 brick mould",
                        "SCRAP", from, to));

                return decimalFormat.format((productionScrap / productionGross) * 100) + "%";
            case "2x2 brick mould":
                productionGross = Double.valueOf(productionRepository.countProductionDueToVariable(
                        "2x2 brick mould",
                        "PRODUCTION", from, to));
                productionScrap = Double.valueOf(productionRepository.countProductionDueToVariable(
                        "2x2 brick mould",
                        "SCRAP", from, to));
                return decimalFormat.format((productionScrap / productionGross) * 100) + "%";
        }


        return "bad argument";
    }


}
