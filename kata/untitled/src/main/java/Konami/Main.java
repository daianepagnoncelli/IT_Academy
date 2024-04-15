package Konami;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static char[] KONAMI = new char[] { 38, 38, 40, 40, 37, 39, 37, 39, 66, 65, 10 };
    public static int[] buffer = new int[KONAMI.length];
    public static char[] charBuffer = new char[KONAMI.length];
    public static Map<Integer, Character> chars = new HashMap<>();
    public static int i = 0;

    static class Konami extends JFrame implements KeyListener {
        JLabel l;
        JLabel r;

        Konami() {
            setSize(600, 200);
            setLayout(null);
            setVisible(true);

            chars.put(0, ' ');
            chars.put(38, '↑');
            chars.put(40, '↓');
            chars.put(37, '←');
            chars.put(39, '→');
            chars.put(66, 'b');
            chars.put(65, 'a');
            chars.put(10, '↵');

            l = new JLabel();
            r = new JLabel();
            l.setFont(new Font("Mono", Font.PLAIN, 24));
            r.setFont(new Font("Mono", Font.PLAIN, 24));
            l.setBounds(20, 50, 600, 30);
            r.setBounds(20, 100, 500, 30);

            add(l);
            add(r);
            addKeyListener(this);

            l.setText(convertBuffer());
        }

        private String convertBuffer(){
            for(int i = 0; i < buffer.length; i++){
                charBuffer[i] = chars.getOrDefault(buffer[i], (char)buffer[i]);
            }

            return Arrays.toString(charBuffer);
        }

        private void checkKonami(int keyCode) throws IOException {
            if(i>=KONAMI.length) {
                scrollBuffer();
                buffer[KONAMI.length - 1] = keyCode;
            } else {
                buffer[i++] = keyCode;
            }
        }

        private static boolean konamiPressed() {
            for(int i = 0; i < KONAMI.length; i++){
                if(buffer[i] != KONAMI[i])
                    return false;
            }
            return true;
        }

        private static void scrollBuffer() {
            for(int i = 0; i < KONAMI.length-1; i++){
                buffer[i] = buffer[i+1];
            }
            buffer[KONAMI.length-1] = 0;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            try {
                checkKonami(e.getKeyCode());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            l.setText(convertBuffer());

            if(konamiPressed()){
                r.setText("you're cool!");
            } else {
                r.setText("");
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    public static void main(String[] args) throws IOException {
        new Konami();
    }
}





