import javax.swing.*;
public class TriangleType {
    int side1=0,side2=0,side3=0;
    public TriangleType(){

    }
    public void TriangleClassification(){
        side1 = Integer.parseInt((JOptionPane.showInputDialog("Enter the side 1")));
        side2 = Integer.parseInt((JOptionPane.showInputDialog("Enter the side 2")));
        side3 = Integer.parseInt((JOptionPane.showInputDialog("Enter the side 3")));

        if (side1 == side2 && side1 == side3 && side3 == side2){
            JOptionPane.showMessageDialog(null,"Equilatero");
        }
        else if (side1 != side2 && side1 != side3 && side2 != side3){
            JOptionPane.showMessageDialog(null,"Escaleno");
        }
        else {
            JOptionPane.showMessageDialog(null, "Isoceles");
        }
    }

    public static void main(String[] args) {
        TriangleType triangleType=new TriangleType();
        triangleType.TriangleClassification();
    }
}
