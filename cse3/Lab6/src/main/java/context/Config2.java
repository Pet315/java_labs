package context;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {
    @Bean
    public Model.DeepPlate getDPlate() {
        return new Model.DeepPlate();
    }
}
