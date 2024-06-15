package swingproj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Instagram {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40)); // para responsive
        frame.setTitle("Instagram");
        frame.setResizable(false);

        RoundedPanel panel = new RoundedPanel(10, new Color(0xF5F5F7), new Color(0x1D1D1F), 1); 
        panel.setPreferredSize(new Dimension(350, 450));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // para naka vertical allignment

        JLabel label = new JLabel();
        label.setText("Instagram");
        label.setBorder(new EmptyBorder(10, 0, 150, 0)); // spacing langs
        label.setFont(new Font("FSP DEMO - Blue Vinyl Bold", Font.BOLD, 50));
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        RoundedTextField textBox = new RoundedTextField(5, new Color(0xF5F5F7), new Color(0x1D1D1F), 1);
        textBox.setPreferredSize(new Dimension(220, 30));
        textBox.setMaximumSize(new Dimension(220, 30));
        textBox.setText("Username");

        RoundedTextField textBox2 = new RoundedTextField(5, new Color(0xF5F5F7), new Color(0x1D1D1F), 1);
        textBox2.setPreferredSize(new Dimension(220, 30));
        textBox2.setMaximumSize(new Dimension(220, 30));
        textBox2.setText("Password");

        RoundedButton button = new RoundedButton(); 
        button.setText("Log In");
        button.setFocusable(false);
        button.setBackground(new Color(0x87CEEB));
        button.setForeground(Color.WHITE); 
        button.setMaximumSize(new Dimension(220, 30));
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);

        RoundedPanel panel2 = new RoundedPanel(0, new Color(0xF5F5F7), new Color(0x1D1D1F), 1); 
        panel2.setPreferredSize(new Dimension(350, 50));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        JLabel label2 = new JLabel("Create new account");
        label2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label2.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        label2.setForeground(Color.BLACK); 

        panel.add(label);
        panel.add(textBox);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // space sa gitna
        panel.add(textBox2);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button);

        panel2.add(Box.createVerticalGlue()); // para naka gitna vertically
        panel2.add(label2);
        panel2.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.add(panel2);

        frame.setVisible(true);
    }

    
    static class RoundedTextField extends JTextField {
        private int radius; 
        private Color backgroundColor; 
        private Color borderColor; 
        private int borderWidth; 

        public RoundedTextField(int radius, Color backgroundColor, Color borderColor, int borderWidth) {
            super();
            this.radius = radius;
            this.backgroundColor = backgroundColor;
            this.borderColor = borderColor;
            this.borderWidth = borderWidth;
            setOpaque(false); 
            setBorder(new EmptyBorder(5, 5, 5, 5)); // spacing langs
        }

        
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create(); 
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // para smooth yung gilid gilid
            g2.setColor(backgroundColor); 
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius); 

            if (getBorder() != null) {
                g2.setColor(borderColor); 
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius); // para mag show na rounded yung border
            }

            super.paintComponent(g2); 
            g2.dispose(); 
        }

        
        @Override
        public void setBorder(Border border) {
            super.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // para maayos yung spacing ng border
        }
    }

    
    static class RoundedPanel extends JPanel { //para rounded yung panel nya
        private int radius; 
        private Color backgroundColor; 
        private Color borderColor;
        private int borderWidth; 

        public RoundedPanel(int radius, Color backgroundColor, Color borderColor, int borderWidth) {
            super();
            this.radius = radius; 
            this.backgroundColor = backgroundColor; 
            this.borderColor = borderColor; 
            this.borderWidth = borderWidth; 
            setOpaque(false); 
        }

        // Custom painting of the panel
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create(); 
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // para smooth yung edges
            g2.setColor(backgroundColor); // 
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); // para sa rectangle bg
            g2.setColor(borderColor); 
            g2.setStroke(new java.awt.BasicStroke(borderWidth)); // width ng border
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius); 
            super.paintComponent(g2); 
            g2.dispose(); 
        }
    }

    // para maging rounded borders yung button (nde ko mapagana)
    static class RoundedButton extends JButton {
        private int radius = 10; 

        public RoundedButton() {
            super();
            setContentAreaFilled(true); 
            setFocusPainted(false); 
            setBorderPainted(false); 
        }

        
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create(); 
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // para smooth yung edges
            g2.setColor(getBackground()); 
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); 

            // para sa border
            g2.setColor(getForeground()); 
            g2.setStroke(new java.awt.BasicStroke(2)); // width ng border
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius); // para magka border

            super.paintComponent(g2); 
            g2.dispose(); 
        }

        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(220, 30); // size ng button
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(220, 30); //max size ng button
        }
    }
}
