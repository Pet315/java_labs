import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PlateTest {

    Plate pl = Mockito.mock(Plate.class);
    View view = new View();
    Controller controller = new Controller(pl, view); //підміна залежності

    @Test
    public void heightDepSubst(){
        when(pl.height(6, 21)).thenReturn(5000.);
        double actual = controller.heightCtrl();
        double expected = 5000.;
        assertEquals(expected, actual);
        verify(pl).height(6, 21); //перевірка взаємодії із залежністю
    }

    @Test
    public void AssocDepSubst(){
        when(pl.associations("red")).thenReturn("aaa");
        String actual = controller.associationsCtrl();
        String expected = "aaa";
        assertEquals(expected, actual);
        verify(pl).associations("red"); //перевірка взаємодії із залежністю
    }

    @Test
    public void DEnoughDepSubst(){
        when(pl.diameterEnough(21)).thenReturn(false);
        boolean actual = controller.diameterEnoughCtrl();
        boolean expected = false;
        assertEquals(expected, actual);
        verify(pl).diameterEnough(21); //перевірка взаємодії із залежністю
    }

    @Test
    public void CEnoughDepSubst(){
        when(pl.capacityEnough(6)).thenReturn(false);
        boolean actual = controller.capacityEnoughCtrl();
        boolean expected = false;
        assertEquals(expected, actual);
        verify(pl).capacityEnough(6); //перевірка взаємодії із залежністю
    }

    @Test
    public void SDescDepSubst(){
        when(pl.short_desc(6)).thenReturn("shds");
        String actual = controller.shortdescCtrl();
        String expected = "shds";
        assertEquals(expected, actual);
        verify(pl).short_desc(6); //перевірка взаємодії із залежністю
    }

    @Test
    public void getDName() {
        when(pl.getDName()).thenReturn("name1111");
        String actual = controller.getDNameCtrl();
        String expected = "name1111";
        assertEquals(expected, actual);
        verify(pl).getDName();
    }

    @Test
    public void getColor() {
        when(pl.getColor()).thenReturn("brown");
        String actual = controller.getColorCtrl();
        String expected = "brown";
        assertEquals(expected, actual);
        verify(pl).getColor();
    }

    @Test
    public void getDiameter() {
        when(pl.getDiameter()).thenReturn(21);
        int actual = controller.getDiameterCtrl();
        int expected = 21;
        assertEquals(expected, actual);
        verify(pl).getDiameter();
    }

    @Test
    public void getCapacity() {
        when(pl.getCapacity()).thenReturn(6);
        int actual = controller.getCapacityCtrl();
        int expected = 6;
        assertEquals(expected, actual);
        verify(pl).getCapacity();
    }

}