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

        tipInc.addActionListener(this);
        tipDecButton.addActionListener(this);
        numPeopleDec.addActionListener(this);
        numPeopleInc.addActionListener(this);

    }

    public void calculate(){
        calculator.setBill(Double.parseDouble(billField.getText()));
        calculator.setTipPercentage(Integer.parseInt(tipField.getText()));
        calculator.setNumberOfPeople(Integer.parseInt(numPeopleField.getText()));
        System.out.println(numPeopleField.getText());
        totalPpl.setText(String.format("Total: %.2f", calculator.totalPerPerson()));
        System.out.println(calculator.totalBill());
        tipTotal.setText(String.format("Tip: %.2f", calculator.tipPerPerson()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if (button.equals(tipInc)) {
            int myTip = Integer.parseInt(tipField.getText());
            int tip = myTip + 1;
            tipField.setText("" + tip);
        } else if (button.equals(tipDecButton)) {
            int myTip = Integer.parseInt(tipField.getText());
            int tip = myTip - 1;
            tipField.setText("" + tip);
        } else if (button.equals(numPeopleInc)) {
            int myPpl = Integer.parseInt(numPeopleField.getText());
            int totPpl = myPpl + 1;
            numPeopleField.setText("" + totPpl);
        } else if (button.equals(numPeopleDec)) {
            int myPpl = Integer.parseInt(numPeopleField.getText());
            int totPpl = myPpl - 1;
            numPeopleField.setText("" + totPpl);
        }

        calculate();
    }

    @Override
    public void keyTyped(KeyEvent e) {
calculate();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
