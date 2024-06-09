import javax.swing.*;

public class RockPaperScissors {
    int player1=0, player2=0, tie = 0,games = 0,player1W=0,player2W=0;;
    String decision="yes";

    public void Game(){

        while(decision.equals("yes")){
            int player1 = Integer.parseInt((JOptionPane.showInputDialog("👤 Player 1:\nWhat do you want to select?\n1.Rock\n2.Paper\n3.Scissors")));
            int player2 = Integer.parseInt((JOptionPane.showInputDialog("👤 Player 2:\nWhat do you want to select?\n1.Rock\n2.Paper\n3.Scissors")));

            if (player1 == player2){
                JOptionPane.showMessageDialog(null,"Tie");
                tie++;
            } else if ((player1 == 1 && player2 == 3)||(player1 == 2 && player2 == 1)||(player1 == 3 && player2 == 2)) {
                player1W++;
                JOptionPane.showMessageDialog(null,"👤Player 1 Win 🏆\n👤Player 2 Loses 🏳️");
            }else {
                player2W++;
                JOptionPane.showMessageDialog(null,"👤Player 1 Loses 🏳️\n👤Player 2 Win 🏆");
            }
            games++;
            decision = JOptionPane.showInputDialog("Do you want play?(yes/no)");
        }
        JOptionPane.showMessageDialog(null,"👤 Player 1 Games Win: "+player1W);
        JOptionPane.showMessageDialog(null,"👤 Player 2 Games Win: "+player2W);
        JOptionPane.showMessageDialog(null,"Ties: "+tie);
        JOptionPane.showMessageDialog(null,"🚩 Total Games: "+games);
        JOptionPane.showMessageDialog(null,"Thanks for played :)");

    }

    public static void main(String[] args) {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        rockPaperScissors.Game();

    }
}
