import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {
    public JPanel p;

    public double current = 0, memory;
    public int dotDigits = 0;
    public String a = "n"; // s, e, n

    public JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    public JButton equalsButton, sumButton, c, dotButton, circButton, bFact, bExp;
    public JLabel text;

    public static void main(String[] args) {
        try {
            Main frame = new Main();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        b7 = new JButton("7");
        b7.setBounds(50, 100, 60, 60);
        p.add(b7);
        b7.addActionListener(this);

        b8 = new JButton("8");
        b8.setBounds(120, 100, 60, 60);
        p.add(b8);
        b8.addActionListener(this);

        b9 = new JButton("9");
        b9.setBounds(190, 100, 60, 60);
        p.add(b9);
        b9.addActionListener(this);

        b4 = new JButton("4");
        b4.setBounds(50, 170, 60, 60);
        p.add(b4);
        b4.addActionListener(this);

        b5 = new JButton("5");
        b5.setBounds(120, 170, 60, 60);
        p.add(b5);
        b5.addActionListener(this);

        b6 = new JButton("6");
        b6.setBounds(190, 170, 60, 60);
        p.add(b6);
        b6.addActionListener(this);

        b1 = new JButton("1");
        b1.setBounds(50, 240, 60, 60);
        p.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("2");
        b2.setBounds(120, 240, 60, 60);
        p.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("3");
        b3.setBounds(190, 240, 60, 60);
        p.add(b3);
        b3.addActionListener(this);

        b0 = new JButton("0");
        b0.setBounds(50, 310, 60, 60);
        p.add(b0);
        b0.addActionListener(this);

        sumButton = new JButton("+");
        sumButton.setBounds(120, 310, 60, 60);
        p.add(sumButton);
        sumButton.addActionListener(this);

        equalsButton = new JButton("=");
        equalsButton.setBounds(190, 310, 60, 60);
        p.add(equalsButton);
        equalsButton.addActionListener(this);

        c = new JButton("C");
        c.setBounds(260, 310, 60, 60);
        p.add(c);
        c.addActionListener(this);

        dotButton = new JButton(".");
        dotButton.setBounds(50, 380, 60, 60);
        p.add(dotButton);
        dotButton.addActionListener(this);

        circButton = new JButton("Circum");
        circButton.setBounds(120, 380, 60, 60);
        p.add(circButton);
        circButton.addActionListener(this);

        bFact = new JButton("!");
        bFact.setBounds(190, 380, 60, 60);
        p.add(bFact);
        bFact.addActionListener(this);

        bExp = new JButton("Exp");
        bExp.setBounds(260, 380, 60, 60);
        p.add(bExp);
        bExp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object pressedButton = ev.getSource();

        {
        if (pressedButton == b0) {
            if (dotDigits == 0) {
                current = current * 10;
            } else if (dotDigits < 10) {
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b1) {
            if (dotDigits == 0) {
                current = current * 10 + 1;
            } else if (dotDigits < 10) {
                current = current + 1 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b2) {
            if (dotDigits == 0) {
                current = current * 10 + 2;
            } else if (dotDigits < 10) {
                current = current + 2 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b3) {
            if (dotDigits == 0) {
                current = current * 10 + 3;
            } else if (dotDigits < 10) {
                current = current + 3 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b4) {
            if (dotDigits == 0) {
                current = current * 10 + 4;
            } else if (dotDigits < 10) {
                current = current + 4 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b5) {
            if (dotDigits == 0) {
                current = current * 10 + 5;
            } else if (dotDigits < 10) {
                current = current + 5 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b6) {
            if (dotDigits == 0) {
                current = current * 10 + 6;
            } else if (dotDigits < 10) {
                current = current + 6 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b7) {
            if (dotDigits == 0) {
                current = current * 10 + 7;
            } else if (dotDigits < 10) {
                current = current + 7 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b8) {
            if (dotDigits == 0) {
                current = current * 10 + 8;
            } else if (dotDigits < 10) {
                current = current + 8 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
        if (pressedButton == b9) {
            if (dotDigits == 0) {
                current = current * 10 + 9;
            } else if (dotDigits < 10) {
                current = current + 9 * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        };
    }

    {
        if (pressedButton == sumButton) {
            if (a.equals("s")) {
                memory = current + memory;
            }
            if (a.equals("e")) {
                memory = calculatee(current, memory);
            }
            if (a.equals("n")) {
                memory = current;
            }
            current = 0;
            dotDigits = 0;
            text.setText(String.valueOf(current));
            a = "s";
        }

        if (pressedButton == bExp) {
            if (a.equals("s")) {
                memory = current + memory;
            }
            if (a.equals("e")) {
                memory = calculatee(current, memory);
            }
            if (a.equals("n")) {
                memory = current;
            }
            current = 0;
            dotDigits = 0;
            text.setText(String.valueOf(current));
            a = "e";
        }
    }

        if (pressedButton == equalsButton) {
            if (a.equals("s")) {
                current = current + memory;
                text.setText(String.valueOf(current));
                a = "n";
                dotDigits = String.valueOf(current).split("\\.")[1].length() + 1;
            }
            if (a.equals("e")) {
                current = calculatee(current, memory);
                text.setText(String.valueOf(current));
                a = "n";
                dotDigits = String.valueOf(current).split("\\.")[1].length() + 1;
            }
        }

        if (pressedButton == c) {
            current = 0;
            dotDigits = 0;
            a = "n";
            text.setText(String.valueOf(current));
        }

        if (pressedButton == dotButton) {
            if (dotDigits < 10) {
                dotDigits++;
                text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
            }
        }

        if (pressedButton == circButton) {
            current = 3.14159 * 2 * current;
            text.setText(String.valueOf(current));
            a = "n";
            dotDigits = String.valueOf(current).split("\\.")[1].length() + 1;
        }

        if (pressedButton == bFact) {
            current = calculatef(current);
            a = "n";
            dotDigits = 0;
            text.setText(String.format("%." + (dotDigits == 0 ? 0 : dotDigits - 1) + "f", current));
        }
    }

        ;

    /**
     * 
     * @param n
     * @return n!
     */
    public int calculatef(double n) {
        if (n % 1 != 0) throw new RuntimeException("n is not natural");
        if (n < 0) throw new RuntimeException("n is negative");
        int r = 1;
        for (int i = 2; i <= n; i++) {
            r*= i;
        }
        return r;
    }

    public double calculatee(double b, double e) {
        if (e % 1 != 0 || e < 0) throw new RuntimeException("e is not natural");
        if (b == 0 && e == 0) throw new RuntimeException("0^0 is undefined");

        double r = b;
        for (int i = 1; i < e; i++) r *= b;
        return r;
    }
}
