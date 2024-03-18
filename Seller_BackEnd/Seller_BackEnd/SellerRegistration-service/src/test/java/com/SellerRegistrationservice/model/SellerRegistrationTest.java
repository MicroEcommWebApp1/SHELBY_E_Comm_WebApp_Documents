package com.SellerRegistrationservice.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class SellerRegistrationTest {

    @Test
    public void testSellerRegistrationConstructor() {
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
        assertEquals(createdAt, seller.getCreated_at());
        assertEquals(updatedAt, seller.getUpdated_at());
    }
    @Test
    public void testSellerRegistrationConstructor_Negative() {
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
        assertNull(seller.getCreated_at());
        assertNull(seller.getUpdated_at());
    }
}