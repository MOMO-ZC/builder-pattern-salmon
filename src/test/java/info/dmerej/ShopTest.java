package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest {

    private final Address fsfAddress = new Address(
        "51 Franklin Street",
        "Fifth Floor",
        "Boston",
        "02110",
        "USA"
    );

    private final Address parisAddress = new Address(
        "33 quai d'Orsay",
        "",
        "Paris",
        "75007",
        "France"
    );

    @Test
    public void happy_path() {
        User user = new UserBuilder().build();
        assertTrue(Shop.canOrder(user));
        assertFalse(Shop.mustPayForeignFee(user));
    }

    @Test
    public void minors_cannot_order_from_shop() {
        User user = new UserBuilder().setAge(16).build();
        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void must_be_verified_to_order_from_shop() {
        User user = new UserBuilder().setVerified(false).build();
        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void foreigners_must_pay_foreign_fee() {
        User user = new UserBuilder().setAddress(parisAddress).build();
        assertTrue(Shop.mustPayForeignFee(user));
    }

}
