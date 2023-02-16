package junit.controller;

import junit.model.Car;
import junit.service.CarService;
import junit.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final CompanyService companyService;


    public CarController(CarService carService, CompanyService companyService) {
        this.carService = carService;
        this.companyService = companyService;
    }

    @GetMapping
    String findAll(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("/savePage")
    String create(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("companies", companyService.findAll());
        return "carSavePage";
    }

    @PostMapping("/save")
  public   String save(Car car) {
        carService.save(car);
        return "redirect:/cars";
    }
}
