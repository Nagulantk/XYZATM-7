package Model;
import java.time.LocalDate;

public class Customer {
    private String name;
    private long panNumber;
    private LocalDate dateOfBirth;


    public String getName() {
        return name;
    }

    public long getPanNumber() {
        return panNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }



    public long getPhoneNumber() {
        return phoneNumber;
    }

    private long phoneNumber;

    public Customer(String name,long panNumber,LocalDate dateOfBirth,long phoneNumber)
    {
        this.name=name;
        this.panNumber=panNumber;
        this.dateOfBirth=dateOfBirth;
        this.phoneNumber=phoneNumber;
    }



}
