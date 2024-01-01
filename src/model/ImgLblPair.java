package model;

import java.io.File;

public class ImgLblPair {
    private String directory;
    private File imgFile;
    private QualityPair[] qualityPairs = {
            new QualityPair(Qualities.Natural, Qualities.Cultural),
            new QualityPair(Qualities.Cohesive, Qualities.Diverse),
            new QualityPair(Qualities.Sheltered, Qualities.Open),
            new QualityPair(Qualities.Serene, Qualities.Social)
    };

    public ImgLblPair(File imgFile) {
        this.directory = imgFile.getParentFile().getName();
        this.imgFile = imgFile;

    }

    public QualityPair[] getQualityPairs() {
        return qualityPairs;
    }

    public File getImgFile() {
        return imgFile;
    }

    public String getDirectory() {
        return directory;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(directory);
        s.append(imgFile.getName());
        s.append('\t');

        for (int i = 0; i < qualityPairs.length; i++) {
            s.append(qualityPairs[i].getQualityOneValue());
            s.append(',');
            s.append(qualityPairs[i].getQualityTwoValue());
            if (i < (qualityPairs.length - 1)) {
                s.append(',');
            }
        }

        return s.toString();
    }
}
