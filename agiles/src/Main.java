import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Simple Swing calculator.
 *
 * Issue #1: refactor input handling (digits + display formatting).
 * Issue #2: add SUB (-) and MUL (*) operations and replace the string-based
 * operation flag with an enum for clearer gitflow-sized changes.
 */
public class Main extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    public JPanel p;

    // Current value being typed
    public double current = 0;

    // Stored value for pending operation
    public double memory = 0;

    /**
     * Decimal mode:
     * - 0 => no decimal point typed
     * - 1 => decimal point typed, no decimal digits yet
     * - 2..10 => number of decimal digits typed is (dotDigits - 1)
     */
    public int dotDigits = 0;

    private enum Op {
        NONE, ADD, SUB, MUL, EXP
    }

    private Op pending = Op.NONE;

    // Buttons
    public JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    public JButton equalsButton, addButton, subButton, mulButton, c, dotButton, circButton, bFact, bExp;
    public JLabel text;

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }

    public Main() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);

        p = new JPanel();
        p.setLayout(null);
        setContentPane(p);

        text = new JLabel("0");
        text.setHorizontalAlignment(4);
        text.setBounds(50, 20, 300, 50);
        p.add(text);

        // Digits
        b7 = makeButton("7", 50, 100);
        b8 = makeButton("8", 120, 100);
        b9 = makeButton("9", 190, 100);

        b4 = makeButton("4", 50, 170);
        b5 = makeButton("5", 120, 170);
        b6 = makeButton("6", 190, 170);

        b1 = makeButton("1", 50, 240);
        b2 = makeButton("2", 120, 240);
        b3 = makeButton("3", 190, 240);

        b0 = makeButton("0", 50, 310);

        // New operations (Issue #2)
        addButton = makeButton("+", 120, 310);
        equalsButton = makeButton("=", 190, 310);
        c = makeButton("C", 260, 310);

        subButton = makeButton("-", 260, 100);
        mulButton = makeButton("*", 260, 170);

        dotButton = makeButton(".", 50, 380);
        circButton = makeButton("Circum", 120, 380);
        bFact = makeButton("!", 190, 380);
        bExp = makeButton("Exp", 260, 380);

        updateDisplay();
    }

    private JButton makeButton(String label, int x, int y) {
        JButton b = new JButton(label);
        b.setBounds(x, y, 60, 60);
        p.add(b);
        b.addActionListener(this);
        return b;
    }

    private void pressDigit(int digit) {
        if (dotDigits == 0) {
            current = current * 10 + digit;
        } else if (dotDigits < 10) {
            current = current + digit * Math.pow(10, -dotDigits);
            dotDigits++;
        }
        updateDisplay();
    }

    private void pressDot() {
        if (dotDigits == 0) {
            dotDigits = 1;
        }
        updateDisplay();
    }

    private void clearAll() {
        current = 0;
        memory = 0;
        dotDigits = 0;
        pending = Op.NONE;
        updateDisplay();
    }

    private int decimalsTyped() {
        return (dotDigits == 0) ? 0 : Math.max(0, dotDigits - 1);
    }

    private void updateDisplay() {
        int dec = decimalsTyped();
        text.setText(String.format("%." + dec + "f", current));
    }

    private void setCurrentFromOperationResult(double value) {
        current = value;
        String s = String.valueOf(value);
        int dot = s.indexOf('.');
        if (dot < 0 || s.contains("E") || s.contains("e")) {
            dotDigits = 0;
        } else {
            int decimals = s.length() - dot - 1;
            decimals = Math.min(decimals, 9);
            dotDigits = (decimals == 0) ? 0 : (decimals + 1);
        }
        updateDisplay();
    }

    private double apply(Op op, double left, double right) {
        switch (op) {
            case ADD: return left + right;
            case SUB: return left - right;
            case MUL: return left * right;
            case EXP: return calculatee(left, right);
            case NONE:
            default:  return right;
        }
    }

    private void pressOperation(Op nextOp) {
        if (pending == Op.NONE) {
            memory = current;
        } else {
            memory = apply(pending, memory, current);
        }
        current = 0;
        dotDigits = 0;
        pending = nextOp;
        updateDisplay();
    }

    private void pressEquals() {
        if (pending == Op.NONE) return;
        double result = apply(pending, memory, current);
        pending = Op.NONE;
        memory = 0;
        setCurrentFromOperationResult(result);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object pressedButton = ev.getSource();

        // Digits
        if (pressedButton == b0) { pressDigit(0); return; }
        if (pressedButton == b1) { pressDigit(1); return; }
        if (pressedButton == b2) { pressDigit(2); return; }
        if (pressedButton == b3) { pressDigit(3); return; }
        if (pressedButton == b4) { pressDigit(4); return; }
        if (pressedButton == b5) { pressDigit(5); return; }
        if (pressedButton == b6) { pressDigit(6); return; }
        if (pressedButton == b7) { pressDigit(7); return; }
        if (pressedButton == b8) { pressDigit(8); return; }
        if (pressedButton == b9) { pressDigit(9); return; }

        // Dot / clear
        if (pressedButton == dotButton) { pressDot(); return; }
        if (pressedButton == c) { clearAll(); return; }

        // Operations
        if (pressedButton == addButton) { pressOperation(Op.ADD); return; }
        if (pressedButton == subButton) { pressOperation(Op.SUB); return; }
        if (pressedButton == mulButton) { pressOperation(Op.MUL); return; }
        if (pressedButton == bExp) { pressOperation(Op.EXP); return; }

        if (pressedButton == equalsButton) { pressEquals(); return; }

        // Extra functions (kept from base)
        if (pressedButton == circButton) {
            setCurrentFromOperationResult(3.14159 * 2 * current);
            pending = Op.NONE;
            return;
        }

        if (pressedButton == bFact) {
            current = calculatef(current);
            pending = Op.NONE;
            dotDigits = 0;
            updateDisplay();
            return;
        }
    }

    /** @return n! (only natural numbers) */
    public int calculatef(double n) {
        if (n % 1 != 0) throw new RuntimeException("n is not natural");
        if (n < 0) throw new RuntimeException("n is negative");
        int r = 1;
        for (int i = 2; i <= n; i++) r *= i;
        return r;
    }

    /**
     * Integer exponentiation (only natural exponent).
     * @return b^e
     */
    public double calculatee(double b, double e) {
        if (e % 1 != 0 || e < 0) throw new RuntimeException("e is not natural");
        if (b == 0 && e == 0) throw new RuntimeException("0^0 is undefined");

        if (e == 0) return 1;

        double r = b;
        for (int i = 1; i < e; i++) r *= b;
        return r;
    }
}
