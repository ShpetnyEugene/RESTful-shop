import com.epam.Application;
import com.epam.exceptions.ResourceNotFoundException;
import com.epam.models.Customer;
import com.epam.services.CustomerService;
import org.junit.After;
import org.junit.AfterClass;
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
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Test
    public void notNullService() {
        assertNotNull(service);
    }

    @Test
    public void getAllCustomers() {
        assertNotNull(service.getAllCustomers());
    }


    @Test
    public void addCustomerTest() {
        int size1;
        try {
            size1 = service.getAllCustomers().size();
        } catch (ResourceNotFoundException e) {
            size1 = 0;
        }
        service.addCustomer(new Customer(99, "TEST", "TEST", null));
        int size2 = service.getAllCustomers().size();
        assertNotEquals(size1, size2);
    }


    @Test
    @After
    public void deleteById() {
        service.addCustomer(new Customer(99, "TEST", "TEST", null));
        int size = service.getAllCustomers().size();
        service.deleteCustomerById(99);
        int size2;
        try {
            size2 = service.getAllCustomers().size();
        }catch (ResourceNotFoundException e){
            size2 = 0;
        }
        assertNotEquals(size, size2);
    }
}