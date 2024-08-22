import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Projeto {
    public JTextField nome;
    public JTextField cpf;
    public JTextField textField4;
    public JTextField Profissao;
    public JComboBox<String> comboBox1;
    public JRadioButton masculinoRadioButton;
    public JRadioButton femininoRadioButton;
    public JButton cadastrarButton;
    public JPanel painel;
    String cpfCalc;


    public Projeto() {
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(cpf.getText().isEmpty())){
                    cpfCalc = cpf.getText();
                    // Remove caracteres não numéricos
                    cpfCalc = cpfCalc.replaceAll("[^0-9]", "");

                    // Verifica se o CPF tem 11 dígitos
                    if (cpfCalc.length() != 11) {
                        System.out.println("CPF " + cpfCalc + " é inválido (não possui 11 dígitos).");
                        JOptionPane.showMessageDialog(null, "CPF invalido, digite novamente!");
                        return;
                    }

                    // Verifica se todos os dígitos são iguais (o que seria inválido)
                    if (cpfCalc.matches("(\\d)\\1{10}")) {
                        System.out.println("CPF " + cpfCalc + " é inválido (todos os dígitos são iguais).");
                        JOptionPane.showMessageDialog(null, "CPF invalido, digite novamente!");
                        return;
                    }

                    // Calcula o primeiro dígito verificador
                    int sum = 0;
                    for (int i = 0; i < 9; i++) {
                        sum += (cpfCalc.charAt(i) - '0') * (10 - i);
                    }
                    int firstDigit = 11 - (sum % 11);
                    if (firstDigit >= 10) {
                        firstDigit = 0;
                    }

                    // Verifica se o primeiro dígito verificador está correto
                    if (firstDigit != (cpfCalc.charAt(9) - '0')) {
                        System.out.println("CPF " + cpfCalc + " é inválido (primeiro dígito verificador incorreto).");
                        JOptionPane.showMessageDialog(null, "CPF invalido, digite novamente!");
                        return;
                    }

                    // Calcula o segundo dígito verificador
                    sum = 0;
                    for (int i = 0; i < 10; i++) {
                        sum += (cpfCalc.charAt(i) - '0') * (11 - i);
                    }
                    int secondDigit = 11 - (sum % 11);
                    if (secondDigit >= 10) {
                        secondDigit = 0;
                    }

                    // Verifica se o segundo dígito verificador está correto
                    if (secondDigit != (cpfCalc.charAt(10) - '0')) {
                        System.out.println("CPF " + cpfCalc + " é inválido (segundo dígito verificador incorreto).");
                        JOptionPane.showMessageDialog(null, "CPF invalido, digite novamente!");
                    } else {
                        System.out.println("CPF " + cpfCalc + " é válido.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Campo CPF está em branco, digite novamente!");
                }
                if(nome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nome em branco, digite novamente!");
                }

                if(Profissao.getText().isEmpty()){
                    Profissao.setText("Desepregado(a)");
                }
            }
        });

    }


    }
