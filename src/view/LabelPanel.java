package view;

import model.ImgLblPair;
import model.QualityPair;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Hashtable;

public class LabelPanel extends JPanel {
    private ImgLblPair currentImgLblPair;

    private JLabel qualityOneValueLbl;
    private JLabel qualityTwoValueLbl;
    private JSlider sliderOne;

    private JLabel qualityThreeValueLbl;
    private JLabel qualityFourValueLbl;
    private JSlider sliderTwo;

    private JLabel qualityFiveValueLbl;
    private JLabel qualitySixValueLbl;
    private JSlider sliderThree;

    private JLabel qualitySevenValueLbl;
    private JLabel qualityEightValueLbl;
    private JSlider sliderFour;

    private JButton saveButton;
    private JButton skipButton;

    public LabelPanel(MainPanel mainPanel, ImgLblPair imgLblPair) {
        this.currentImgLblPair = imgLblPair;

        setLayout(new GridLayout(5, 3, 2, 2));
        setBorder(new LineBorder(Color.BLACK, 1));

        add(constructSliderPanel());

        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            mainPanel.saveImageLabelPair();
        });
        add(saveButton, BorderLayout.SOUTH);

        skipButton = new JButton("Skip");
        skipButton.addActionListener(e -> {
            mainPanel.skipImage();
        });
        add(skipButton, BorderLayout.SOUTH);
    }

    public void updateSliders(ImgLblPair imgLblPair) {
        currentImgLblPair = imgLblPair;

        sliderOne.setValue(currentImgLblPair.getQualityPairs()[0].getQualityTwoValue());
        qualityOneValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[0].setQualityOneValue(100 - sliderOne.getValue())));
        qualityTwoValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[0].setQualityTwoValue(sliderOne.getValue())));

        sliderTwo.setValue(currentImgLblPair.getQualityPairs()[1].getQualityTwoValue());
        qualityThreeValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[1].setQualityOneValue(100 - sliderTwo.getValue())));
        qualityFourValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[1].setQualityTwoValue(sliderTwo.getValue())));

        sliderThree.setValue(currentImgLblPair.getQualityPairs()[2].getQualityTwoValue());
        qualityFiveValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[2].setQualityOneValue(100 - sliderThree.getValue())));
        qualitySixValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[2].setQualityTwoValue(sliderThree.getValue())));

        sliderFour.setValue(currentImgLblPair.getQualityPairs()[3].getQualityTwoValue());
        qualitySevenValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[3].setQualityOneValue(100 - sliderFour.getValue())));
        qualityEightValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[3].setQualityTwoValue(sliderFour.getValue())));
    }

    private JPanel constructSliderPanel() {
        sliderOne = createSlider(currentImgLblPair.getQualityPairs()[0]);
        sliderOne.addChangeListener(e -> {
            qualityOneValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[0].setQualityOneValue(100 - sliderOne.getValue())));
            qualityTwoValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[0].setQualityTwoValue(sliderOne.getValue())));
        });
        qualityOneValueLbl = new JLabel(String.valueOf(currentImgLblPair.getQualityPairs()[0].setQualityOneValue(100 - sliderOne.getValue())));
        qualityOneValueLbl.setFont(new Font(qualityOneValueLbl.getFont().getName(), Font.PLAIN, 32));
        qualityOneValueLbl.setPreferredSize(new Dimension(75, 25));
        qualityTwoValueLbl = new JLabel(String.valueOf(currentImgLblPair.getQualityPairs()[0].getQualityTwoValue()));
        qualityTwoValueLbl.setFont(new Font(qualityTwoValueLbl.getFont().getName(), Font.PLAIN, 32));
        qualityTwoValueLbl.setPreferredSize(new Dimension(75, 25));

        JPanel sliderSubPanelOne = new JPanel();
        sliderSubPanelOne.setLayout(new BorderLayout());
        sliderSubPanelOne.setBorder(new LineBorder(Color.BLACK, 1));
        sliderSubPanelOne.add(qualityOneValueLbl, BorderLayout.WEST);
        sliderSubPanelOne.add(sliderOne, BorderLayout.CENTER);
        sliderSubPanelOne.add(qualityTwoValueLbl, BorderLayout.EAST);


        sliderTwo = createSlider(currentImgLblPair.getQualityPairs()[1]);
        sliderTwo.addChangeListener(e -> {
            qualityThreeValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[1].setQualityOneValue(100 - sliderTwo.getValue())));
            qualityFourValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[1].setQualityTwoValue(sliderTwo.getValue())));
        });
        qualityThreeValueLbl = new JLabel(String.valueOf(currentImgLblPair.getQualityPairs()[1].setQualityOneValue(100 - sliderTwo.getValue())));
        qualityThreeValueLbl.setFont(new Font(qualityThreeValueLbl.getFont().getName(), Font.PLAIN, 32));
        qualityThreeValueLbl.setPreferredSize(new Dimension(75, 25));
        qualityFourValueLbl = new JLabel(String.valueOf(currentImgLblPair.getQualityPairs()[1].getQualityTwoValue()));
        qualityFourValueLbl.setFont(new Font(qualityFourValueLbl.getFont().getName(), Font.PLAIN, 32));
        qualityFourValueLbl.setPreferredSize(new Dimension(75, 25));

        JPanel sliderSubPanelTwo = new JPanel();
        sliderSubPanelTwo.setLayout(new BorderLayout());
        sliderSubPanelTwo.setBorder(new LineBorder(Color.BLACK, 1));
        sliderSubPanelTwo.add(qualityThreeValueLbl, BorderLayout.WEST);
        sliderSubPanelTwo.add(sliderTwo, BorderLayout.CENTER);
        sliderSubPanelTwo.add(qualityFourValueLbl, BorderLayout.EAST);

        sliderThree = createSlider(currentImgLblPair.getQualityPairs()[2]);
        sliderThree.addChangeListener(e -> {
            qualityFiveValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[2].setQualityOneValue(100 - sliderThree.getValue())));
            qualitySixValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[2].setQualityTwoValue(sliderThree.getValue())));
        });
        qualityFiveValueLbl = new JLabel(String.valueOf(currentImgLblPair.getQualityPairs()[2].setQualityOneValue(100 - sliderThree.getValue())));
        qualityFiveValueLbl.setFont(new Font(qualityFiveValueLbl.getFont().getName(), Font.PLAIN, 32));
        qualityFiveValueLbl.setPreferredSize(new Dimension(75, 25));
        qualitySixValueLbl = new JLabel(String.valueOf(currentImgLblPair.getQualityPairs()[2].getQualityTwoValue()));
        qualitySixValueLbl.setFont(new Font(qualityTwoValueLbl.getFont().getName(), Font.PLAIN, 32));
        qualitySixValueLbl.setPreferredSize(new Dimension(75, 25));

        JPanel sliderSubPanelThree = new JPanel();
        sliderSubPanelThree.setLayout(new BorderLayout());
        sliderSubPanelThree.setBorder(new LineBorder(Color.BLACK, 1));
        sliderSubPanelThree.add(qualityFiveValueLbl, BorderLayout.WEST);
        sliderSubPanelThree.add(sliderThree, BorderLayout.CENTER);
        sliderSubPanelThree.add(qualitySixValueLbl, BorderLayout.EAST);

        sliderFour = createSlider(currentImgLblPair.getQualityPairs()[3]);
        sliderFour.addChangeListener(e -> {
            qualitySevenValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[3].setQualityOneValue(100 - sliderFour.getValue())));
            qualityEightValueLbl.setText(String.valueOf(currentImgLblPair.getQualityPairs()[3].setQualityTwoValue(sliderFour.getValue())));
        });
        qualitySevenValueLbl = new JLabel(String.valueOf(currentImgLblPair.getQualityPairs()[3].setQualityOneValue(100 - sliderFour.getValue())));
        qualitySevenValueLbl.setFont(new Font(qualitySevenValueLbl.getFont().getName(), Font.PLAIN, 32));
        qualitySevenValueLbl.setPreferredSize(new Dimension(75, 25));
        qualityEightValueLbl = new JLabel(String.valueOf(currentImgLblPair.getQualityPairs()[3].getQualityTwoValue()));
        qualityEightValueLbl.setFont(new Font(qualityEightValueLbl.getFont().getName(), Font.PLAIN, 32));
        qualityEightValueLbl.setPreferredSize(new Dimension(75, 25));

        JPanel sliderSubPanelFour = new JPanel();
        sliderSubPanelFour.setLayout(new BorderLayout());
        sliderSubPanelFour.setBorder(new LineBorder(Color.BLACK, 1));
        sliderSubPanelFour.add(qualitySevenValueLbl, BorderLayout.WEST);
        sliderSubPanelFour.add(sliderFour, BorderLayout.CENTER);
        sliderSubPanelFour.add(qualityEightValueLbl, BorderLayout.EAST);


        JPanel sliderMainPanel = new JPanel();
        sliderMainPanel.setLayout(new GridLayout(4, 1));
        sliderMainPanel.setBorder(new LineBorder(Color.BLACK, 1));
        sliderMainPanel.add(sliderSubPanelOne);
        sliderMainPanel.add(sliderSubPanelTwo);
        sliderMainPanel.add(sliderSubPanelThree);
        sliderMainPanel.add(sliderSubPanelFour);

        return sliderMainPanel;
    }

    private JSlider createSlider(QualityPair qualityPair) {
        JSlider slider = new JSlider(0, 100);
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(qualityPair.getQualityOneValue(), new JLabel(qualityPair.getQualityOne().name()));
        labelTable.put(qualityPair.getQualityTwoValue(), new JLabel(qualityPair.getQualityTwo().name()));
        slider.setLabelTable(labelTable);
        slider.setMajorTickSpacing(25);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setPreferredSize(new Dimension(300, 10));
        slider.setValue(qualityPair.getQualityTwoValue());

        return slider;
    }
}