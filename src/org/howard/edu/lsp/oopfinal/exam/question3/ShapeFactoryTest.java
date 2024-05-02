package org.howard.edu.lsp.oopfinal.exam.question3;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ShapeFactoryTest {
    @Test
    public void testCircleCreation() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("CIRCLE");
        assertTrue(shape instanceof Circle);
        assertEquals("I’m a Circle!!!", shape.draw()); // Assuming draw() returns a String for test purposes.
    }

    @Test
    public void testRectangleCreation() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("RECTANGLE");
        assertTrue(shape instanceof Rectangle);
        assertEquals("I’m a Rectangle!!!", shape.draw()); // Assuming draw() returns a String for test purposes.
    }
}
