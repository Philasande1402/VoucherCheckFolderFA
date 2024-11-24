/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package question2fa;

import utils.VoucherCheck;
import gui.VoucherAppGUI;

public class Question2FA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VoucherCheck voucherCheck = new VoucherCheck();
        VoucherAppGUI app = new VoucherAppGUI(voucherCheck);
        app.setVisible(true);
    }
    
}
