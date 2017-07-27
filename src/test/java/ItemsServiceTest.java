import com.epam.Application;
import com.epam.exceptions.ResourceNotFoundException;
import com.epam.models.Customer;
import com.epam.models.Item;
import com.epam.services.CustomerService;
import com.epam.services.ItemService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ItemsServiceTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private CustomerService customerService;

    @Test
    public void notNullService() {
        assertNotNull(itemService);
    }

    @Test
    public void addItemsTest() {

        customerService.addCustomer(new Customer(99, "TEST", "TEST", null));
        int size1;
        try {
            size1 = customerService.getCustomerById(99).getItems().size();
        } catch (Exception e) {
            size1 = 0;
        }
        customerService.addOrUpdateItem(99, new Item(99, null));
        int size2 = customerService.getCustomerById(99).getItems().size();
        assertNotEquals(size1, size2);
    }


    @Test
    @After
    public void deleteItemsTest() {
        customerService.addOrUpdateItem(99,new Item(99,null));
        int size1 = customerService.getCustomerById(99).getItems().size();
        customerService.deleteItemsById(99, 99);
        int size2;
        try {
            size2 = customerService.getCustomerById(99).getItems().size();
        } catch (Exception e) {
            size2 = 0;
        }
        assertNotEquals(size1, size2);
    }
}
