package com.buyer.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import com.buyer.entity.Buyer;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class BuyerRepositoryTest {
	
    @Autowired
    private BuyerRepository buyerRepository;

	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	public void setup() {
	//Buyer buyer = new Buyer();
	Buyer buyer = Buyer.builder().email("swetha333555@gmail.com").password("swetha08!").build();
	//Buyer buyer=Buyer.builder().id(1).email("satyavardhan286@gmail.com").build();
	//buyer.setId(1);
	/*buyer.setId(1);
	buyer.setName("Swetha");
	buyer.setEmail("swetha333555@gmail.com");
	buyer.setPassword("swetha08!");
	buyer.setPhonenumber("9876544321");*/
	entityManager.persist(buyer);
	
	}
	
	@Test
	public void findByEmail_Test() {
	    Buyer buyer = buyerRepository.findByEmail("swetha333555@gmail.com");
	    assertEquals("swetha08!",buyer.getPassword());
	   // assertEquals(1,buyer.getId());
	}

}

