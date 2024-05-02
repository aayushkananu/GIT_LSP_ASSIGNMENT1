package org.howard.edu.lsp.oopfinal.exam.question2;

public class PayPalPayment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal account " + email);
    }
}
