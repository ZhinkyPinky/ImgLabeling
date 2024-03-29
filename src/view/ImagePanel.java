package view;

import model.ImgLblPair;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private JLabel imageLabel;

    public ImagePanel() {
        setBorder(new LineBorder(Color.BLACK, 1));
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        //getLayout().addLayoutComponent(BorderLayout.CENTER, imageLabel);
        add(imageLabel, BorderLayout.CENTER);
    }

    public void displayImage(File imgFile) {
        try {
            BufferedImage image = ImageIO.read(imgFile);
            Dimension newDimension = getScaledDimension(new Dimension(image.getWidth(), image.getHeight()), getSize());
            Image resizedImage = image.getScaledInstance(newDimension.width, newDimension.height, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(resizedImage);
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {
        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }
}
