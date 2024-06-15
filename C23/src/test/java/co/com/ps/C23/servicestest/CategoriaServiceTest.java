package co.com.ps.C23.servicestest;

import co.com.ps.C23.DOMAIN.Category;
import co.com.ps.C23.Service.CategoriaService;
import co.com.ps.C23.repository.CategoriesRepository;
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
public class CategoriaServiceTest {

    @Mock
    private CategoriesRepository categoriesRepository;

    @InjectMocks
    private CategoriaService categoriaService;
    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("Congelados");
    }
    @Test
    void testFindById(){
        when(categoriesRepository.findById(1L)).thenReturn(Optional.of(category));
        Category categoryTmp = categoriaService.findById(1L);
        assertNotNull(categoryTmp);
        assertEquals("Congelados", categoryTmp.getCategoryName());

    }

}