package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    public String text;
    public String tytul;
    public String adresStrony = " ";
    public String adresGrafiki = "adresGrafiki: ";
    public String adresMiniaturki = "adresMiniaturki: ";
    public String szerokosc;
    public String wysokosc;

    public Infografika(String text) {

        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(text);
        if (m.find()) {
            tytul = m.group(1);
            System.out.println("Tytul: " + tytul);
        } else {
            tytul = "";
            System.out.println("");
        }

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(text);
        if (m.find()) {
            adresStrony = m.group(1);
            System.out.println("Adres Strony: " + adresStrony);
        } else {
            adresStrony = "";
            System.out.println("");
        }
        pat = Pattern.compile("media:content url=\"(.*)\" type");
        m = pat.matcher(text);
        if (m.find()) {
            adresGrafiki = m.group(1);
            System.out.println("Adres Grafiki: " + adresGrafiki);
        } else
            System.out.println("");

        pat = Pattern.compile("media:thumbnail url=\"(.*)\"");
        m = pat.matcher(text);
        if (m.find()) {
            adresMiniaturki = m.group(1);
            System.out.println("Adres Miniaturki: " + adresMiniaturki);
        } else
            System.out.println("");

        pat = Pattern.compile("width=\"(.*)\" ");
        m = pat.matcher(text);
        if (m.find()) {
            szerokosc = m.group(1);

            System.out.print("Rozmiary: " + szerokosc + "x");
        } else
            System.out.println("");

     pat = Pattern.compile("height=\"(.*)\"");
        m = pat.matcher(text);
        if (m.find()){
            wysokosc = m.group(1);
        System.out.println(wysokosc);}
        else
            System.out.println("");
    }
}
