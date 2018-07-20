//package kp.ogel.services;
//
//import kp.ogel.entity.IProductionRepository;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class DateTimeServiceImpl implements DateTimeService {
//
//    @Override
//    public List<Object> divideTimeAndReturnObjects(NetProductionService netProductionService,
//                                                   IProductionRepository productionRepository,
//                                                   LocalDateTime dayOfProduction) {
//        List timeList= new ArrayList();
//        for (int i = 0; i <24 ; i++) {
//            Integer machine2x2netProduction = netProductionService.
//                    calculateTotalNetProductionFromOneMachineInSpecificPeroidOfTime(productionRepository,
//                            "2x2 brick mould", dayOfProduction.plusHours(i),dayOfProduction.plusHours(i+1) );
//        }
//}
