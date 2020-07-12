package alpha.profile.model;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import javax.persistence.*;


@Table("address")
public class Address {
    @PrimaryKey
    private String addressId;

    @Column(name="ADDRESS_LINE1",length=50,nullable=false,unique=true)
    private String address_line1;

    @Column(name="ADDRESS_LINE2",length=50,nullable=false,unique=true)
    private String address_line2;

    @Column(name="CITY",length=30,nullable=false)
    private String city;

    @Column(name="ZIPCODE",length=10,nullable=false)
    private Long zipcode;

    @Column(name="STATE",length=30,nullable=false)
    private String state;

    @Column(name="COUNTRY",length=30,nullable=false)
    private String country;

    //default constructor
    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Address(String addressId, String address_line1,String address_line2,String city, Long zipcode, String state,String country) {
        super();
        this.addressId = addressId;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city=city;
        this.zipcode = zipcode;
        this.state = state;
        this.country = country;
    }

    public String getAddressid() {
        return addressId;
    }

    public void setAddressid(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine1() {
        return address_line1;
    }

    public void setAddressLine1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddressLine2() {
        return address_line2;
    }

    public void setAddressLine2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address [addressId=" + addressId + ", Address line 1=" + address_line1 + ", Address line 2=" + address_line2+ ", City=" + city+", Zipcode=" + zipcode+ ", State=" + state + ", Country="
                + country+ "]";
    }
}