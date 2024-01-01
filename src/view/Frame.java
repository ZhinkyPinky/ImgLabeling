package view;

import main.ImgLblr;
import model.ImgLblPair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame extends JFrame {
    private ImgLblr imgLblr;
    private MainPanel mainPanel;

    public Frame(ArrayList<ImgLblPair> imgLblPairs, ImgLblr imgLblr) {
        this.imgLblr = imgLblr;
        setupFrame(imgLblPairs, imgLblr);
    }

    private void setupFrame(ArrayList<ImgLblPair> imgLblPairs, ImgLblr imgLblr) {
        setTitle("Controller.ImgLblr");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new BorderLayout());

        mainPanel = new MainPanel(imgLblPairs, imgLblr);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        setResizable(true);
        pack();
        setVisible(true);

        mainPanel.initImage();
    }
}
