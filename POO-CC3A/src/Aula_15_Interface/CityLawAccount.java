
package Aula_15_Interface;

import java.util.Date;

/**
 * Classe de conta jurídica de cidade
 * @author david-ferreira
 */

public class CityLawAccount extends LawAccount {
    public String cityName;
    
    /* Traz os parametros da classe BankAccount e da classe LawAccount mais o parametro cityName. */
    public CityLawAccount(String cityName, String aim, Date start, Date end, double admFee, String owner, int accountNumber, double balance, String password) {
        super(aim, start, end, admFee, owner, accountNumber, balance, password);
        this.cityName = cityName;
    }
    
    @Override
    public double getBalance() {
        return super.getBalance();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    @Override
    public String toString() {
        return String.format("CityLawAccount{CityName: %s | %s}", this.cityName, super.toString());
    }
}
  