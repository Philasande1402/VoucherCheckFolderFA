/*
2.2 VoucherCheck Class (6)
*/

package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Voucher;


public class VoucherCheck {
    private List<String> redeemedVouchers;

    public VoucherCheck() {
        
        /*
        On instantiation, read all redeemed voucher codes from a file named voucherused.txt. 
        
        Each line of the file contains one redeemed voucher code.

        Store these redeemed voucher codes in a list named redeemedVouchers.
        */
        
        redeemedVouchers = new ArrayList<>(); //1 - List init
        
        //5 - List read in correctly. (5 or nothing)
        
        try (BufferedReader br = new BufferedReader(new FileReader("voucherused.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                redeemedVouchers.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkVoucher(Voucher voucher) {
        return redeemedVouchers.contains(voucher.getVoucherCode());
    }
}
