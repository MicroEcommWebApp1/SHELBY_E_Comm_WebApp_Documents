package com.sellerregistrationservice.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
class SellerRegistrationDTOTest {
//    private Set<ConstraintViolation<SellerRegistrationDTO>> validateDTO(SellerRegistrationDTO dto) {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//        return validator.validate(dto);
//    }
private Set<ConstraintViolation<SellerRegistrationDTO>> validateDTO(SellerRegistrationDTO dto) {
    ValidatorFactory factory = null;
    try {
        factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(dto);
    } finally {
        if (factory != null) {
            factory.close();
        }
    }
}
    @Test
     void testValidDTO_Positive() {
        // Given
        SellerRegistrationDTO dto = new SellerRegistrationDTO();
        dto.setName("Abhinay");
        dto.setSellerEmailID("abhinay@gmail.com");
        dto.setCompanyName("DXC");
        dto.setCompanyAddress("Hyderabad");
        dto.setPassword("Abhinay@1");

        // When
        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);

        // Then
        assertTrue(violations.isEmpty());
    }

    @Test
     void testInvalidDTO_Negative() {
        // Given
        SellerRegistrationDTO dto = new SellerRegistrationDTO();
        dto.setName("Abhinay");
        dto.setSellerEmailID("invalidemail"); // Invalid email format
        dto.setCompanyName("DXC");
        dto.setCompanyAddress("Hyderabad");
        dto.setPassword("Abhinay");
        dto.setPhoneNumber("8096534531");
        // When
        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);

        // Then
        assertFalse(violations.isEmpty());
    }

    @Test
     void testInvalidDTO_positivecase1() {
        SellerRegistrationDTO dto = new SellerRegistrationDTO();
        dto.setName("Abhinay");
        dto.setSellerEmailID("validemail@gmail.com");
        dto.setPassword("Abhinay@1");

        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);
        assertTrue(violations.isEmpty());

    }

    @Test
     void testInvalidDTO_negtivecase1(){
        SellerRegistrationDTO dto = new SellerRegistrationDTO();

        dto.setSellerEmailID("invalidemail");//invalid email
        dto.setPassword("Abhinay@1");

        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);
        assertFalse(violations.isEmpty());
        //If need to see what error it is
//        for (ConstraintViolation<SellerRegistrationDTO> violation : violations) {
//            System.out.println("Validation Error:");
//            System.out.println("Property Path: " + violation.getPropertyPath());
//            System.out.println("Message: " + violation.getMessage());
//        }
    }
    @Test
     void testInvalidDTO_negtivecase2() {
        SellerRegistrationDTO dto = new SellerRegistrationDTO();

        dto.setSellerEmailID("validemail@gmail.com");
        dto.setPassword("Abhinay");//invalid password

        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);
        assertFalse(violations.isEmpty());
    }
    @Test
     void testInvalidDTO_positivecase2() {
        SellerRegistrationDTO dto = new SellerRegistrationDTO();
        dto.setSellerEmailID("validemail@gmail.com");
        dto.setGstNumber("22AAAAA0000A1Z5");
        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
     void testInvalidDTO_negitivecase3() {
        SellerRegistrationDTO dto = new SellerRegistrationDTO();
        dto.setSellerEmailID("validemail@gmail.com");
        dto.setGstNumber("22AAAAA0000A1Z");
        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);
        assertFalse(violations.isEmpty());
        //If need to see what error it is
//        for (ConstraintViolation<SellerRegistrationDTO> violation : violations) {
//            System.out.println("Validation Error:");
//            System.out.println("Property Path: " + violation.getPropertyPath());
//            System.out.println("Message: " + violation.getMessage());
//        }
    }

    @Test
     void testInvalidDTO_positivecase3() {
        SellerRegistrationDTO dto = new SellerRegistrationDTO();
        dto.setSellerEmailID("validemail@gmail.com");
        dto.setPhoneNumber("8096389823");
        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
     void testInvalidDTO_negitivecase4() {
        SellerRegistrationDTO dto = new SellerRegistrationDTO();
        dto.setSellerEmailID("validemail@gmail.com");
        dto.setPhoneNumber("123456789a");
        Set<ConstraintViolation<SellerRegistrationDTO>> violations = validateDTO(dto);
        assertFalse(violations.isEmpty());
        //If need to see what error it is
//        for (ConstraintViolation<SellerRegistrationDTO> violation : violations) {
//            System.out.println("Validation Error:");
//            System.out.println("Property Path: " + violation.getPropertyPath());
//            System.out.println("Message: " + violation.getMessage());
//        }
    }

}
