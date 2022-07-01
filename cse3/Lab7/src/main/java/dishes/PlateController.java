package dishes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlateController {

    private final PlateService plateServ = new PlateService();

    @GetMapping("/get")
    public String showDishes(Model model) {
        List<Plate> plates = plateServ.getAll();
        model.addAttribute("objects", plates);
        return "dishes";
    }

//    @PostMapping("/getPlate")
//    public String getPlate(int id, Model model) {
//        Plate plate = plateServ.getById(id-1);
//        model.addAttribute("objects", plate);
//        return "result";
//    }

    @PostMapping("/post")
    public String addPlate(@ModelAttribute("plate") Plate plate, Model model) {
        plateServ.save(plate);
        return showDishes(model);
    }

    @PostMapping("/delete")
    public String deletePlate(int id, Model model) {
        Plate plate = plateServ.getById(id-1);
        plateServ.delete(plate);
        return showDishes(model);
    }

    @PostMapping("/put")
    public String updatePlate(@ModelAttribute("plate") Plate plate, Model model) {
        plateServ.update(plate);
        return showDishes(model);
    }

//    @RequestMapping(value="/", method=RequestMethod.GET)
//    public String getDishes(Model model) {
//        List<Plate> plates = plateServ.getAll();
//        model.addAttribute("objects", plates);
//        return "dishes";
//    }

}
