import model.Curso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private CursoDAO cursoDAO = new CursoDAO();

    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtSigla;
    private JComboBox<Curso.Area> cmbArea;
    private JTable tblCursos;
    private DefaultTableModel tableModel;

    public Main() {
        initComponents();
        mostrarCursos();
    }

    private void initComponents() {

        setTitle("Gerenciamento de Cursos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // Layout absoluto (você pode usar outros layouts)


        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 10, 80, 25);
        add(lblCodigo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 40, 80, 25);
        add(lblNome);

        JLabel lblSigla = new JLabel("Sigla:");
        lblSigla.setBounds(10, 70, 80, 25);
        add(lblSigla);

        JLabel lblArea = new JLabel("Área:");
        lblArea.setBounds(10, 100, 80, 25);
        add(lblArea);


        txtCodigo = new JTextField();
        txtCodigo.setBounds(100, 10, 200, 25);
        add(txtCodigo);

        txtNome = new JTextField();
        txtNome.setBounds(100, 40, 200, 25);
        add(txtNome);

        txtSigla = new JTextField();
        txtSigla.setBounds(100, 70, 200, 25);
        add(txtSigla);

        cmbArea = new JComboBox<>(Curso.Area.values());
        cmbArea.setBounds(100, 100, 200, 25);
        add(cmbArea);


        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(10, 140, 100, 25);
        add(btnAdicionar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(120, 140, 100, 25);
        add(btnAtualizar);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(230, 140, 100, 25);
        add(btnDeletar);


        String[] colunas = {"Código", "Nome", "Sigla", "Área"};
        tableModel = new DefaultTableModel(colunas, 0);
        tblCursos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblCursos);
        scrollPane.setBounds(10, 180, 560, 150);
        add(scrollPane);


        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long codigo = Long.parseLong(txtCodigo.getText());
                String nome = txtNome.getText();
                String sigla = txtSigla.getText();
                Curso.Area area = (Curso.Area) cmbArea.getSelectedItem();

                Curso curso = new Curso(codigo, nome, sigla, area);
                cursoDAO.create(curso);

                limparCampos();
                mostrarCursos();
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblCursos.getSelectedRow();
                if (selectedRow >= 0) {
                    Long codigo = Long.parseLong(txtCodigo.getText());
                    String nome = txtNome.getText();
                    String sigla = txtSigla.getText();
                    Curso.Area area = (Curso.Area) cmbArea.getSelectedItem();

                    Curso curso = new Curso(codigo, nome, sigla, area);
                    cursoDAO.update(curso);

                    limparCampos();
                    mostrarCursos();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um curso para atualizar");
                }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblCursos.getSelectedRow();
                if (selectedRow >= 0) {
                    Long codigo = (Long) tblCursos.getValueAt(selectedRow, 0);
                    cursoDAO.delete(codigo);

                    limparCampos();
                    mostrarCursos();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um curso para deletar");
                }
            }
        });

        setVisible(true);
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtSigla.setText("");
        cmbArea.setSelectedIndex(0);
    }

    private void mostrarCursos() {
        tableModel.setRowCount(0);
        for (Curso curso : cursoDAO.findAll()) {
            tableModel.addRow(new Object[]{curso.getCodigo(), curso.getNome(), curso.getSigla(), curso.getArea()});
        }
    }

    public static void main(String[] args) {
        new CursoForm();
    }
}
