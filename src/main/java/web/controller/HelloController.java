package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private final CarDAO carDAO;

    @Autowired
    public HelloController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

//	@GetMapping(value = "/cars")
//	public String printCars(ModelMap model) {
//		model.addAttribute("cars", carDAO.carsList());
//		return "cars";
//	}


//	@GetMapping(value = "/cars/{id}")
//	public String show(@PathVariable("id") int id, ModelMap model) {
//		model.addAttribute("carsCount", carDAO.showCars(id));
//		return "show";
//	}

    @GetMapping(value = "/cars")
    public String show(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        if (count != null) {
            model.addAttribute("cars", carDAO.showCars(count));
        } else {
            model.addAttribute("cars", carDAO.carsList());
        }
        return "cars";
    }

}