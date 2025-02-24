import java.util.Arrays;

/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet;
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
        alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        shifted = new char[26];
        shift = 1;
        shifter(shift);
    }

    public CaesarCipher(int num){
        alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        shifted = new char[26];
        shift = num;
        shifter(shift);
    }

    public String encrypt(String message){
        String newMessage = "";
        boolean here = false;
        for(int i = 0; i < message.length();i++)
        {
            here = false;
            for(int j = 0; j < alphabet.length; j++)
            {
                if(message.charAt(i)==alphabet[j])
                {
                    here = true;
                    newMessage += shifted[j];
                }
            }
            if(here == false)
                newMessage += message.charAt(i);
        }
        return newMessage;
    }
    

    public String decrypt(String message){
        String newMessage = "";
        boolean here = false;
        for(int i = 0; i < message.length();i++)
        {
            here = false;
            for(int j = 0; j < shifted.length; j++)
            {
                if(message.charAt(i)==shifted[j])
                {
                    here = true;
                    newMessage += alphabet[j];
                }
            }
            if(here == false)
                newMessage += message.charAt(i);
        }
        return newMessage;
    }

    public void shifter(int num){
        for(int i = 0; i < alphabet.length; i++)
        {
            if(i+num >= alphabet.length)
                shifted[(i+num)%alphabet.length] = alphabet[i];
            else
                shifted[i+num] = alphabet[i];
        }
    }
}