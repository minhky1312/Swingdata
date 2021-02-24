import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Data extends JFrame {


    public static void main(String[] args) {
            Data dat = new Data();
            dat.setVisible(true);


    }

    public Data()
    {

        setBounds(300, 100, 1000, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();

        SpringLayout sl_contentPane = new SpringLayout();
        panel1.setLayout(sl_contentPane);

        //Tạo label
        JLabel lbstar1 = new JLabel("*");
        lbstar1.setForeground(Color.red);
        sl_contentPane.putConstraint(SpringLayout.EAST, lbstar1, 30, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lbstar1, 10, SpringLayout.WEST, panel1);
        panel1.add(lbstar1);

        JLabel lbstar2 = new JLabel("*");
        lbstar2.setForeground(Color.red);
        sl_contentPane.putConstraint(SpringLayout.EAST, lbstar2, 250, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lbstar2, 10, SpringLayout.WEST, panel1);
        panel1.add(lbstar2);

        JLabel lblog = new JLabel("Log của ngày");
        sl_contentPane.putConstraint(SpringLayout.EAST, lblog, 110, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblog, 10, SpringLayout.WEST, panel1);
        panel1.add(lblog);

        JLabel lblog2 = new JLabel("Số dòng");
        sl_contentPane.putConstraint(SpringLayout.EAST, lblog2, 305, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblog2, 10, SpringLayout.WEST, panel1);

        panel1.add(lblog2);


        //Tạo Textfield

        JComboBox CBBday = new JComboBox();
        CBBday.addItem("");
        CBBday.addItem("2021-02-23");
        CBBday.addItem("2021-02-22");
        CBBday.addItem("2021-02-21");
        JScrollPane scrollPane1 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane1, 10, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane1, -480, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane1, 120, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane1, -760, SpringLayout.EAST, panel1);;
        panel1.add(scrollPane1);
        scrollPane1.setViewportView(CBBday);

        JTextField tfrow = new JTextField();
        JScrollPane scrollPane2 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane2, 10, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane2, -480, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane2, 315, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane2, -600, SpringLayout.EAST, panel1);;
        panel1.add(scrollPane2);
        scrollPane2.setViewportView(tfrow);

        JButton reboot = new JButton("Làm mới dữ liệu");
        reboot.setBackground(Color.cyan);
        reboot.setForeground(Color.WHITE);
        JScrollPane scrollPane3 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane3, 10, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane3, -470, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane3, 410, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane3, -420, SpringLayout.EAST, panel1);;
        panel1.add(scrollPane3);
        scrollPane3.setViewportView(reboot);

        //Tạo textArea

        JTextArea datarecord = new JTextArea();
        datarecord.setBackground(Color.BLACK);
        datarecord.setForeground(Color.WHITE);
        JScrollPane scrollPane4 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane4, 50, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane4, -20, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane4, 30, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane4, -10, SpringLayout.EAST, panel1);;

        panel1.add(scrollPane4);
        scrollPane4.setViewportView(datarecord);


        this.add(panel1);

        //Phương thức

        reboot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CBBday.getSelectedItem() == "") {
                try {
                    File f = new File("F:/in.txt");
                    if (f.createNewFile()) {
                        System.out.println("File" + f.getName() + " add! ");
                    }

                    Scanner read = new Scanner(f);
                    String data = "";
                    String str = "";
                    int row = 0;

                        while (read.hasNextLine()) {
                            data = read.nextLine();
                            row += 1;
                            str += data + "\n";


                        }
                        tfrow.setText(String.valueOf(row));
                        datarecord.setText(str);
                    read.close();
                } catch (Exception ee) {
                    System.out.println("Error");
                    ee.printStackTrace();
                }
                    } else {
                    try {
                        File f = new File("F:/in.txt");
                        if (f.createNewFile()) {
                            System.out.println("File" + f.getName() + " add! ");
                        }

                        Scanner read = new Scanner(f);
                        String data = "";
                        String str = "";
                        int row = 0;
                        while (read.hasNextLine()) {
                            data = read.nextLine();
                            Pattern patternDate = Pattern.compile("^\\d{4}[-|/]\\d{2}[-|/]\\d{2}$");
                            char ch[] = data.toCharArray();
                            String a = "";
                            for (int j = 0; j <= 9; j++) a += ch[j];
                            if (patternDate.matcher(a).matches()) {
                                if (CBBday.getSelectedItem().toString().equals(a)) {
                                    str += data+ "\n";
                                    row += 1;


                                }
                            }
                        }
                        tfrow.setText(String.valueOf(row));
                        datarecord.setText(str);
                        read.close();

                    }

                     catch(Exception ee){
                        System.out.println("Error");
                        ee.printStackTrace();
                    }
                }
                }





        });

    }

}


