package Tools.ConfigsStuff;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;

public class MyFirstFileVisitor extends SimpleFileVisitor<Path> {
    private BufferedImage img;
    private final Path Output = Paths.get("C:\\Users\\AsisT\\Desktop\\crawler\\core\\assets\\Animations");
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String fileName;

        fileName = file.getFileName().toString();
        String[]  kek = fileName.split("_");


            /*for (int i = 0 ; i < kek.length; i++)
                System.out.println(kek[i] + "  " + i);
            System.out.println("////////////////");/**/

        String nameOfNewDirectory = "123", nameOfBaseDirectory ;

        if (kek.length > 1 && !kek[1].contains("anim")  && !kek[1].contains("idle") && !kek[1].contains("run") )
            nameOfBaseDirectory = kek[0] + "_" + kek[1];
        else
            nameOfBaseDirectory = kek[0] ;



        if (file.toString().contains("anim")){

            for (int i = 1; i < kek.length; i++){
                if (kek[i].contains("anim")){

                    nameOfNewDirectory = kek[i - 1];
                    break;
                }
            }

            nameOfBaseDirectory = "anim_"+ nameOfBaseDirectory;
            if(!new File(Output.toString() + "\\" + nameOfBaseDirectory).exists() ){
                 Files.createDirectory(Paths.get(Output.toString() + "\\" + nameOfBaseDirectory));
            }
            if(!new File(Output.toString() + "\\" + nameOfBaseDirectory+ "\\" + nameOfNewDirectory).exists() ){

                Files.createDirectory(Paths.get(Output.toString() + "\\" + nameOfBaseDirectory+ "\\" + nameOfNewDirectory));
            }

            if (!Paths.get(Output.toString() + "\\" + nameOfBaseDirectory+ "\\" + nameOfNewDirectory + "\\" + fileName).toFile().exists())
                Files.copy(file, Paths.get(Output.toString() + "\\" + nameOfBaseDirectory+ "\\" + nameOfNewDirectory + "\\" + fileName) );



        }else{
            nameOfNewDirectory = nameOfBaseDirectory.split("_")[0];
            nameOfNewDirectory = "tiles_" + nameOfNewDirectory;
            if (nameOfNewDirectory.contains("."))
                nameOfNewDirectory = nameOfNewDirectory.substring(0, nameOfNewDirectory.indexOf("."));
            if(!new File(Output.toString() + "\\" + nameOfNewDirectory).exists() ){
                Files.createDirectory(Paths.get(Output.toString() + "\\" + nameOfNewDirectory));
            }
            if (!Paths.get(Output.toString() + "\\" + nameOfNewDirectory + "\\" + fileName).toFile().exists())
                Files.copy(file, Paths.get(Output.toString() + "\\" + nameOfNewDirectory + "\\" + fileName) );
        }




        return FileVisitResult.CONTINUE;
    }
}