/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Rpg {

    JFrame window;
    JPanel titlu, choicepanel, playerpanel;
    JPanel pozapanel, startpanel, mainpanel, contpanel;
    JLabel pozalabel, hplabel, hpnrlabel, weaponlabel, weaponnrlabel;
    ImageIcon pozaimage, pozaimage2;
    Container con;
    JButton startbtn, c1, c2, c3;
    JTextArea area;
    Font text = new Font("Times New Roman", Font.PLAIN, 30);
    Font text2 = new Font("Times New Roman", Font.PLAIN, 20);
    titluHandler th;
    choiceHandler c;
    int hp, hpo = 40;
    String weapon, context;

    public static void main(String[] args) {
       
        Rpg rpg = new Rpg();

    }
    

    public Rpg() {
        this.th = new titluHandler();
        this.c = new choiceHandler();
        
        
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        //icon
        ImageIcon imga = new ImageIcon(".//src//res//B.png");
        window.setIconImage(imga.getImage());
        con = window.getContentPane();
        
        //poza
        pozapanel = new JPanel();
        pozapanel.setBounds(225, 0, 350, 350);
        pozapanel.setBackground(Color.black);
        con.add(pozapanel);

        pozalabel = new JLabel();
        pozaimage = new ImageIcon(".//src//res//B.png");
        pozalabel.setIcon(pozaimage);
        pozapanel.add(pozalabel);

        startpanel = new JPanel();
        startpanel.setBounds(300, 350, 200, 100);
        startpanel.setBackground(Color.black);

        startbtn = new JButton("START");
        startbtn.setBackground(Color.black);
        startbtn.setForeground(Color.white);
        startbtn.setFont(text);
        startbtn.addActionListener(th);
        startbtn.setFocusPainted(false);
        startpanel.add(startbtn);
        con.add(startpanel);
        window.setVisible(true);

    }

    public void scena1() {
        context = "scena1";

        con.remove(pozalabel);
        con.remove(pozapanel);
        con.remove(startbtn);
        con.remove(startpanel);

        mainpanel = new JPanel();
        mainpanel.setBounds(100, 100, 600, 250);
        mainpanel.setBackground(Color.black);
        con.add(mainpanel);

        area = new JTextArea("Te treze??ti legat de un scaun, e??ti ??ntr-o camer?? \n??ntunecat??, o celul?? mai exact. \n\nCe faci?");
        area.setBounds(100, 100, 600, 250);
        area.setBackground(Color.black);
        area.setForeground(Color.white);
        area.setFont(text);
        area.setLineWrap(true);

        mainpanel.add(area);
        area.setVisible(true);

        choicepanel = new JPanel();
        choicepanel.setBounds(250, 350, 300, 150);
        choicepanel.setBackground(Color.black);
        choicepanel.setLayout(new GridLayout(4, 1));
        con.add(choicepanel);

        c1 = new JButton("");
        c1.setBackground(Color.black);
        c1.setForeground(Color.white);
        c1.setFont(text);
        c1.setFocusPainted(false);
        c1.setActionCommand("c1");
        c1.addActionListener(c);
        choicepanel.add(c1);

        c2 = new JButton("");
        c2.setBackground(Color.black);
        c2.setForeground(Color.white);
        c2.setFont(text);
        c2.setFocusPainted(false);
        c2.setActionCommand("c2");
        c2.addActionListener(c);
        choicepanel.add(c2);

        c3 = new JButton("");
        c3.setBackground(Color.black);
        c3.setForeground(Color.white);
        c3.setFont(text);
        c3.setFocusPainted(false);
        c3.addActionListener(c);
        c3.setActionCommand("c3");
        choicepanel.add(c3);

        playerpanel = new JPanel();
        playerpanel.setBounds(100, 15, 600, 50);
        playerpanel.setBackground(Color.black);
        playerpanel.setLayout(new GridLayout(1, 5));
        con.add(playerpanel);

        hplabel = new JLabel("HP:");
        hplabel.setFont(text);
        hplabel.setForeground(Color.red);
        playerpanel.add(hplabel);

        hpnrlabel = new JLabel();
        hpnrlabel.setFont(text);
        hpnrlabel.setForeground(Color.red);
        playerpanel.add(hpnrlabel);

        weaponlabel = new JLabel("Arm??:");
        weaponlabel.setFont(text);
        weaponlabel.setForeground(Color.yellow);
        playerpanel.add(weaponlabel);

        weaponnrlabel = new JLabel();
        weaponnrlabel.setFont(text);
        weaponnrlabel.setForeground(Color.yellow);
        playerpanel.add(weaponnrlabel);

        player();

        area.setText("Te treze??ti legat de un scaun, e??ti ??ntr-o camer?? \n??ntunecat??, o celul?? mai exact. \n\nCe faci?");
        c1.setText("Dormi");
        c2.setText("??ncerci s?? te dezlegi");
        c3.setText("Strigi, atragi aten??ia");

    }

    public void player() {
        hp = 100;
        weapon = "-";
        weaponnrlabel.setText(weapon);
        hpnrlabel.setText("100" );

    }

    public void dormi() {
        context = "dormi";
        area.setText("Ce dormi, serios? De ce mai... se aude un sunet de alarm??. G??rzile pleac?? din ??nc??perea al??turat?? \n\nCe faci?");
        c1.setText("??ncerci s?? spargi u??a");
        c2.setVisible(false);
        c3.setVisible(false);
        c2.setText("");
        c3.setText("");
    }

    public void incerci() {
        context = "incerci";
        area.setText("Nu reu??e??ti s?? te dezlegi lan??uri sunt prea groase ??i au un lac??t \n\nCe faci?");
        c1.setText("Dormi");
        c2.setText("Strigi, atragi aten??ia");
        c3.setVisible(false);
        c3.setText("");
    }

    public void strigi() {
        c3.setVisible(true);
        context = "strigi";
        area.setText("Garzile au sosit la tine ??n celul?? \n\nCe faci?");
        c1.setText("R??zi de gardieni");
        c2.setText("Te lup??i cu g??rzile");
        c3.setText("??ncerci s?? iei cheia");
    }

    public void spargi() {
        context = "spargi";

        area.setText("Nu este nici o garda ??n camer??, gase??ti o cheie ??i i??i sco??i lan??urile. ??n fa??a ta este o u????");
        c1.setText("Deschide u??a");

    }

    public void razi() {
        context = "razi";
        hp = 0;
        hpnrlabel.setText("" + hp);
        area.setText("Unul din garzi te-a lovit si ai dat cu capul de un \nperete. \n\nDin pacate ai murit");
        c1.setText("Iesi din joc");
        c3.setVisible(false);
        c2.setVisible(false);

    }

    public void cheia() {
        context = "cheia";
        area.setText("Nu reu??e??ti s?? iei cheia. Te lini??te??ti ??n cele din urm??. Garzile pleaca iar din fericire una dintre garzi ????i pierde cheia");
        c1.setText("Te dezlegi");
        c2.setVisible(false);
        c3.setVisible(false);
        c2.setText("");
        c3.setText("");

    }

    public void alarma() {
        context = "alarm??";

        area.setText("Se aude un sunet de alarm??. G??rzile pleac?? din \n??nc??perea al??turat??. ??n fa??a ta este o u????");
        c1.setText("Deschide u??a");
    }

    public void camera() {
        context = "camera";
        c2.setVisible(true);
        c3.setVisible(true);
        area.setText("Ai intrat ??ntr-un hol. ??n hol sunt 3 u??i \n\nPe care o alegi?");
        c1.setText("U??a din st??nga");
        c2.setText("U??a din dreapta");
        c3.setText("U??a din fa????");
    }

    public void u1() {
        context = "u1";
        c3.setVisible(false);
        c2.setVisible(true);
        area.setText("Ai intrat ??ntr-o camer??. ??n fa??a ta este o u????. \n\nCe faci?");
        c1.setText("Intr??");
        c2.setText("Mergi ??napoi");
    }

    public void u12() {
        context = "u1";
        c3.setVisible(false);
        c2.setVisible(true);
        area.setText("Ai intrat ??ntr-o camer??. ??n fa??a ta este o u????. \n\nCe faci?");
        c2.setText("Intr??");
        c1.setText("Mergi ??napoi");
    }

    public void katana() {
        context = "katana";
        c3.setVisible(false);
        c2.setVisible(false);
        area.setText("Ai intrat ??ntr-o camer??. Ai g??sit o katan??!");
        c1.setText("Mergi ??napoi");
        weapon = "katana";
        weaponnrlabel.setText("" + weapon);

    }

    public void u3() {
        context = "u3";
        c3.setVisible(false);
        c2.setVisible(true);
        area.setText("Ai deschis ??ncet u??a,camera este plin?? cu c??ini. \n\nCe faci?");
        c1.setText("Intr??");
        c2.setText("Fugi ??napoi");
    }

    public void caini() {
        context = "caini";
        c3.setVisible(false);
        c2.setVisible(false);
        area.setText("Ai crezut ca sunt c??ini dresa??i s?? se ??mpreteneasc?? cu str??ini? \n\nDin p??cate ai murit");
        c1.setText("Ie??i din joc");
    }

    public void u2() {
        area.setText("Ai deschis ??ncet u??a,??n camer?? este un ofi??er. \n\nCe faci?");
        context = "u2";
        c3.setVisible(false);
        c1.setText("Intr?? ??n camer??");
        c2.setText("Fugi ??napoi");
    }

    public void lupta() {
        context = "lupta";
        area.setText("Ofi??erul e agresiv HP: " + hpo + "\n\nCe faci?");
        c1.setText("Atac??");
        c2.setText("Fugi ??napoi");

    }

    public void ninja() {
        c2.setVisible(false);
        context = "ninja";

        int playerDamage = 0;

        if (weapon.equals("-")) {
            playerDamage = new java.util.Random().nextInt(3);
        } else if (weapon.equals("katana")) {
            playerDamage = new java.util.Random().nextInt(12);
        }

        area.setText("Ai atacat cu " + playerDamage + " damage!");

        hpo = hpo - playerDamage;

        c1.setText(">");

    }

    public void ofiter() {
        context = "ofiter";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(20);

        area.setText("Ofi??erul te-a atacat ??i te-a lovit cu " + monsterDamage + " damage!");
        
        hp = hp - monsterDamage;
        hpnrlabel.setText(""+ hp);
    
        c1.setText(">");

    }

    public void aipierdut() {
        context = "aipierdut";

        area.setText("Din p??cate ai murit\n\n");

        c1.setText("Ie??i din joc");

    }

    public void aicastigat() {
        context = "aicastigat";

        area.setText("Felicit??ri ai invins ofi??erul. Cineva deschide u??a..\n\n Este prietenul t??u! El a declan??at alarma pentru a putea evada ??mpreun??.");

        c1.setText("Credits");

    }

    public void credits() {
        context = "credits";

        area.setText("Acesta a fost 'The Lost Ninja v1.0' \n sper c?? ??i-a pl??cut acest joc! \n\n Felicit??ri ??nc?? o dat?? pentru terminarea jocului!");

        c1.setText("Sf??r??itul jocului");

    }

    public class titluHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            scena1();
        }
    }

    public class choiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String alegereaTa = event.getActionCommand();

            switch (context) {
                case "scena1":
                    switch (alegereaTa) {
                        case "c1":
                            dormi();
                            break;
                        case "c2":
                            incerci();
                            break;
                        case "c3":
                            strigi();
                            break;
                    }
                    break;

                case "dormi":
                    switch (alegereaTa) {
                        case "c1":
                            spargi();
                            break;

                    }
                    break;
                case "incerci":
                    switch (alegereaTa) {
                        case "c1":
                            dormi();
                            break;
                        case "c2":
                            strigi();
                            break;

                    }
                    break;
                case "strigi":
                    switch (alegereaTa) {
                        case "c1":
                            razi();
                            break;
                        case "c2":
                            razi();
                            break;
                        case "c3":
                            cheia();
                            break;
                    }
                    break;
                case "razi":
                    switch (alegereaTa) {
                        case "c1":
                            exit(0);
                            break;
                    }
                    break;

                case "cheia":
                    switch (alegereaTa) {
                        case "c1":
                            alarma();
                            break;
                    }
                    break;
                case "spargi":
                    switch (alegereaTa) {
                        case "c1":
                            camera();
                            break;
                    }
                    break;
                case "alarm??":
                    switch (alegereaTa) {
                        case "c1":
                            camera();
                            break;
                    }
                    break;

                case "camera":
                    switch (alegereaTa) {
                        case "c1":
                            u1();
                            break;
                        case "c2":
                            u2();
                            break;
                        case "c3":
                            u3();
                            break;
                    }
                    break;
                case "u1":
                    switch (alegereaTa) {
                        case "c1":
                            katana();
                            break;
                        case "c2":
                            camera();
                            break;
                    }
                    break;

                case "katana":
                    switch (alegereaTa) {
                        case "c1":
                            u12();
                            break;
                    }
                    break;

                case "u3":
                    switch (alegereaTa) {
                        case "c1":
                            caini();
                            break;
                        case "c2":
                            camera();
                            break;

                    }
                    break;
                case "caini":
                    switch (alegereaTa) {
                        case "c1":
                            exit(0);
                            break;
                    }
                    break;

                case "u2":
                    switch (alegereaTa) {
                        case "c1":
                            lupta();
                            break;
                        case "c2":
                            camera();
                            break;
                    }
                    break;

                case "lupta":
                    switch (alegereaTa) {
                        case "c1":
                            ninja();
                            break;

                    }
                    break;

                case "ninja":
                    switch (alegereaTa) {
                        case "c1":
                            if (hpo < 1) {
                                aicastigat();
                                break;
                            } else {
                                ofiter();
                            }
                            break;
                    }
                    break;

                case "ofiter":
                    switch (alegereaTa) {
                        case "c1":
                            if (hp < 1) {
                                aipierdut();
                                break;
                            } else {
                                ninja();
                            }
                            break;
                    }
                    break;

                case "aipierdut":
                    switch (alegereaTa) {
                        case "c1":
                            exit(0);
                            break;
                    }
                    break;

                case "aicastigat":
                    switch (alegereaTa) {
                        case "c1":
                            credits();
                            break;
                    }
                    break;

                case "credits":
                    switch (alegereaTa) {
                        case "c1":
                            exit(0);
                            break;
                    }
                    break;

            }
        }
    }

}
