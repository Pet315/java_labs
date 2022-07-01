package dishes;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RController {
    private final PlateService plateServ = new PlateService();

    @GetMapping("/dishes")
    List<Plate> getDishes() {
        return plateServ.getAll();
    }

//    @PostMapping("/id_plate")
//    Plate getPlateById(@RequestBody Integer id) {
//        return plateServ.getDishForm.mustache(id);
//    }
}
