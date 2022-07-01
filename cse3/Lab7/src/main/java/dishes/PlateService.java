package dishes;
import java.util.List;

public class PlateService {

    private final PlateRepository plateRepos = new PlateRepository();

    public void save(Plate plate) {
        if(plate!=null) {
            List<Plate> plates = plateRepos.getAll();
            if(!plates.isEmpty()) {
                Plate lastobj = plates.get(plates.size() - 1);
                plate.setId(lastobj.getId()+1);
                plateRepos.save(plate);
            }
        }
    }

    public void delete(Plate plate) {
        if(plate!=null) {
            plateRepos.delete(plate);
        }
    }

    public void update(Plate plate) {
        if (plate != null) {
//            Plate old_plate = plateRepos.getById(plate.getId()-1);
//            plateRepos.delete(old_plate);
//            List<Plate> plates = plateRepos.getAll();
//            if(!plates.isEmpty()) {
//                Plate lastobj = plates.get(plates.size() - 1);
//                plate.setId(lastobj.getId()+1);
//                plateRepos.save(plate);
//            }
            plateRepos.update(plate);
        }
    }

    public List<Plate> getAll() {
        return plateRepos.getAll();
    }

    public Plate getById(Integer id) {
        if(id!=null) {
            return plateRepos.getById(id);
        }
        return null;
    }

}