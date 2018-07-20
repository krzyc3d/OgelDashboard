package kp.ogel.controllers;

import kp.ogel.entity.IProductionBrick;
import kp.ogel.entity.IProductionRepository;
import kp.ogel.entity.ProductionBrick;
import kp.ogel.services.NetProductionService;
import kp.ogel.services.ProcentageOfScrapService;
import kp.ogel.services.TemperatuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private LocalDateTime dayOfProduction = LocalDateTime.of(2018, 1, 7, 0, 0);
    private LocalDateTime endOfproductionDate = dayOfProduction.plusDays(1);
//    private final String END_TIME_PATTERN = " 00:00:00";
    private final NetProductionService netProductionService;
    private final ProcentageOfScrapService procentageOfScrapService;
    private final TemperatuerService temperatuerService;


    @Autowired
    private IProductionBrick productionBrick;
    @Autowired
    private IProductionRepository productionRepository;


    public DashboardController(NetProductionService netProductionService,
                               ProcentageOfScrapService procentageOfScrapService, TemperatuerService temperatuerService) {
        this.netProductionService = netProductionService;
        this.procentageOfScrapService = procentageOfScrapService;
        this.temperatuerService = temperatuerService;
    }


    @GetMapping
    public String getDashboardPage(Model model) {
        Integer machine4x2netProduction = netProductionService.
                calculateTotalNetProductionFromOneMachineInSpecificPeroidOfTime(productionRepository,
                        "4x2 brick mould", dayOfProduction, endOfproductionDate);
        String machine4x2scrapProcentage = procentageOfScrapService.
                calculateTheProcenatgeOfScrapFromOneMachineInSpecificPeroidOfTime(productionRepository,
                        "4x2 brick mould", dayOfProduction, endOfproductionDate);

        Integer machine3x2netProduction = netProductionService.
                calculateTotalNetProductionFromOneMachineInSpecificPeroidOfTime(productionRepository,
                        "3x2 brick mould", dayOfProduction, endOfproductionDate);
        String machine3x2scrapProcentage = procentageOfScrapService.
                calculateTheProcenatgeOfScrapFromOneMachineInSpecificPeroidOfTime(productionRepository,
                        "3x2 brick mould", dayOfProduction, endOfproductionDate);

        Integer machine2x2netProduction = netProductionService.
                calculateTotalNetProductionFromOneMachineInSpecificPeroidOfTime(productionRepository,
                        "2x2 brick mould", dayOfProduction, endOfproductionDate);
        String machine2x2scrapProcentage = procentageOfScrapService.
                calculateTheProcenatgeOfScrapFromOneMachineInSpecificPeroidOfTime(productionRepository,
                        "2x2 brick mould", dayOfProduction, endOfproductionDate);



//        model.addAttribute("min", LocalDateTime.of(2018, 1, 1, 0, 5));
//        model.addAttribute("max", LocalDateTime.of(2018, 1, 8, 23, 55));
//        model.addAttribute("productionDate", LocalDateTime.of(2018, 1, 8, 0, 0));
        model.addAttribute("machine4x2netProduction", machine4x2netProduction);
        model.addAttribute("machine4x2scrapProcentage", machine4x2scrapProcentage);
        model.addAttribute("machine3x2netProduction", machine3x2netProduction);
        model.addAttribute("machine3x2scrapProcentage", machine3x2scrapProcentage);
        model.addAttribute("machine2x2netProduction", machine2x2netProduction);
        model.addAttribute("machine2x2scrapProcentage", machine2x2scrapProcentage);

        model.addAttribute("machine4x2coreTemp",temperatuerService.searchTheHighestTemperatureInPeroidOfTime(
                productionRepository,"4x2 brick mould",dayOfProduction, endOfproductionDate));
        model.addAttribute("machine3x2coreTemp",temperatuerService.searchTheHighestTemperatureInPeroidOfTime(
                productionRepository,"3x2 brick mould",dayOfProduction, endOfproductionDate));
        model.addAttribute("machine2x2coreTemp",temperatuerService.searchTheHighestTemperatureInPeroidOfTime(
                productionRepository,"2x2 brick mould",dayOfProduction, endOfproductionDate));


        create24hoursTable("4x2 brick mould");
        create24hoursTable("3x2 brick mould");
        create24hoursTable("2x2 brick mould");

        model.addAttribute("mapOfProduction",productionBrick.findAll());
        productionBrick.deleteAll();
        return "dashboard.html";
    }

    private void create24hoursTable(String machine_name) {
        Integer machine2x2netProduction;

        for (int i = 0; i < 24; i++) {
            machine2x2netProduction = netProductionService.
                    calculateTotalNetProductionFromOneMachineInSpecificPeroidOfTime(productionRepository,
                            machine_name, dayOfProduction.plusHours(i), dayOfProduction.plusHours(i + 1));

            ProductionBrick productionOfHour = new ProductionBrick();
        if (productionOfHour.getKey()>0 ||productionOfHour.getKey()<24){
            productionOfHour.setMachine_Name(machine_name);
            productionOfHour.setKey(i);
            productionOfHour.setValue(machine2x2netProduction);
            productionBrick.save(productionOfHour);}}
    }
//    @PostMapping(path="/dashboard")
//    public String showProductionFormDate(@Validated @ModelAttribute("date") Production date,
//                                   BindingResult bindingResult) {
//
//        LocalDateTime productionDate = date.getDatetime_from();
//
//        dayOfProduction= productionDate;
//        System.out.println(dayOfProduction);
//        return "redirect:/dashboard";
//    }


}

