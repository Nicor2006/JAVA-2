package co.com.ps.C23.servicestest;

import co.com.ps.C23.DOMAIN.Products;
import co.com.ps.C23.Service.ProductService;
import co.com.ps.C23.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductsServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;
    private Products products;

    @BeforeEach
    void setUp() {
        products = new Products();
        products.setProductId(1L);
        products.setProductName("Congelados");
    }
    @Test
    void testFindById(){
        when(productRepository.findById(1L)).thenReturn(Optional.of(products));
        Products productsTmp = productService.findById(1L);
        assertNotNull(productsTmp);
        assertEquals("Congelados", productsTmp.getProductName());

    }

}