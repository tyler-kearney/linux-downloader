import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Downloader extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JComboBox cbxDistro;
    private JButton btnDownload;

    // An array containing the download links for the isos, it matches the same order as the array stored in cbxDistro.
    private String[] isoURLs = {
            "https://ubuntu.com/download/desktop/thank-you?version=24.04&architecture=amd64&lts=true",
            "https://mirror.us.leaseweb.net/ubuntu-cdimage/xubuntu/releases/24.04/release/xubuntu-24.04-desktop-amd64.iso",
            "https://cdimage.ubuntu.com/kubuntu/releases/24.04/release/kubuntu-24.04-desktop-amd64.iso",
            "https://download.fedoraproject.org/pub/fedora/linux/releases/40/Workstation/x86_64/iso/Fedora-Workstation-Live-x86_64-40-1.14.iso",
            "https://download.fedoraproject.org/pub/fedora/linux/releases/40/Spins/x86_64/iso/Fedora-KDE-Live-x86_64-40-1.14.iso",
            "https://download.fedoraproject.org/pub/fedora/linux/releases/40/Spins/x86_64/iso/Fedora-Xfce-Live-x86_64-40-1.14.iso",
            "https://download.opensuse.org/tumbleweed/iso/openSUSE-Tumbleweed-NET-x86_64-Current.iso",
            "https://mirror.clarkson.edu/linuxmint-images/stable/22/linuxmint-22-cinnamon-64bit.iso",
            "https://mirror.clarkson.edu/linuxmint-images/stable/22/linuxmint-22-mate-64bit.iso",
            "https://mirror.clarkson.edu/linuxmint-images/stable/22/linuxmint-22-xfce-64bit.iso",
            "https://mirror.clarkson.edu/archlinux/iso/2024.08.01/archlinux-2024.08.01-x86_64.iso"
    };

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
