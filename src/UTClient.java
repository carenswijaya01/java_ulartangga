
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class UTClient extends JFrame {

    JButton jb = new JButton();
    JTextPane[][] jt = new JTextPane[10][10];
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    String[] dadun = {"1", "2", "3", "4", "5", "6"};//random+1
    JLabel dadup = new JLabel();
    JLabel txt = new JLabel();
    JLabel dotA, dotB;
    int x = 0, y = 0;
    int random = 0;
    int A = 0, B = 9;
    String dot = "";
    int get,send;

    Runnable run = new move();

    public class move implements Runnable {

        @Override
        public void run() {
            if (dot.equals("A")) {
                if (y % 2 == 0) {
                    x = x + random + 1;
                    if (x > 9) {
                        for (int i = x - random; i <= 9; i++) {
                            jt[i][y].insertComponent(dotA);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        x = 10 - (x - 9);
                        y++;
                        for (int i = 9; i >= x; i--) {
                            jt[i][y].insertComponent(dotA);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        B = x;
                    } else {
                        for (int i = A; i <= x; i++) {
                            jt[i][y].insertComponent(dotA);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        A = x;
                    }
                } else if (y == 9) {
                    x = x - random - 1;
                    if (x < 0) {
                        for (int i = x + random + 1; i >= 0; i--) {
                            jt[i][y].insertComponent(dotA);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        jb.setEnabled(false);
                    } else {
                        for (int i = B; i >= x; i--) {
                            jt[i][y].insertComponent(dotA);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                            if (x == 0) {
                                jb.setEnabled(false);
                            }
                        }
                        B = x;
                    }
                } else {
                    x = x - random - 1;
                    if (x < 0) {
                        for (int i = x + random + 1; i >= 0; i--) {
                            jt[i][y].insertComponent(dotA);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        x = 10 - (10 + x) - 1;
                        y++;
                        for (int i = 0; i <= x; i++) {
                            jt[i][y].insertComponent(dotA);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        A = x;
                    } else {
                        for (int i = B; i >= x; i--) {
                            jt[i][y].insertComponent(dotA);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        B = x;
                    }
                }
            } else {
                if (y % 2 == 0) {
                    x = x + random + 1;
                    if (x > 9) {
                        for (int i = x - random; i <= 9; i++) {
                            jt[i][y].insertComponent(dotB);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        x = 10 - (x - 9);
                        y++;
                        for (int i = 9; i >= x; i--) {
                            jt[i][y].insertComponent(dotB);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        B = x;
                    } else {
                        for (int i = A; i <= x; i++) {
                            jt[i][y].insertComponent(dotB);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        A = x;
                    }
                } else if (y == 9) {
                    x = x - random - 1;
                    if (x < 0) {
                        for (int i = x + random + 1; i >= 0; i--) {
                            jt[i][y].insertComponent(dotB);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        jb.setEnabled(false);
                    } else {
                        for (int i = B; i >= x; i--) {
                            jt[i][y].insertComponent(dotB);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                            if (x == 0) {
                                jb.setEnabled(false);
                            }
                        }
                        B = x;
                    }
                } else {
                    x = x - random - 1;
                    if (x < 0) {
                        for (int i = x + random + 1; i >= 0; i--) {
                            jt[i][y].insertComponent(dotB);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        x = 10 - (10 + x) - 1;
                        y++;
                        for (int i = 0; i <= x; i++) {
                            jt[i][y].insertComponent(dotB);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        A = x;
                    } else {
                        for (int i = B; i >= x; i--) {
                            jt[i][y].insertComponent(dotB);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                System.out.println("gagal");
                            }
                        }
                        B = x;
                    }
                }
            }
        }
    }

    UTClient() {

        this.setTitle("Ini Client");
        this.setDefaultCloseOperation(2);
        this.setSize(1000, 750);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                jt[i][j] = new JTextPane();
                this.add(jt[i][j]);
                jt[i][j].setBounds(10 + (i * 70), 10 + (j * 70), 70, 70);
                if (j % 2 == 1) {
                    jt[i][j].setText("        " + (10 * (j + 1) - i * 1));
                } else {
                    jt[i][j].setText("        " + ((i + 1) + (10 * j)));
                }
                jt[i][j].setEditable(false);
                jt[i][j].setBorder(border);
            }
        }

        this.add(dadup);
        dadup.setBounds(795, 150, 102, 100);
        dadup.setText(null);
        dadup.setBorder(border);

        dotA = new JLabel(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("green.png")).
                getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

        dotB = new JLabel(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("red.png")).
                getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

        jt[0][0].insertComponent(dotA);
        jt[0][0].insertComponent(dotB);

        this.add(jb);
        jb.setText("ACAK DADU");
        jb.setBounds(783, 275, 125, 50);

        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Random r = new Random();
                random = r.nextInt(dadun.length);
                dadup.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(dadun[random] + ".png")).
                        getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                new Thread(run).start();
            }
        });
        dot = "B";
        this.add(txt);
        txt.setText("Giliran Hijau");
        txt.setBounds(810, 325, 125, 50);

        try {
            Socket sock = new Socket("127.0.0.1", 3000);

            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

            OutputStream ostream = sock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostream, true);

            InputStream istream = sock.getInputStream();
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

            System.out.println("Start the chitchat, type and press Enter key");

            int receiveMessage, sendMessage;
            while (sock.isConnected()) {
                sendMessage = random;
                pwrite.println(sendMessage);
                pwrite.flush();
                if ((receiveMessage = receiveRead.read()) != 0) {
//                    random = receiveMessage;
//                    dot = "A";
//                    new Thread(run).start();
                    System.out.println(receiveMessage);
//                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(UTClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new UTClient();
    }
}
