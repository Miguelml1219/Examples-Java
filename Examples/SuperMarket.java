import javax.swing.*;

public class SuperMarket {
    int value, age;
    double valueDiscount, valueIVA, Tax;
    boolean club;

    public SuperMarket(int value, int age, boolean club) {
        this.value = value;
        this.age = age;
        this.club = club;
        this.valueDiscount = calculateDiscount();
        this.valueIVA = getValueWithIVA();
        this.Tax = getTax();
    }

    public double calculateDiscount() {
        double discount = 0.0, tax = 0.0;


        if (age > 0 && age <= 15) {
            discount = 0.13;
        } else if (age>=16 && age <= 23) {
            discount = 0.23;
        } else if (age >= 24 && age <= 49) {
            discount = 0.45;
        } else if(age >=50 && age<=100){
            discount = 0.67;
        } else {
            JOptionPane.showMessageDialog(null, "Discount does not apply");

        }

        double discountValue = value - (value * discount);

        if (club) {
            discountValue -= (discountValue * 0.12);
        }

        if (discountValue>100000){
            JOptionPane.showMessageDialog(null, "Your purchase exceeds $100000, you are taxed at 5%");
            discountValue += (discountValue * 0.05);
            tax = discountValue*0.05;
            JOptionPane.showMessageDialog(null, "Tax of 5%: $"+tax);

        }
        return discountValue;
    }

    public String getClubStatus() {
        return club ? "You are in the VIP club, you get a 12% discount " : "You aren't in the VIP club";
    }

    public double getIVA(){
        return valueDiscount*0.19;
    }
    public double getValueWithIVA() {
        valueIVA = valueDiscount + (valueDiscount * 0.19);
        return valueIVA;
    }

    public double getTax(){
        return Tax;
    }
    public int getValue() {
        return value;
    }

    public double getDiscountValue() {
        return valueDiscount;
    }

    public static void main(String[] args) {
        int value = Integer.parseInt((JOptionPane.showInputDialog("Enter the value of the purchase:")));
        int age = Integer.parseInt((JOptionPane.showInputDialog("Enter your age:")));
        boolean club = JOptionPane.showInputDialog("Do you belong to the VIP Club? (yes/no):").equalsIgnoreCase("yes");

        SuperMarket superMarket = new SuperMarket(value, age, club);

        JOptionPane.showMessageDialog(null, "Original value: $" + superMarket.getValue());
        JOptionPane.showMessageDialog(null, "VIP: " + superMarket.getClubStatus());
        JOptionPane.showMessageDialog(null, "Value with discount: $" + superMarket.getDiscountValue());
        JOptionPane.showMessageDialog(null, "IVA: $" + superMarket.getIVA());
        JOptionPane.showMessageDialog(null, "Value with IVA: $" + superMarket.getValueWithIVA());
        JOptionPane.showMessageDialog(null,"Value total of the purchase: $"+superMarket.getValueWithIVA());
        JOptionPane.showMessageDialog(null,"Thanks for your purchase! :)");
    }
}
