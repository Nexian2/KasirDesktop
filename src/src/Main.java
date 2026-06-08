/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;

/**
 *
 * @author Zorich
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }
            UIManager.put("Table.selectionBackground", new Color(215, 215, 215));
            UIManager.put("Table.selectionForeground", Color.BLACK);
            new KasirFrame().setVisible(true);
        });
    }
}
