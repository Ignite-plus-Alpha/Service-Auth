package alpha.profile.model;


import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.UUID;


@Table("wallet")
public class Wallet {


    @PrimaryKeyColumn(name="WALLETID", type=PrimaryKeyType.CLUSTERED)
    private String walletId;

    @PrimaryKeyColumn(name="USERID", type= PrimaryKeyType.PARTITIONED)
    private UUID userId;

    @Column(name="CARDHOLDER NAME",length=50,nullable=false,unique=true)
    private String cardholder_name;

    @Column(name="CARD_NUMBER",length=50,nullable=false,unique=true)
    private Long card_number;

    @Column(name="EXPIRY DATE",length=30,nullable=false)
    private LocalDate expiry_date;

    @Column(name="UPI ID",length=50,nullable=false,unique=true)
    private String upi_id;
    

    //default constructor
    public Wallet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Wallet(String walletId, UUID userId, String cardholder_name,Long card_number,LocalDate expiry_date, String upi_id) {
        super();
        this.walletId = walletId;
        this.userId = userId;
        this.cardholder_name = cardholder_name;
        this.card_number = card_number;
        this.expiry_date = expiry_date;
        this.upi_id = upi_id;

    }

    public String getWalletId() {
        return walletId;
    }

    public String getUserId() {
        return UUID.randomUUID().toString();
    }

    public void setuserId(UUID userId) {
        this.userId = userId;
    }


    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getCardholderName() {
        return cardholder_name;
    }

    public void setCardholderName(String cardholder_name) {
        this.cardholder_name = cardholder_name;
    }

    public Long getCardNumber() {
        return card_number;
    }

    public void setCardNumber(Long card_number) {
        this.card_number = card_number;
    }


    public LocalDate getExpiryDate() {
        return expiry_date;
    }

    public void setExpiryDate(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getUpi_id() {
        return upi_id;
    }

    public void setUpi_id(String upi_id) {
        this.upi_id = upi_id;
    }



    @Override
    public String toString() {
        return "Wallet [walletId=" + walletId + ", Cardholder Name=" + cardholder_name + ", Card Number=" + card_number+ ", expiry_date=" + expiry_date+ ", UPI ID=" + upi_id +"]";
    }
}
