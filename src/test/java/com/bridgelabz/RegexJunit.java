package com.bridgelabz;

import org.junit.Test;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class RegexJunit {

    String input;
    boolean expectedResult;
    UserDetails userDetails;

    public RegexJunit(String input, boolean expectedResult) {

		userDetails = new UserDetails();
        this.input = input;
        this.expectedResult = expectedResult;
    }
    @Parameterized.Parameters
    public static Collection emailInputs() {
        return Arrays.asList(new Object[][] {
                {"abc@yahoo.com", true},
                {"abc-100@yahoo.com", true},
                {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true},
                {"abc-100@abc.net", true},
                {"abc.100@abc.com.au", true},
                {"abc@1.com", true},
                {"abc@gmail.com.com", true},
                {"abc+100@gmail.com", true},
                {"abc", false},
                {"abc@.com.my", false},
                {"abc123@gmail.a", false},
                {"abc123@.com", false},
                {"abc123@.com.com", false},
                {".abc@abc.com", false},
                {"abc()*@gmail.com", false},
                {"abc@%*.com", false},
                {"abc..2002@gmail.com", false},
                {"abc.@gmail.com", false},
                {"abc@abc@gmail.com", false},
                {"abc@gmail.com.1a", false},
                {"abc@gmail.com.aa.au", false},
        });
    }

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
    public void emailTest() {
        UserDetails userDetails = new UserDetails();
        boolean output = UserDetails.validateEMail(input);
        assertEquals(expectedResult, output);
    }
}
