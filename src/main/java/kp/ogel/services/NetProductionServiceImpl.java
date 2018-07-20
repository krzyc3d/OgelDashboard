package kp.ogel.services;

import kp.ogel.entity.IProductionRepository;
import kp.ogel.entity.Production;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NetProductionServiceImpl implements NetProductionService {

    private Integer productionGross = 0;
    private Integer productionScrap = 0;
//    IProductionRepository productionRepository;
//
//    public List<Production> findByMachine_name(String machine_name) {
//        List allDatabase = (List) productionRepository.findAll();
//        List<Production> dataFromOneMachine = new ArrayList<Production>();
//        for (Object machine :
//                allDatabase) {
//            switch (machine_name) {
//                case "4x2 brick mould":
//                    dataFromOneMachine.add((Production) machine);
//                case "3x2 brick mould":
//                    dataFromOneMachine.add((Production) machine);
//                case "2x2 brick mould":
//                    dataFromOneMachine.add((Production) machine);
//
//            }
//
//        } return dataFromOneMachine;
//    }
//

    @Override
    public Integer calculateTotalNetProductionFromOneMachineInSpecificPeroidOfTime(IProductionRepository productionRepository, String machineName, LocalDateTime localDateTime, LocalDateTime to) {
        switch (machineName) {
            case "4x2 brick mould":
                productionGross = productionRepository.countProductionDueToVariable("4x2 brick mould",
                        "PRODUCTION", localDateTime, to);
                productionScrap = productionRepository.countProductionDueToVariable("4x2 brick mould",
                        "SCRAP", localDateTime, to);

                return productionGross - productionScrap;
            case "3x2 brick mould":
                productionGross = productionRepository.countProductionDueToVariable("3x2 brick mould",
                        "PRODUCTION", localDateTime, to);
                productionScrap = productionRepository.countProductionDueToVariable("3x2 brick mould",
                        "SCRAP", localDateTime, to);

                return productionGross - productionScrap;
            case "2x2 brick mould":
                productionGross = productionRepository.countProductionDueToVariable("2x2 brick mould",
                        "PRODUCTION", localDateTime, to);
                productionScrap = productionRepository.countProductionDueToVariable("2x2 brick mould",
                        "SCRAP", localDateTime, to);
                return productionGross - productionScrap;
        }


        return productionGross - productionScrap;
    }
}
