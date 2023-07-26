/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorimg;

import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;

/**
 *
 * @author pc
 */
public class HiloProcesamientoImagen extends Thread {

    private BufferedImage imagen;
    private String efecto;
    private Vista vista;

    public HiloProcesamientoImagen() {
        imagen = null;
        efecto = "";
    }

    public HiloProcesamientoImagen(BufferedImage imagen, String efecto, Vista vista) {
        this.imagen = imagen;
        this.efecto = efecto;
        this.vista = vista;
    }

    public void run() {
        BufferedImage imagenProcesada = ProcesadorImagen.procesarImagen(imagen, efecto);
        vista.setImagenProcesada(imagenProcesada);
        vista.actualizarPanelImagen();

    }

}
