/*
 * Copyright (c) 2019. Zorn(zornx5@gmail.com). All rights reserved.
 */

package cn.zornx5.learn.core.java.v1ch02;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * ImageViewer 类.
 * GUI 图片查看.
 *
 * @author Zorn
 * @date 2019/3/27
 */
public class ImageViewer {
    public static void main(String[] args) {
        // lambda 表达式，Java 8 新特性
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * ImageViewerFrame 类.
 * 图片查看框架.
 *
 * @author Zorn
 * @version 1.0
 * @date 2019/3/27
 */
class ImageViewerFrame extends JFrame {
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        label = new JLabel();
        add(label);

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("open");
        menu.add(openItem);

        openItem.addActionListener(event -> {
            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });
        JMenuItem exitTtem = new JMenuItem("Exit");
        menu.add(exitTtem);
        exitTtem.addActionListener(event -> System.exit(0));
    }
}
