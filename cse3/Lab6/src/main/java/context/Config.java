package context;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Model.ClassicPlate getCPlate() {
        return new Model.ClassicPlate();
    }
    @Bean
    public Controller.getDiameterCmd getDC(Model.Plate obj) {
        return new Controller.getDiameterCmd(obj);
    }
    @Bean
    public Controller.Invoker getInv(Controller.Command obj) {
        return new Controller.Invoker(obj);
    }
}
