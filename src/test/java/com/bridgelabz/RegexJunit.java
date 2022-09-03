package com.bridgelabz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegexJunit {
    @Test
    public void firstNameHappy() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validateName("Naman");
        assertEquals(true, output);
    }

    @Test
    public void firstNameSad() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validateName("naman");
        assertEquals(false, output);
    }

    @Test
    public void phoneNumberHappy() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validatePhoneNumber("91 1234567890");
        assertEquals(true, output);
    }

    @Test
    public void phoneNumberSad() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validatePhoneNumber("hi@@gmail.com");
        assertEquals(false, output);
    }

    @Test
    public void passwordHappy() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validatePassword("hi5!There");
        assertEquals(true, output);
    }

    @Test
    public void passwordSad() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validatePassword("hi!!therekfjslkf");
        assertEquals(false, output);
    }

    @Test
    public void emailHappy() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validateEMail("hi@gmail.com");
        assertEquals(true, output);
    }

    @Test
    public void emailSad() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validateEMail("hi@@gmail.com");
        assertEquals(false, output);
    }
}
