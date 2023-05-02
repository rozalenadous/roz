import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class roz extends JFrame implements ActionListener, KeyListener{
    private JTextArea tipCalcArea;
    private JPanel panel1;
    private JLabel title;
    private JTextField billField;
    private JTextField tipField;
    private JTextField numPeopleField;
    private JLabel billLabel;
    private JLabel tipLabel;
    private JLabel numPeopleLabel;
    private JLabel totalPerLabel;
    private JTextField totalPpl;
    private JLabel tipPerLabel;
    private JTextField tipTotal;
    private JButton tipInc;
    private JButton tipDecButton;
    private JButton numPeopleInc;
    private JButton numPeopleDec;

    private TipCalculator calculator;

    public roz(){
        this.calculator = new TipCalculator(0, 0, 0);
        createUIComponents();
        createActionListeners();
    }
    private void createUIComponents() {
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tip Calculator GUI");
        setSize(400,300);
        setVisible(true);

        tipField.setText("0");
        billField.setText("0");
        numPeopleField.setText("0");
    }

    public void createActionListeners(){
        tipInc.addActionListener(this);
        tipDecButton.addActionListener(this);
        numPeopleDec.addActionListener(this);
        numPeopleInc.addActionListener(this);

        tipField.addKeyListener(this);
        billField.addKeyListener(this);
        numPeopleField.addKeyListener(this);

    }
    public void calculate(){
        calculator.setBill(Double.parseDouble(billField.getText())); // do same for tip and ppl
        calculator.setTipPercentage(Integer.parseInt(tipField.getText()));

        tipTotal.setText(String.format("Tip: %.2 (%.2f each)", calculator.calculateTip(), calculator.tipPerPerson()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
