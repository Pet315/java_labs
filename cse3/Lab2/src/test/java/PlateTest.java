import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class PlateTest {

    Plate pl = new Plate("plate11","white", 21, 6);

    @Test
    @DisplayName("diameter testing")
    void diameterEnough() {
        String expectedV = pl.diameterEnough(pl.getDiameter());
        String actualV = pl.diameterEnough(21);
        assertNotNull(expectedV);
        assertEquals(expectedV, actualV);
        assertNotEquals(expectedV, 117);
    }

    @Test
    @DisplayName("capacity testing")
    void capacityEnough() {
        boolean expectedV = pl.capacityEnough(pl.getCapacity());
        boolean actualV = pl.capacityEnough(6);
        assertEquals(expectedV, actualV);
        assertNotEquals(expectedV, 23);
    }

    @Test
    @DisplayName("height testing")
    void height() {
        double expectedV = pl.height(pl.getCapacity(), pl.getDiameter());
        double actualV = pl.height(6, 21);
        assertEquals(expectedV, actualV);
    }

    @Test
    @DisplayName("short_desc testing")
    void short_desc() {
        String expectedV = pl.short_desc(pl.getCapacity());
        String actualV = pl.short_desc(6);
        assertNotNull(expectedV);
        assertEquals(expectedV, actualV);
    }

    @Test
    @DisplayName("setDiameter testing")
    void setDiameter() {
        boolean expectedV = pl.getDiameter() > 0;
        boolean actualV = true;
        assertEquals(expectedV, actualV);
    }



}