package info.dmerej;

public class Shop {

    /**
     * Verify if a person can order
     * @param user
     * @return
     */
    public static boolean canOrder(User user) {

        boolean minor = user.age() < 18;    // test majority
        boolean verified = user.verified();     // verified or not

        // If the person is minor or the person isn't verified
        if (minor || !verified){
            return false;
        }
        return true;
    }

    /**
     * Allows to verify the person country to pay fee or not
     * @param user
     * @return
     */
    public static boolean mustPayForeignFee(User user) {
        return !user.address().country().equals("USA");
    }
}
