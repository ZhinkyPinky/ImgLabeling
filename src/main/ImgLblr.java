package main;

import model.ImgLblPair;
import view.Frame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ImgLblr {
    private final String imgFolderLocation;
    private final BufferedWriter bufferedWriter;

    public ImgLblr() throws IOException {
        imgFolderLocation = "C:\\Users\\Jonathan\\PycharmProjects\\DatasetCreation\\dataset\\BusyStreet";

        File[] images = new File(imgFolderLocation).listFiles((File file) -> (file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")|| file.getName().endsWith(".JPG")));

        bufferedWriter = new BufferedWriter(new FileWriter(imgFolderLocation + "labels", true));

        ArrayList<ImgLblPair> imgLblPairs = new ArrayList<>();
        for (File image : images) {
            imgLblPairs.add(new ImgLblPair(image));
        }

        for (ImgLblPair imgLblPair : imgLblPairs) {
            System.out.println(imgLblPair.toString());
        }

        new Frame(imgLblPairs, this);
    }

    public void saveImageLabelPair(ImgLblPair imgLblPair) {
        System.out.println(imgLblPair.toString());
        try {
            File dir = new File(imgFolderLocation + "/labeled");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            bufferedWriter.write(imgLblPair + "\n");
            bufferedWriter.flush();

            Files.move(Paths.get(imgLblPair.getImgFile().toURI()), Path.of(imgFolderLocation + "/labeled/" + imgLblPair.getDirectory() + imgLblPair.getImgFile().getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void skipImage(ImgLblPair imgLblPair) {
        try {
            File dir = new File(imgFolderLocation + "/skipped");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            Files.move(Paths.get(imgLblPair.getImgFile().toURI()), Path.of(imgFolderLocation + "/skipped/" + imgLblPair.getImgFile().getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
