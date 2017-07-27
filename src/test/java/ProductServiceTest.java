

import com.epam.Application;
import com.epam.persistence.ProductsRepository;
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
public class ProductServiceTest {

    @Autowired
    private ProductsRepository productsRepository;

    @Test
    public void notNull(){
        assertNotNull(productsRepository);
    }
}
