/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorimg;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class PanelImagen extends JPanel{
    
    private BufferedImage imagen;

        public void setImagen(BufferedImage imagen) {
            this.imagen = imagen;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, null);
            }
        }
    }

