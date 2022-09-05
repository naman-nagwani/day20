package com.bridgelabz;

import java.util.regex.Pattern;

@FunctionalInterface
interface verify{
    boolean verify(String regex,String value);
    static void output(verify obj, String regex, String details) {
        if (obj.verify(regex, details)) {
            System.out.println("'" +details+ "' Valid");
        }
        else {
            System.out.println("'" +details+ "' Invalid");
        }
    }
}

public class UserDetailsVerificationUsingLambda {

    public static void main(String[] args) {
        verify detailVerification = Pattern::matches;
        System.out.println("\nFirst Name");
        verify.output(detailVerification,"^[A-Z][a-z]{2,}$","Naman");
        verify.output(detailVerification,"^[A-Z][a-z]{2,}$","naman");
        System.out.println("\nLast Name");
        verify.output(detailVerification,"^[A-Z][a-z]{2,}$","Nagwani");
        verify.output(detailVerification,"^[A-Z][a-z]{2,}$","nagwani");
        System.out.println("\nemail ID");
        verify.output(detailVerification,"^([a-z0-9]+(?:[+._-][a-z0-9]+)*)@([a-z0-9]+(?:[.-][a-z0-9]+)*\\.[a-z]{2,})$","namannagwani@gmailcom");
        verify.output(detailVerification,"^([a-z0-9]+(?:[+._-][a-z0-9]+)*)@([a-z0-9]+(?:[.-][a-z0-9]+)*\\.[a-z]{2,})$","namannagwani@.com");
        System.out.println("\nPhone Number");
        verify.output(detailVerification,"^[0-9]{2} [0-9]{10}$","91 9669199004");
        verify.output(detailVerification,"^[0-9]{2} [0-9]{10}$","919669199004");
        System.out.println("\nPassword");
        verify.output(detailVerification,"^(?=.*[A-Z])(?=.*[0-9])(?=.*\\p{Punct}).{8,}$","Naman#98");
        verify.output(detailVerification,"^(?=.*[A-Z])(?=.*[0-9])(?=.*\\p{Punct}).{8,}$","ab##00");
    }
}
