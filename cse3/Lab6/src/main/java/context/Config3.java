package context;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class Config3 {

    @Bean
    public Model.BullionPlate getBPlate(@Qualifier("getBPlate") Model.IPlate obj) {
        return new Model.BullionPlate(obj);
    }
    @Bean
    public Model.SaladPlate getSPlate(@Qualifier("getSPlate")Model.IPlate obj) {
        return new Model.SaladPlate(obj);
    }
}
