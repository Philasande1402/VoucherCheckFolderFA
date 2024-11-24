package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.VoucherCheck;
import models.Voucher;

public class VoucherAppGUI extends JFrame {
    private JTextArea voucherArea;
    private JLabel validVoucherCountLabel;
    private VoucherCheck voucherCheck;
    private JButton saveReportButton;

    public VoucherAppGUI(VoucherCheck voucherCheck) {
        this.voucherCheck = voucherCheck;

        // Set up the frame
        setTitle("Voucher Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create and add components
        JPanel voucherPanel = new JPanel(new BorderLayout());
        voucherPanel.setBorder(BorderFactory.createTitledBorder("Available Vouchers"));
        voucherArea = new JTextArea(10, 30);
        voucherPanel.add(new JScrollPane(voucherArea), BorderLayout.CENTER);
        add(voucherPanel);

        JButton loadButton = new JButton("Load Available Vouchers");
        add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file.getName().equals("voucheravail.txt")) {
                        loadVouchers(file);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select the voucheravail.txt file.");
                    }
                }
            }
        });

        validVoucherCountLabel = new JLabel("Valid Voucher Count: 0");
        add(validVoucherCountLabel);

        JButton countButton = new JButton("Count Valid Vouchers");
        add(countButton);
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countValidVouchers();
                saveReportButton.setEnabled(true);
            }
        });

        saveReportButton = new JButton("Save Voucher Report");
        saveReportButton.setEnabled(false); // Initially disabled
        add(saveReportButton);
        saveReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveVoucherReport();
            }
        });
    }

    private void loadVouchers(File file) {
   
             try {
                 BufferedReader rd = new BufferedReader(new FileReader(file));
                 voucherArea.setText("");
                 String line;
                 while((line=rd.readLine()) != null)
                 {
                     voucherArea.append(line+"\n");
                 }
                 //rd.close();
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
        
           
       
    }

    private void countValidVouchers() {
       
       String[] vouchers = voucherArea.getText().split("\\n");
       int counter=0;
       for(String code:vouchers)
       {
           Voucher voucher = new Voucher(code.trim());
           
           if(!voucherCheck.checkVoucher(voucher))
           {
               counter++;
           }
       }
       validVoucherCountLabel.setText("Valid Voucher Count: "+counter);
       
    }

    private void saveVoucherReport() {
  
       JFileChooser fc = new JFileChooser();
       int val = fc.showSaveDialog(null);
       if(val == JFileChooser.APPROVE_OPTION)
       {
           File file = fc.getSelectedFile();
           try {
               BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
               bw.write(validVoucherCountLabel.getText());
               bw.newLine();
               bw.close();
               JOptionPane.showMessageDialog(null, "Report saved successfully");
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }
    }


}
