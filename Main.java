import Controller.MainMenu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MainMenu main=new MainMenu();

        File file=new File("/Users/nagulan-pt6205/Documents/xyzAtm.txt");
        file.createNewFile();
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write("gvfcdfvfd");
        fileWriter.write("ujhybgtvd");
        fileWriter.flush();



        main.mainWorking();
    }
}
