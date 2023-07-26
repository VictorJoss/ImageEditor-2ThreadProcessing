/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorimg;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author pc
 */
public class ProcesadorImagen {
    
    public static BufferedImage procesarImagen(BufferedImage imagen, String efecto) {
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();

        BufferedImage imagenProcesada =null;
                imagenProcesada = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                Color color = new Color(imagen.getRGB(x, y));

            
                switch (efecto) {
                    case "Blanco y negro":
                        imagenProcesada.setRGB(x, y, obtenerEscalaGrises(color).getRGB());
                        break;
                    case "Invertido":
                        imagenProcesada.setRGB(x, y, obtenerInvertido(color).getRGB());
                        break;
                    case "Vintage":
                        imagenProcesada.setRGB(x, y, obtenerSepia(color).getRGB());
                        break;
                    default:
                        imagenProcesada.setRGB(x, y, color.getRGB());
                        break;
                }
            }
        }

        return imagenProcesada;
    }

    private static Color obtenerEscalaGrises(Color color) {
        int promedio = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        return new Color(promedio, promedio, promedio);
    }

    private static Color obtenerInvertido(Color color) {
        int rojo = 255 - color.getRed();
        int verde = 255 - color.getGreen();
        int azul = 255 - color.getBlue();
        return new Color(rojo, verde, azul);
    }

    private static Color obtenerSepia(Color color) {
        int rojo = (int) (color.getRed() * 0.393 + color.getGreen() * 0.769 + color.getBlue() * 0.189);
        int verde = (int) (color.getRed() * 0.349 + color.getGreen() * 0.686 + color.getBlue() * 0.168);
        int azul = (int) (color.getRed() * 0.272 + color.getGreen() * 0.534 + color.getBlue() * 0.131);

        rojo = Math.min(rojo, 255);
        verde = Math.min(verde, 255);
        azul = Math.min(azul, 255);

        return new Color(rojo, verde, azul);
    }
}
