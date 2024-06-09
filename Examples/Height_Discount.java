import javax.swing.*;

public class Height_Discount {
    int height = 0, price = 0;
    double discount = 0;
    public Height_Discount(int price, int height){
        this.price = price;
        this.height = height;
        Classification();
    }
    public void Classification(){

        if (height <= 150){
            JOptionPane.showMessageDialog(null, "Classification: Little, you get a discount of 10%");
            discount = price - (price * 0.1);
        }
        else if (height <= 170){
            JOptionPane.showMessageDialog(null,"Classification: Medium, you get a discount of 25%");
            discount = price - (price * 0.25);
        }
        else if (height <= 180){
            JOptionPane.showMessageDialog(null, "Classification: High, you get a discount of 32%");
            discount = price - (price * 0.32);
        }
        else if (height <= 190){
            JOptionPane.showMessageDialog(null, "Classification: Giant, you get a discount of 47%");
            discount = price - (price * 0.47);
        }
        else {
            JOptionPane.showMessageDialog(null, "Classification: Goliath, you get a discount of 58%");
            discount = price - (price * 0.58);
        }
    }

    public String getClassification() {
        if (height <= 150) {
            return "Little";
        } else if (height <= 170) {
            return "Medium";
        } else if (height <= 180) {
            return "High";
        } else if (height <= 190) {
            return "Giant";
        } else {
            return "Goliath";
        }
    }

    public double getDiscount() {
        return discount;
    }
    public int getPrice() {
        return price;
    }

    public static void main(String[] args) {
        int height = Integer.parseInt((JOptionPane.showInputDialog("Enter the height of the people in cm")));
        int price = Integer.parseInt((JOptionPane.showInputDialog("Enter the price of the purchase")));
        Height_Discount heightDiscount = new Height_Discount(price, height);

        JOptionPane.showMessageDialog(null, "Price of the purchase: "+heightDiscount.getPrice());
        JOptionPane.showMessageDialog(null, "Discount: "+ (price - heightDiscount.getDiscount()));
        JOptionPane.showMessageDialog(null, "Price with discount: "+heightDiscount.getDiscount());
        JOptionPane.showMessageDialog(null, "Classification: " + heightDiscount.getClassification());
    }
}
