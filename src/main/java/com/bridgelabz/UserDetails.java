package com.bridgelabz;

import com.bridgelabz.exceptions.InvalidEMailException;
import com.bridgelabz.exceptions.InvalidNameException;
import com.bridgelabz.exceptions.InvalidPasswordException;
import com.bridgelabz.exceptions.InvalidPhoneNumberException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDetails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = "abc";
        String lastName = "abc";
        String eMail = "abc";
        String phoneNumber = "abc";
        String password = "abc";
        try {
            while (!validateName(firstName)) {
                System.out.println("Enter First Name");
                firstName = scan.nextLine();
                if (!validateName(firstName))
                    System.out.println("Invalid Input");
            }
        } catch (InvalidNameException e) {
            System.out.println(e);
        }
        try {
            while (!validateName(lastName)) {
                System.out.println("Enter Last Name");
                lastName = scan.nextLine();
                if (!validateName(lastName))
                    System.out.println("Invalid Input");
            }
        } catch (InvalidNameException e) {
            System.out.println(e);
        }
        try {

            while (!validateEMail(eMail)) {
                System.out.println("Enter E-Mail");
                eMail = scan.nextLine();
                if (!validateEMail(eMail))
                    System.out.println("Invalid Input");
            }
        } catch (InvalidEMailException e) {
            System.out.println(e);
        }
        try {
            while (!validatePhoneNumber(phoneNumber)) {
                System.out.println("Enter Phone Number");
                phoneNumber = scan.nextLine();
                if (!validatePhoneNumber(phoneNumber))
                    System.out.println("Invalid Input");
            }
        } catch (InvalidPhoneNumberException e){
            System.out.println(e);
        }
        try {
            while (!validatePassword(password)) {
                System.out.println("Enter Password");
                password = scan.nextLine();
                if (!validatePassword(password))
                    System.out.println("Invalid Input");
            }
        } catch (InvalidPasswordException e){
            System.out.println(e);
        }
    }

    public static boolean validatePassword(String password) throws InvalidPasswordException {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*\\p{Punct}).{8,}$");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches())
            throw new InvalidPasswordException();
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        Pattern pattern = Pattern.compile("^[0-9]{2} [0-9]{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches())
            throw new InvalidPhoneNumberException();
        return matcher.matches();
    }

    public static boolean validateEMail(String eMail) throws InvalidEMailException {
        Pattern pattern = Pattern.compile("^([a-z0-9]+(?:[+._-][a-z0-9]+)*)@([a-z0-9]+(?:[.-][a-z0-9]+)*\\.[a-z]{2,})$");
        Matcher matcher = pattern.matcher(eMail);
        if (!matcher.matches())
            throw new InvalidEMailException();
        return matcher.matches();
    }

    public static boolean validateName(String firstName) throws InvalidNameException {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
        Matcher matcher = pattern.matcher(firstName);
        if(!matcher.matches())
            throw new InvalidNameException();
        return matcher.matches();
    }
}
