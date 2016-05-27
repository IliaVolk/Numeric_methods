package Main.circles;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Methods {
    public static Cylinder cylinderWithMaxSurfaceArea(Collection<Cylinder> cylinders){
        return cylinders.stream().reduce((a,b)->
                 (a.surfaceArea() > b.surfaceArea())?a:b
        ).get();
    }
    public static void writeToFile(Collection<Cylinder> cylinders, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        for (Cylinder cylinder : cylinders) {
            out.writeObject(cylinder);
        }
    }
    public static Collection<Cylinder> readFromFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        Collection<Cylinder> result = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(fileInputStream)){
            while (true){
                result.add((Cylinder) in.readObject());
            }
        }
        catch (StreamCorruptedException | ClassNotFoundException e){
            //notify about error
            System.out.println("Error while reading file");
        }
        catch (EOFException e){
            //reading from file stops when file ends
        }
        catch (IOException e) {
            //other exceptions
            e.printStackTrace();
        }
        return result;
    }
}
