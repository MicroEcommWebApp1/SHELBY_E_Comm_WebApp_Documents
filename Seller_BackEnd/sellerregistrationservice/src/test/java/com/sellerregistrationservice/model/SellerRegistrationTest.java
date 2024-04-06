package com.sellerregistrationservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;


class SellerRegistrationTest {

    @Test
     void testSellerRegistrationConstructor() {
        // Given
        int id = 1;
        String name = "Abhinay";
        String emailID = "Abhinay@gmail.com";
        String companyName = "DXC";
        String gstNumber = "123456789012345";
        String companyAddress = "Hyderabad";
        String phoneNumber = "1234567890";
        String password = "Abhinay";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        // When
        SellerRegistration seller = new SellerRegistration( id,name, emailID, companyName, gstNumber, companyAddress,
                phoneNumber, password, createdAt, updatedAt);

        // Then
        assertNotNull(seller);
        assertEquals(id, seller.getId());
        assertEquals(name, seller.getName());
        assertEquals(emailID, seller.getEmailID());
        assertEquals(companyName, seller.getCompanyName());
        assertEquals(gstNumber, seller.getGstNumber());
        assertEquals(companyAddress, seller.getCompanyAddress());
        assertEquals(phoneNumber, seller.getPhoneNumber());
        assertEquals(password, seller.getPassword());
        assertEquals(createdAt, seller.getCreatedAt());
        assertEquals(updatedAt, seller.getUpdatedAt());
    }
    @Test
     void testSellerRegistrationConstructor_Negative() {
        // Given
        int id = 1;
        String name = "Test Seller";
        String emailID = "test@gmail.com";
        // Other fields are intentionally left null or empty

        // When
        SellerRegistration seller = new SellerRegistration(id, name, emailID, null, null, null,
                null, null, null, null);

        // Then
        assertNotNull(seller);
        assertEquals(id, seller.getId());
        assertEquals(name, seller.getName());
        assertEquals(emailID, seller.getEmailID());
        assertNull(seller.getCompanyName());
        assertNull(seller.getGstNumber());
        assertNull(seller.getCompanyAddress());
        assertNull(seller.getPhoneNumber());
        assertNull(seller.getPassword());
        assertNull(seller.getCreatedAt());
        assertNull(seller.getUpdatedAt());
    }
}
