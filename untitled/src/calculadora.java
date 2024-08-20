import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora {
    public JTextField Valor2;
    public JTextField Valor1;
    public JRadioButton adiçãoRadioButton;
    public JRadioButton subtraçãoRadioButton;
    public JRadioButton divisãoRadioButton;
    public JRadioButton multiplicaçãoRadioButton;
    public JButton submitButton;
    public JPanel FrmPrincipal;
    Long TXTvalor1;
    Long TXTvalor2;
    Long Resultado;


    public calculadora(){

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                submitButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String textoValor1 = Valor1.getText();
                            String textoValor2 = Valor2.getText();

                            TXTvalor1 = Long.parseLong(textoValor1);
                            TXTvalor2 = Long.parseLong(textoValor2);

                            if(adiçãoRadioButton.isSelected()) Resultado = TXTvalor1 + TXTvalor2;
                            if(subtraçãoRadioButton.isSelected()) Resultado = TXTvalor1 - TXTvalor2;
                            if(multiplicaçãoRadioButton.isSelected()) Resultado = TXTvalor1 * TXTvalor2;
                            if(divisãoRadioButton.isSelected()) Resultado = TXTvalor1 / TXTvalor2;

                            JOptionPane.showMessageDialog(null,"Resultado: " + Resultado);
                        }
                    });

                System.err.println("Deu Certo!");
                JOptionPane.showMessageDialog(null, "Deu certo" );

            }
        });
    }
}
