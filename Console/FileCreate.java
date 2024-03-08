import java.io.File;
import java.io.IOException;

public class FileCreate {

    FileCreate(){

        new FileDelete();

        try{
            File myFile = new File("Phototransistor.txt");
            if (myFile.createNewFile()){
                System.out.println("New file created: " + myFile.getName());
            }else {System.out.println("File already exists");}
        }catch (IOException e){System.out.println("Error");
            e.printStackTrace();}


    }
}
