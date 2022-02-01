import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {


        //Definimos un texto a cifrar

        //Instanciamos la clase
        Rsa rsa = new Rsa();

        //Generamos un par de claves
        //Admite claves de 512, 1024, 2048 y 4096 bits
        rsa.genKeyPair(512);


        String file_private = "./ClavePrivada.txt";
        String file_public = "./ClavePublica.txt";

        //Las guardamos asi podemos usarlas despues
        //a lo largo del tiempo
        rsa.saveToDiskPrivateKey("./ClavePrivada.txt");
        rsa.saveToDiskPublicKey("./ClavePublica.txt");

        //Ciframos y e imprimimos, el texto cifrado
        //es devuelto en la variable secure
        String secure = rsa.Encrypt("./ciframe");

        System.out.println("\nCifrado:");
        System.out.println(secure);

        System.out.println("enter para seguir, se puede ver la clave privada en el fichero");
        Scanner scaner = new Scanner(System.in);
        scaner.nextLine();

        //A modo de ejemplo creamos otra clase rsa
        Rsa rsa2 = new Rsa();

        //A diferencia de la anterior aca no creamos
        //un nuevo par de claves, sino que cargamos
        //el juego de claves que habiamos guadado
        rsa2.openFromDiskPrivateKey("./ClavePrivada.txt");
        rsa2.openFromDiskPublicKey("./ClavePublica.txt");

        //Le pasamos el texto cifrado (secure) y nos
        //es devuelto el texto ya descifrado (unsecure)
        String unsecure = rsa2.Decrypt(secure);

        //Imprimimos
        System.out.println("\nDescifrado:");
        System.out.println(unsecure);



    }



}