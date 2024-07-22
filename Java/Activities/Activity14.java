package Activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        File file = new File("IdeaProjects\\FST_Training\\src\\main\\newFile.txt");
        boolean fileStatus = file.createNewFile();
        if(fileStatus){
            System.out.println("File created succesfully");
        }else{
            System.out.println("File Creation failed");
        }
        File fileUtil = FileUtils.getFile("IdeaProjects\\FST_Training\\src\\main\\newFile.txt");

        File destDirector = new File("resources");
        FileUtils.copyFileToDirectory(file,destDirector);

        File newFile = FileUtils.getFile(destDirector, "newFile.txt");

        String newFileData = FileUtils.readFileToString(newFile, "UTF8");

        System.out.println("Data in new file:" + newFileData);
    }
}
