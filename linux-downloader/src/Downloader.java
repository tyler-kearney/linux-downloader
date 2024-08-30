import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Objects;

public class Downloader extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JComboBox cbxDistro;
    private JButton btnDownload;
    private JProgressBar dlProgress;

    // An array containing the download links for the isos, it matches the same order as the array stored in cbxDistro.
    private final String[] isoURLs = {
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

    private void download(String url, JProgressBar progressBar) {
        try {
            URL isoURL = new URL(url);
            URLConnection conn = isoURL.openConnection();
            conn.connect();

            int contentLength = conn.getContentLength();
            progressBar.setMaximum(contentLength);

            InputStream input = conn.getInputStream();
            FileOutputStream output = new FileOutputStream(new File(".../linux_iso"));

            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytesRead = 0;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;

                progressBar.setValue((int) totalBytesRead);
            }

            input.close();
            output.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Download Failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isoDownload(String distroName, JProgressBar progressBar) {
        return switch (distroName) {
            case "Ubuntu" -> {
                download(isoURLs[0], progressBar);
                yield true;
            }
            case "Xubuntu" -> {
                download(isoURLs[1], progressBar);
                yield true;
            }
            case "Kubuntu" -> {
                download(isoURLs[2], progressBar);
                yield true;
            }
            case "Fedora Gnome" -> {
                download(isoURLs[3], progressBar);
                yield true;
            }
            case "Fedora KDE" -> {
                download(isoURLs[4], progressBar);
                yield true;
            }
            case "Fedora XFCE" -> {
                download(isoURLs[5], progressBar);
                yield true;
            }
            case "Opensuse" -> {
                download(isoURLs[6], progressBar);
                yield true;
            }
            case "Linux Mint" -> {
                download(isoURLs[7], progressBar);
                yield true;
            }
            case "Linux Mint Mate" -> {
                download(isoURLs[8], progressBar);
                yield true;
            }
            case "Linux Mint XFCE" -> {
                download(isoURLs[9], progressBar);
                yield true;
            }
            case "Arch Linux" -> {
                download(isoURLs[10], progressBar);
                yield true;
            }
            default -> {
                JOptionPane.showMessageDialog(this, "Invalid distro name: " + distroName, "Error", JOptionPane.ERROR_MESSAGE);
                yield false;
            }
        };
    }

    public Downloader() {
        getContentPane().add(mainPanel);
        btnDownload.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String isoURL = Objects.requireNonNull(cbxDistro.getSelectedItem()).toString();
                boolean down = isoDownload(isoURL, dlProgress);
                if (!down) {
                    JOptionPane.showMessageDialog(null, "Download Failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
