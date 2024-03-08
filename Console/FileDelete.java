import java.io.File;

//Class made to avoid the .txt file getting to large. If "append to .txt file" method is used.

public class FileDelete {

    public FileDelete(){

        File myObj = new File("Phototransistor.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
