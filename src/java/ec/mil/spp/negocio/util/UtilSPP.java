package ec.mil.spp.negocio.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.codec.binary.Base64;

/**
 * Clase para administrar las utilidades del Sitema Integrado
 *
 * @author Ing. Marco Antonio Toscano Freire - martosfre - www.matoosfe.com
 */
public class UtilSPP {

    /**
     * Método para rellenar con x caracter una cadena a la izquierda
     *
     * @param cadena
     * @param numCarLLe
     * @param caracter
     * @return
     */
    public static String padLeft(String cadena, int numCarLLe, char caracter) {
        return String.format("%" + numCarLLe + "s", cadena).replace(' ', caracter);
    }

    /**
     * Método para rellenar con x caracter una cadena a la derecha
     *
     * @param cadena
     * @param numCarLLe
     * @param caracter
     * @return
     */
    public static String padRight(String cadena, int numCarLLe, char caracter) {
        return String.format("%-" + numCarLLe + "s", cadena).replace(' ', caracter);
    }

    /**
     * Método para encriptar la clave
     *
     * @param clave
     * @return
     */
    public static String encriptar(String clave) {

        String secretKey = "presidencia2015"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = clave.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            // Se necesita el jar commons-codec
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
            System.out.println("No se pudo encriptar:" + ex.getMessage());
        }
        return base64EncryptedString;
    }

    /**
     * Metodo para desincriptar la clave del usuario
     *
     * @param clave
     * @return
     * @throws Exception
     */
    public static String desencriptar(String clave) throws Exception {

        String secretKey = "presidencia205"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(clave.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            System.out.println("No se pudo desencriptar:" + ex.getMessage());
        }
        return base64EncryptedString;
    }

    /**
     * Método para enviar un mail
     *
     * @param toMail
     * @param asunto
     * @param mensaje
     * @param protocolo
     * @param autentifica
     * @return
     */
    public static String enviarEmail(String toMail, String asunto,
            String mensaje, String protocolo, boolean autentifica) throws Exception {

        String mensajeCorreo = null;
        try {
            // Sender's email ID needs to be mentioned
            final String from = "viaticos@spp.mil.ec";
            final String password = "2015Presidencia..";

            // Assuming you are sending email from localhost
            //String host = "10.10.50.11";
            String host = "mail.spp.mil.ec";

            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", 25);

            //Validación protocolo
            switch (protocolo) {
                case "SMTPS":
                    properties.put("mail.smtp.ssl.enable", true);
                    break;
                case "TLS":
                    properties.put("mail.smtp.starttls.enable", true);
                    break;
                // Es para activar el SSL (Aquí funciona)
                case "SSL":
                    properties.put("mail.smtp.socketFactory.class",
                            "javax.net.ssl.SSLSocketFactory");
                    break;
            }

            //Revisar autentificación
            Authenticator authenticator = null;
            if (autentifica) {
                properties.put("mail.smtp.auth", true);
                authenticator = new Authenticator() {
                    private PasswordAuthentication pa = new PasswordAuthentication(from,
                            password);

                    @Override
                    public PasswordAuthentication getPasswordAuthentication() {
                        return pa;
                    }
                };
            }

            // Get the default Session object.
            Session session = Session.getInstance(properties, authenticator);

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toMail));

            // Set Subject: header field
            message.setSubject(asunto);

            // Now set the actual message
            message.setText(mensaje);

            // Send message
            Transport.send(message);

            mensajeCorreo = "Email enviado correctamente, revise su correo institucional.";
        } catch (MessagingException mex) {
            throw new Exception("Error al enviar el mail:" + mex.getMessage());
        }
        return mensajeCorreo;
    }

    /**
     * Método para generar una clave randómica
     *
     * @param numRan
     * @return
     */
    public static String generarClave(int numRan) {

        String semilla = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!.?¡¿";

        StringBuilder claveGen = new StringBuilder();

        for (int i = 0; i < numRan; i++) {
            claveGen.append(semilla.charAt((int) (Math.random()
                    * semilla.length())));
        }
        return claveGen.toString().trim();
    }

    public static Boolean validarCedula(String ced) throws Exception {
        int digVer;
        int dig;
        int coef;
        int acum = 0;
        Boolean sw = true;
        try {
            if (ced.length() == 10) {
                for (int i = 0; i < 9; i++) {
                    if (sw) {
                        coef = 2;
                        sw = false;
                    } else {
                        coef = 1;
                        sw = true;
                    }
                    dig = Integer.parseInt(ced.substring(i, i + 1)) * coef;
                    if (dig > 9) {
                        dig = dig - 9;
                    }
                    acum = acum + dig;
                }
                if ((acum % 10) == 0) {
                    digVer = 0;
                } else {
                    digVer = (((acum / 10) + 1) * 10) - acum;
                }
                if (String.valueOf(digVer).equalsIgnoreCase(ced.substring(9))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Cédula incorrecta:" + e.getMessage());
        }
    }
}

