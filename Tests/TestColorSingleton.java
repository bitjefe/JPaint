import model.ColorSingleton;
import model.ShapeColor;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.EnumMap;

public class TestColorSingleton {

    @Test
    public void testEnumMap(){
        ColorSingleton single_instance = null;
        EnumMap<ShapeColor, Color> colorMap = new EnumMap<>(ShapeColor.class);
        ShapeColor shapeColor = ShapeColor.BLUE;
        Color testColor = Color.blue;

        ColorSingleton mapPrimary = new ColorSingleton(shapeColor, colorMap);
        Color mappedColor = colorMap.get(shapeColor);

        Assert.assertEquals(testColor, mappedColor);

    }




}
