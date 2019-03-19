/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package utilitis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Julian
 */
public class RedimencionarImagen {
    
    //Ancho máximo
    public static int MAX_WIDTH=800;
    //Alto máximo
    public static int MAX_HEIGHT=600;
    
    public static void copyImage(String filePath, String copyPath, String nombre,  String fecha) {
        BufferedImage bimage = loadImage(filePath);
        bimage = resize(bimage, MAX_WIDTH, MAX_HEIGHT);
        writeData(bimage, nombre, fecha);
        saveImage(bimage, copyPath);
    }
    
    /*
    Este método se utiliza para cargar la imagen de disco
    */
    private static BufferedImage loadImage(String pathName) {
        BufferedImage bimage = null;
        try {
            bimage = ImageIO.read(new File(pathName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimage;
    }
    
    /*
    Este método se utiliza para almacenar la imagen en disco
    */
    private static void saveImage(BufferedImage bufferedImage, String pathName) {
        try {
            String format = (pathName.endsWith(".png")) ? "png" : "jpg";
            File file =new File(pathName);
            file.getParentFile().mkdirs();
            ImageIO.write(bufferedImage, format, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
    Este método se utiliza para redimensionar la imagen
    */
    private static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
    
    private static void writeData(BufferedImage bufferedImage, String nombre, String fecha){
        Graphics2D gd = bufferedImage.createGraphics();
        gd.setColor(Color.red);
        gd.drawString(nombre, 10, 550);
        gd.drawString(fecha, 10, 570);
        gd.dispose();
    }
}