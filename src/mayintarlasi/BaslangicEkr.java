/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayintarlasi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
 

class BaslangicEkr implements ActionListener, MouseListener {
 
       private JFrame ekran = null;
       private JButton btnGulen = new JButton("");
       private JPanel pnlBilesik = new JPanel();
       private JPanel pnlUst = new JPanel();
       
          ImageIcon imgGulenYuz = null;
          ImageIcon imgKapak = null;
          ImageIcon imgMayin = null;
          ImageIcon lossImageIcon = null;
          ImageIcon imgAglayanYuz = null;
          ImageIcon imgBir = null;
          ImageIcon imgIki = null;
          ImageIcon imgUc = null;
          ImageIcon imgDort = null;
          ImageIcon imgBes = null;
          
       public BaslangicEkr() {
              ekran = new JFrame("Mayın Tarlası by Fatih ÇELEBİ\"");
              ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              ekran.setVisible(true);
              ekran.setResizable(false);
              ekran.setJMenuBar(MenuBarYapıcı());
              resimleriYukle();
              
              pnlBilesik.setLayout(new BorderLayout());
              btnGulen.setPreferredSize(new Dimension(25, 25));
              btnGulen.setIcon(imgGulenYuz);
              pnlUst.add(btnGulen);
              pnlBilesik.add(pnlUst, BorderLayout.NORTH);
              btnGulen.addActionListener(this);
              btnGulen.addMouseListener(this);
              butonlariDuzenle();
              ekran.add(pnlBilesik);
              ekran.pack();
       }
       
       public void resimleriYukle() {
           imgGulenYuz = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\smiley.png");
           imgKapak = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\t.png");
           imgMayin = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\pit.png");
           lossImageIcon = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\loss.png");
           imgAglayanYuz = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\cry.png");
           imgBir = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\1.png");
           imgIki = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\2.png");
           imgUc = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\3.png");
           imgDort = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\4.png");
           imgBes = getScaledImage("..\\NetBeansProjects\\mayintarlasi\\images\\5.png");
          
          
       }
 
       public JMenuBar MenuBarYapıcı() {
 
              JMenuBar mBar = new JMenuBar();
              JMenu oyun = new JMenu("Oyun");
 
              JMenu yardim = new JMenu("Yardım");
 
              final JMenuItem yeniOyun = new JMenuItem("Yeni");
              final JMenuItem beg = new JMenuItem("Acemi");
              final JMenuItem inter = new JMenuItem("Orta");
              final JMenuItem exp = new JMenuItem("Usta");
              final JMenuItem exit = new JMenuItem("Çık");
 
              final JMenuItem hakkinda = new JMenuItem("Yapana Kadar Canımız Çıktı...");
 
              oyun.add(yeniOyun);
              oyun.add(beg);
              oyun.add(inter);
              oyun.add(exp);
              oyun.add(exit);
 
              yardim.add(hakkinda);
 
              ActionListener MENULSTNR = new ActionListener() {
 
                     public void actionPerformed(ActionEvent ae) {
                           if (yeniOyun == ae.getSource()) {
                                  btnGenislik = 10;
                                  btnYukseklik = 10;
                                  mayinlar = 10;
                                  reset();
                           }
                           if (beg == ae.getSource()) {
                                  btnGenislik = 12;
                                  btnYukseklik = 12;
                                  mayinlar = 12;
                                  reset();
 
                           }
                           if (inter == ae.getSource()) {
                                  btnGenislik = 15;
                                  btnYukseklik = 15;
                                  mayinlar = 50;
                                  reset();
 
                           }
                           if (exp == ae.getSource()) {
                                  btnGenislik = 24;
                                  btnYukseklik = 30;
                                  mayinlar = 80;
                                  reset();
                           }
                           if (exit == ae.getSource()) {
                                  if (ekran != null) {
                                         ekran.dispose();
                                  }
                                  System.exit(0);
 
                           }
 
                           if (hakkinda == ae.getSource()) {
                                  System.out.println(" ÇELEBİ");
                           }
                     }
 
              };
 
              yeniOyun.addActionListener(MENULSTNR);
              beg.addActionListener(MENULSTNR);
              inter.addActionListener(MENULSTNR);
              exp.addActionListener(MENULSTNR);
              exit.addActionListener(MENULSTNR);
              hakkinda.addActionListener(MENULSTNR);
              mBar.add(oyun);
              mBar.add(yardim);
              return mBar;
       }
 
       private int btnGenislik = 10;
 
       private int btnYukseklik = 10;
 
       private int mayinlar = 8;
 
       int[][] mayinDizisi;
 
       JButton[][] buton;
       JPanel mayinAlani = null;
 
       public void butonlariDuzenle() {
              mayinDizisi = new int[btnGenislik][btnYukseklik];
              buton = new JButton[btnGenislik][btnYukseklik];
              boolean baslangic = true;
              if (mayinAlani != null) {
                     pnlBilesik.remove(mayinAlani);
                     mayinAlani = null;
                     baslangic = false;
 
              }
              mayinAlani = new JPanel();
              mayinAlani.setLayout(new GridLayout(btnGenislik, btnYukseklik));
 
              for (int i = 0; i < btnGenislik; i++) {
                     for (int j = 0; j < btnYukseklik; j++) {
                           mayinDizisi[i][j] = 0;
                           buton[i][j] = new JButton("");
                           buton[i][j].setBackground(Color.WHITE);
                           buton[i][j].setPreferredSize(new Dimension(16, 16));
                           buton[i][j].addActionListener(this);
                           buton[i][j].addMouseListener(this);
                           mayinAlani.add(buton[i][j]);
                     }
              }
 
              mayinAlani.setVisible(true);
              pnlBilesik.add(mayinAlani, BorderLayout.CENTER);
              if (baslangic) {
                     mayinSekli(buton);
              }
              ekran.pack();
       }
 
       public void reset() {
              btnGulen.setIcon(imgGulenYuz);
              // btnGenislik+=1;
              butonlariDuzenle();
              for (int i = 0; i < btnGenislik; i++) {
                     for (int j = 0; j < btnYukseklik; j++) {
                           mayinDizisi[i][j] = 0;
                           buton[i][j].addActionListener(this);
                           buton[i][j].addMouseListener(this);
                           buton[i][j].setText("");
                           buton[i][j].setBackground(Color.WHITE);
                           //buton[i][j].setIcon(imgKapak);
                     }
              }
              mayinSekli(buton);
              System.out.println("");
              System.out.println("");
       }
 
       public void mayinSekli(JButton buton[][]) {
              int mayin[] = rastgeleSayiAl(btnGenislik, btnYukseklik, mayinlar);
              int sayac = 1;
              for (int i = 0; i < btnGenislik; i++) {
                     for (int j = 0; j < btnYukseklik; j++)
 
                     {
 
                           for (int k = 0; k < mayin.length && mayin[k] != 0; k++) {
                                  if (sayac == mayin[k]) {
                                         mayinDizisi[i][j] = 9;
                                  }
                           }
                           sayac++;
                     }
              }
 
              int kutuSayisi = 0;
              for (int i = 0; i < btnGenislik; i++) {
                     for (int j = 0; j < btnYukseklik; j++) {
                           kutuSayisi = 0;
 
                           if (mayinDizisi[i][j] != 9) {
                                  if (i > 0 && j > 0) {
                                         if (mayinDizisi[i - 1][j - 1] == 9)
                                                kutuSayisi++;
                                  }
 
                                  if (i > 0) {
                                         if (mayinDizisi[i - 1][j] == 9)
                                                kutuSayisi++;
                                  }
 
                                  if (i > 0 && j < btnYukseklik - 1) {
                                         if (mayinDizisi[i - 1][j + 1] == 9)
                                                kutuSayisi++;
                                  }
 
                                  if (i < btnGenislik - 1 && j > 0) {
                                         if (mayinDizisi[i + 1][j - 1] == 9)
                                                kutuSayisi++;
                                  }
                                  if (i < btnGenislik - 1) {
                                         if (mayinDizisi[i + 1][j] == 9)
                                                kutuSayisi++;
                                  }
 
                                  if (i < btnGenislik - 1 && j < btnYukseklik - 1) {
                                         if (mayinDizisi[i + 1][j + 1] == 9)
                                                kutuSayisi++;
                                  }
 
                                  if (j > 0) {
                                         if (mayinDizisi[i][j - 1] == 9)
                                                kutuSayisi++;
                                  }
                                  if (j < btnYukseklik - 1) {
                                         if (mayinDizisi[i][j + 1] == 9)
                                                kutuSayisi++;
                                  }
                                  mayinDizisi[i][j] = kutuSayisi;
                           }
                     }
              }
 
              for (int i = 0; i < btnGenislik; i++) {
                     for (int j = 0; j < btnYukseklik; j++) {
                           System.out.print(" " + mayinDizisi[i][j]);
                     }
                     System.out.println("");
              }
 
       }
 
       public int[] rastgeleSayiAl(int btnGenislik, int btnYukseklik, int mayinlar) {
              Random rand = new Random();
              int rndMayinlar[] = new int[btnGenislik * btnYukseklik];
              boolean icinde = false;
              int sayac = 0;
              while (sayac < mayinlar) {
                     int rndSayi = (int) ((btnGenislik * btnYukseklik) * (rand.nextDouble())) + 1;
                     icinde = false;
                     for (int i = 0; i < sayac; i++) {
                           if (rndMayinlar[i] == rndSayi) {
                                  icinde = true;
                                  break;
                           }
                     }
                     if (!icinde) {
                           rndMayinlar[sayac++] = rndSayi;
                     }
              }
              return rndMayinlar;
       }
 
       public void actionPerformed(ActionEvent ae) {
 
              if (ae.getSource() == btnGulen) {
                     reset();
              } else {
                     for (int i = 0; i < btnGenislik; i++)
                           for (int j = 0; j < btnYukseklik; j++) {
                                  if (buton[i][j] == ae.getSource()) {
                                         if (mayinDizisi[i][j] == 9) {
                                                for (int k = 0; k < btnGenislik; k++) {
                                                       for (int l = 0; l < btnYukseklik; l++) {
 
                                                              if (mayinDizisi[k][l] == 9) {
                                                                     buton[k][l].setIcon(imgMayin);
                                                              }
 
                                                              buton[k][l].removeActionListener(this);
                                                              buton[k][l].removeMouseListener(this);
 
                                                       }
                                                }
 
                                         }
                                         if (mayinDizisi[i][j] == 1) {
                                                buton[i][j].setIcon(imgBir);
                                         }
                                         if (mayinDizisi[i][j] == 2) {
                                                buton[i][j].setIcon(imgIki);
                                         }
                                         if (mayinDizisi[i][j] == 3) {
                                                buton[i][j].setIcon(imgUc);
                                         }
                                         if (mayinDizisi[i][j] == 4) {
                                                buton[i][j].setIcon(imgDort);
                                         }
                                         if (mayinDizisi[i][j] == 5) {
                                                buton[i][j].setIcon(imgBes);
                                         }
                                         if (mayinDizisi[i][j] == 0) {
                                                bosluklariBul(i, j);
                                         }
                                  }
                           }
              }
       }
 
       public void bosluklariBul(int kutuX, int kutuY) {
              int diziX[] = new int[(btnGenislik) * (btnYukseklik)];
              int diziY[] = new int[(btnGenislik) * (btnYukseklik)];
              int bosSayacı = 0;
              for (int i = 0; i < ((btnGenislik) * (btnYukseklik)); i++) {
                     diziX[i] = -1;
                     diziY[i] = -1;
              }
              diziX[bosSayacı] = kutuX;
              diziY[bosSayacı] = kutuY;
              bosSayacı++;
 
              for (int i = 0; i < bosSayacı; i++) {
                     if (diziX[i] > 0) {
                           int xxX = diziX[i] - 1;
                           int yyY = diziY[i];
                           if (mayinDizisi[xxX][yyY] == 0) {
                                  if (!bul(diziX, diziY, bosSayacı, xxX, yyY)) {
                                         diziX[bosSayacı] = xxX;
                                         diziY[bosSayacı] = yyY;
                                         bosSayacı++;
                                  }
                           }
                     }
 
                     if (diziX[i] < (btnGenislik - 1)) {
                           int xxX = diziX[i] + 1;
                           int yyY = diziY[i];
                           if (mayinDizisi[xxX][yyY] == 0) {
                                  if (!bul(diziX, diziY, bosSayacı, xxX, yyY)) {
                                         diziX[bosSayacı] = xxX;
                                         diziY[bosSayacı] = yyY;
                                         bosSayacı++;
                                  }
                           }
                     }
 
                     if (diziY[i] > 0) {
                           int xxX = diziX[i];
                           int yyY = diziY[i] - 1;
                           if (mayinDizisi[xxX][yyY] == 0) {
                                  if (!bul(diziX, diziY, bosSayacı, xxX, yyY)) {
                                         diziX[bosSayacı] = xxX;
                                         diziY[bosSayacı] = yyY;
                                         bosSayacı++;
                                  }
                           }
                     }
 
                     if (diziY[i] < (btnYukseklik - 1)) {
                           int xxX = diziX[i];
                           int yyY = diziY[i] + 1;
                           if (mayinDizisi[xxX][yyY] == 0) {
                                  if (!bul(diziX, diziY, bosSayacı, xxX, yyY)) {
                                         diziX[bosSayacı] = xxX;
                                         diziY[bosSayacı] = yyY;
                                         bosSayacı++;
                                  }
                           }
                     }
              }
 
              for (int k = 0; k < bosSayacı; k++) {
                     buton[diziX[k]][diziY[k]].setBackground(new Color(200, 200, 250));
              }
 
       }
 
       public boolean bul(int[] diziX, int[] diziY, int bosSayacı, int xxX, int yyY) {
              int j = 0;
              for (j = 0; j < bosSayacı; j++) {
                     if ((diziX[j] == (xxX)) && (diziY[j] == (yyY))) {
                           return true;
                     }
              }
              return false;
       }
 
       public void mouseClicked(MouseEvent arg0) {
              // TODO Auto-generated method stub
       }
 
       public void mousePressed(MouseEvent me) {
              for (int i = 0; i < btnGenislik; i++)
                     for (int j = 0; j < btnYukseklik; j++) {
                           if (buton[i][j] == me.getSource()) {
                                  btnGulen.setIcon(imgAglayanYuz);
                           }
                     }
 
              if (me.getSource() == btnGulen) {
                     btnGulen.setIcon(imgAglayanYuz);
              }
       }
 
       public void mouseReleased(MouseEvent me) {
              // TODO Auto-generated method stub
              if (me.getSource() == btnGulen) {
                     btnGulen.setIcon(imgGulenYuz);
              }
              for (int i = 0; i < btnGenislik; i++)
                     for (int j = 0; j < btnYukseklik; j++) {
                           if (buton[i][j] == me.getSource()) {
                                  if (mayinDizisi[i][j] == 9) {
                                         btnGulen.setIcon(lossImageIcon);
                                  } else {
                                         btnGulen.setIcon(imgGulenYuz);
                                  }
                           }
 
                     }
                    
       }
       
       public ImageIcon getScaledImage(String imageString) {
          ImageIcon imageIcon = new ImageIcon(imageString);
          Image image = imageIcon.getImage(); 
          Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
          imageIcon = new ImageIcon(newimg);
          return imageIcon;
       }
       
 
       public void mouseEntered(MouseEvent arg0) {
              // TODO Auto-generated method stub
 
       }
 
       public void mouseExited(MouseEvent arg0) {
              // TODO Auto-generated method stub
 
       }
}
