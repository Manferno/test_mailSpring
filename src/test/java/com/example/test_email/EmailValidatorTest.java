package com.example.test_email;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailValidatorTest {

    @Test
    void ensureThatEmailValidatorReturnsTrueForValidEmail() {
        assertTrue(EmailValidator.isValidEmail("lars.vogel@gmail.com"));
    }

    @Test
    void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("lars.vogel@analytics.gmail.com"));
    }

    @Test
    void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("lars.vogel@gmail"));
    }

    @Test
    void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertTrue(EmailValidator.isValidEmail("lars..vogel@gmail.com"));
        assertFalse(EmailValidator.isValidEmail("lars..vogel@gmail..com"));
    }

    @Test
    void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@gmail.com"));
    }

    @Test
    void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    void emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null));
    }

}