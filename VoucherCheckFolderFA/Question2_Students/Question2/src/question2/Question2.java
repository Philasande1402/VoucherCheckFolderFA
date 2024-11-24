package question2;

import utils.VoucherCheck;
import gui.VoucherAppGUI;
        

public class Question2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VoucherCheck voucherCheck = new VoucherCheck();
        VoucherAppGUI app = new VoucherAppGUI(voucherCheck);
        app.setVisible(true);
    }
    
}
