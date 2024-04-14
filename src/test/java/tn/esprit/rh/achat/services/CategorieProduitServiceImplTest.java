package tn.esprit.rh.achat.services;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CategorieProduitServiceImpl.class)
class CategorieProduitServiceImplTest {
    @Autowired
    private CategorieProduitServiceImpl categorieProduitService;

    @MockBean
    private CategorieProduitRepository categorieProduitRepository;

    private CategorieProduit categorieProduit;

    @Before
    public void setUp() {
        categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setLibelleCategorie("Test");
    }

    @Test
    public void testRetrieveAllCategorieProduits() {
        List<CategorieProduit> categoriesProduitList = Arrays.asList(categorieProduit);
        when(categorieProduitRepository.findAll()).thenReturn(categoriesProduitList);

        List<CategorieProduit> result = categorieProduitService.retrieveAllCategorieProduits();

        assertEquals(1, result.size());
        assertEquals(categorieProduit, result.get(0));
    }
}