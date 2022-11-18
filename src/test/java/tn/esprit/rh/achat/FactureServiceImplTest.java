package tn.esprit.rh.achat;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;



@ExtendWith(MockitoExtension.class)
public class FactureServiceImplTest {
	
	@Mock
	private FactureRepository factureRepository;
	
	
	
	private FactureServiceImpl FactureService;

	Date date = new Date();
	
	@BeforeEach
    void setUp() {
		FactureService = new FactureServiceImpl(factureRepository);
    }

	@Test
    void canRetrieveAllFactures() {
        // when
		FactureService.retrieveAllFactures();
        // then
        verify(factureRepository).findAll();
    }
	
	 @Test
    void canAddFacture() {
        // given
        Facture facture = new Facture(10,350,date,date,true);

        // when
        FactureService.addFacture(facture);

        // then
        ArgumentCaptor<Facture> factureArgumentCaptor =
                ArgumentCaptor.forClass(Facture.class);
        
        verify(factureRepository).save(factureArgumentCaptor.capture());

        Facture capturedFacture = factureArgumentCaptor.getValue();

        assertThat(capturedFacture).isEqualTo(facture);
        
        
    }
	 
	  
}


