package view;

import main.ImgLblr;
import model.ImgLblPair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private ImgLblr imgLblr;

    private ArrayList<ImgLblPair> imgLblPairs;

    private ImagePanel imagePanel;
    private LabelPanel labelPanel;

    private int currentImage = 0;

    public MainPanel(ArrayList<ImgLblPair> imgLblPairs, ImgLblr imgLblr) {
        this.imgLblr = imgLblr;
        this.imgLblPairs = imgLblPairs;

        imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.WEST);

        labelPanel = new LabelPanel(this, imgLblPairs.get(currentImage));
        add(labelPanel, BorderLayout.EAST);

        SpringLayout springLayout = new SpringLayout();
        springLayout.putConstraint(SpringLayout.WEST, imagePanel, 0, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, imagePanel, 0, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.SOUTH, imagePanel, 0, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, imagePanel, 0, SpringLayout.WEST, labelPanel);

        springLayout.putConstraint(SpringLayout.NORTH, labelPanel, 0, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.EAST, labelPanel, 0, SpringLayout.EAST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, labelPanel, 0, SpringLayout.SOUTH, this);

        setLayout(springLayout);
    }

    public void initImage() {
        imagePanel.displayImage(imgLblPairs.get(currentImage).getImgFile());
        labelPanel.updateSliders(imgLblPairs.get(currentImage));
    }

    public void nextImage() {
        imagePanel.displayImage(imgLblPairs.get(++currentImage).getImgFile());
        labelPanel.updateSliders(imgLblPairs.get(currentImage));
    }

    public void saveImageLabelPair() {
        imgLblr.saveImageLabelPair(imgLblPairs.get(currentImage));
        nextImage();
    }

    public void skipImage() {
        imgLblr.skipImage(imgLblPairs.get(currentImage));
        nextImage();
    }
}
