import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Downloader extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JComboBox cbxDistro;
    private JButton btnDownload;

    // todo create an array of the associated download URLs for each of the listed distributions.
    private String[] isoURLs = {

    }

    public Downloader() {
        btnDownload.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
