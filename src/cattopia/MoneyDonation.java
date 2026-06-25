package cattopia;

import java.time.LocalDate;
import java.util.Date;


import java.time.LocalDate;
import java.util.Date;


public class MoneyDonation extends Donation{
  private int Price;

    public MoneyDonation(Donation DonationType, LocalDate DonationDate, String UserID, String ShelterID) {
        super(DonationType, DonationDate, UserID, ShelterID);
    }

    public MoneyDonation(int Price, Donation DonationType, LocalDate DonationDate, String UserID, String ShelterID) {
        super(DonationType, DonationDate, UserID, ShelterID);
        this.Price = Price;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
    if (Price <= 0) {
        throw new IllegalArgumentException("Donation amount must be greater than 0");
    }
    this.Price = Price;
}

}