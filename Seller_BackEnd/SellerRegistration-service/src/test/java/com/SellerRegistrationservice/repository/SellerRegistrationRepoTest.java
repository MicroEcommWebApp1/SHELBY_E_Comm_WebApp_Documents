package com.SellerRegistrationservice.repository;

import com.SellerRegistrationservice.model.SellerRegistration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SellerRegistrationRepoTest {

    @Autowired
    private SellerRegistrationRepo sellerRegistrationRepo;

    @Autowired
    private TestEntityManager entityManager;
    
    @BeforeEach
    void setUp() {
        SellerRegistration sellerRegistration =SellerRegistration.builder().id(1).emailID("18891a05e8.abhinaykumar@gmail.com").build();
        entityManager.persist(sellerRegistration);
    }

    @Test
    public void Passing_ValidEmailID(){
    SellerRegistration seller =sellerRegistrationRepo.findByEmailID("18891a05e8.abhinaykumar@gmail.com");
    assertEquals(1,seller.getId());
}

}