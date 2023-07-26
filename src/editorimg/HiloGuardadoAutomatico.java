/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorimg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pc
 */
public class HiloGuardadoAutomatico extends Thread{
    
    private BufferedImage imagenProcesada;
    private Vista vista;

    public HiloGuardadoAutomatico(BufferedImage imagenProcesada, Vista vista) {
        this.imagenProcesada = imagenProcesada;
        this.vista = vista;
    }

    public void run() {
         while (true) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedImage imagenProcesada = vista.getImagenProcesada();
        if (imagenProcesada != null) {
            try {
                File outputFile = new File("imagen_procesada.jpg");
                ImageIO.write(imagenProcesada, "jpg", outputFile);
                System.out.println("Imagen guardada: " + outputFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }
}
