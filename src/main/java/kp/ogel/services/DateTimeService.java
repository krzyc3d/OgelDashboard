package kp.ogel.services;

import kp.ogel.entity.IProductionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public interface DateTimeService {

   List<Object> divideTimeAndReturnObjects(IProductionRepository productionRepository,LocalDateTime dayOfProduction);

}
