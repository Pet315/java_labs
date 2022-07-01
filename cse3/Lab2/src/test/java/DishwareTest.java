import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishwareTest {

    Dishware dsh = new Dishware("plate12", "grey");

    @Test
    @DisplayName("associations testing")
    void associations() {
        String expectedV = dsh.associations(dsh.getColor());
        String actualV = dsh.associations("grey");
        assertNotNull(expectedV);
        assertEquals(expectedV, actualV);
        assertNotEquals(expectedV, dsh.associations("red"));
    }

    @Test
    @DisplayName("setColor testing")
    void setColor() {
        String expectedV = dsh.getColor();
        String actualV = "grey";
        assertNotNull(expectedV);
        assertEquals(expectedV, actualV);
        assertNotEquals(expectedV, "red");
    }

    @Test
    @DisplayName("setDName testing")
    void setDName() {
        String expectedV = dsh.getDName();
        String actualV = "plate12";
        assertNotNull(expectedV);
        assertEquals(expectedV, actualV);
        assertNotEquals(expectedV, "plate111");
    }
}