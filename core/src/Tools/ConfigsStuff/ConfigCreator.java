package Tools.ConfigsStuff;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ConfigCreator {
    private Path InputPath, OutputPath;
    private File file;
    private BufferedReader bf = null;
    private PrintWriter pw = null;

    public ConfigCreator(Path InputPath, Path OutputPath) {
        this.InputPath = InputPath;
        this.OutputPath = OutputPath;

        try{

            if (!OutputPath.toFile().exists())
                Files.createDirectory(OutputPath);
            Files.walkFileTree(InputPath, new MyFirstFileVisitor());

        }catch (IOException e){
            System.out.println("IOException " + e);
        }

    }



}
