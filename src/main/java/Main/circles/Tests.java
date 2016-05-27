package Main.circles;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Tests {
    private List<Cylinder> cylinders;
    private File file;
    @Before
    public void beforeTests(){
        file = new File("test");
        cylinders = new ArrayList<>(
                Arrays.asList(
                        new Cylinder(10, 20),
                        new Cylinder(1, 3),
                        new Cylinder(2, 4)
                )
        );
    }
    @Test
    public void testMax(){
        Cylinder max = Methods.cylinderWithMaxSurfaceArea(cylinders);
        Assert.assertEquals(cylinders.get(0), max);
    }

    @Test
    public void testWriteToAndReadFromFile() throws IOException{
        Methods.writeToFile(cylinders, file);
        Collection<Cylinder> fromFile = Methods.readFromFile(file);
        for (Cylinder cylinder : cylinders) {
            Assert.assertEquals(true, fromFile.contains(cylinder));
        }
        for (Cylinder cylinder : fromFile){
            Assert.assertEquals(true, cylinders.contains(cylinder));
        }
        //collections equals
    }
    @Test
    public void testFileCorrupted() throws IOException{
        Methods.writeToFile(cylinders, file);
        FileOutputStream corrupter = new FileOutputStream(file);
        corrupter.write("corruption".getBytes());
        Collection<Cylinder> fromFile = Methods.readFromFile(file);
        Assert.assertEquals(true, fromFile.isEmpty());
    }
}
