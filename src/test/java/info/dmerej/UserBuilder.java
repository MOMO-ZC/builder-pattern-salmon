package info.dmerej;

//Builder Class
public class UserBuilder {

    // required parameters
    private String name = "Bob";
    private String email = "bob@domain.tld";
    private int age = 18;
    private boolean verified = true;
    private Address address = new Address(
            "51 Franklin Street",
            "Fifth Floor",
            "Boston",
            "02110",
            "USA"
    );

    public UserBuilder(){
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder setVerified(boolean isVerified) {
        this.verified = isVerified;
        return this;
    }
    public UserBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public User build(){
        return new User(this.name, this.email, this.age, this.verified, this.address);
    }
}
