/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author guille
 */
public class Config {
    private  String URL;
    private  String PASSWORD;
    private  String USER;
    private  String PUERTO_CONEXION;
    private  String PATH_BARCODE;
    private  Properties p= new Properties();

    public Config() {
        getConfig();
    }

    public String getURL() {
        return URL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getUSER() {
        return USER;
    }

    public String getPUERTO_CONEXION() {
        return PUERTO_CONEXION;
    }

    public String getPATH_BARCODE() {
        return PATH_BARCODE;
    }
   
    private void getConfig(){
        InputStream archivoConfig;
        try {
            archivoConfig =new FileInputStream("src/main/config.properties");
            p.load(archivoConfig);
            URL=p.getProperty("URL");
            PASSWORD=p.getProperty("PASSWORD");
            USER=p.getProperty("USER");
            PUERTO_CONEXION=p.getProperty("PUERTO_CONEXION");
            PATH_BARCODE=p.getProperty("PATH_BARCODE");
            
          
        } catch (Exception e) {
        }
    }
    
}
