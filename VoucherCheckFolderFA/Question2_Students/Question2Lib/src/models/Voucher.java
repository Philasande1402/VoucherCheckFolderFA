/*
(2.1) Voucher Class: (4)


*/

package models;

import java.util.Date;
import java.util.Calendar;

public class Voucher {
    private String voucherCode;
    private Date expiryDate;

    public Voucher(String voucherCode) {
        /*
        The constructor should accept a String parameter for the voucher code and set the expiry date to 3 weeks from the current date.
        */
        this.voucherCode = voucherCode; //1
        
        // Set expiry date to 3 weeks from the current date
        Calendar calendar = Calendar.getInstance(); 
        calendar.add(Calendar.WEEK_OF_YEAR, 3);
        this.expiryDate = calendar.getTime(); //3 - Marks for any method adding 3 weeks
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
