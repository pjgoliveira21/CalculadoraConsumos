import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.DecimalFormat;

public class Janela extends JFrame{
    private JPanel panel1;
    private JLabel labelDistancia;
    private JTextField inputDistancia;
    private JTextField inputConsumo;
    private JLabel labelConsumo;
    private JTextField inputPreco;
    private JLabel labelPreco;
    private JLabel labelResultado;

    public Janela() {
        this.setContentPane(this.panel1);
        this.pack();
        this.setLocation(500,250);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.revalidate();

         DocumentListener textChangeList = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                calcular();
            }
            public void removeUpdate(DocumentEvent e) {
                calcular();
            }
            public void insertUpdate(DocumentEvent e) {
                calcular();
            }

            public void calcular() {
                try {
                    double dist = Double.parseDouble(inputDistancia.getText());
                    double cons = Double.parseDouble(inputConsumo.getText());
                    double preco = Double.parseDouble(inputPreco.getText());
                    double res = dist*cons/100*preco;
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(3);
                    labelResultado.setText(df.format(res)+"€");
                } catch (Exception e) {}
            }
        };
         inputConsumo.getDocument().addDocumentListener(textChangeList);
         inputDistancia.getDocument().addDocumentListener(textChangeList);
         inputPreco.getDocument().addDocumentListener(textChangeList);
    }
}
