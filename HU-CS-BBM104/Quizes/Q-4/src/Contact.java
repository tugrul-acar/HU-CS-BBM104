public class Contact implements Comparable<Contact>{
    private final String socialSecurityNumber;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    public Contact(String phoneNumber,String firstName,String lastName,String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }


    @Override
    public int compareTo(Contact a)
    {
        return this.phoneNumber.compareTo(a.phoneNumber);
    }
}

