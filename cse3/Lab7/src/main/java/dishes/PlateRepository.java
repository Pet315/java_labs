package dishes;

import java.util.ArrayList;
import java.util.List;

public class PlateRepository {

    private final List<Plate> plates = new ArrayList<Plate>();

    public PlateRepository() {
        Plate plate1 = new Plate();
        plate1.setId(1);
        plate1.setName("name744");;
        plate1.setColor("green");
        plate1.setDiameter(13);
        plate1.setCapacity(4);

        Plate plate2 = new Plate();
        plate2.setId(2);
        plate2.setName("name256");;
        plate2.setColor("red");
        plate2.setDiameter(15);
        plate2.setCapacity(6);
        plates.add(plate1);
        plates.add(plate2);

    }

    public void save(Plate plate) {
        plates.add(plate);
    }

    public void delete(Plate plate) {
        plates.remove(plate);
    }

    public void update(Plate plate) {
        plates.remove(plate);
        plates.add(plate);
    }

    public List<Plate> getAll() {
        return plates;
    }

    public Plate getById(Integer id) {
        return plates.get(id);
    }
}
