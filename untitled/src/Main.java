import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame quadro = new JFrame("calculadora");
        quadro.setContentPane(new calculadora().FrmPrincipal);
        quadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quadro.pack();
        quadro.setVisible(true);
    }
}
