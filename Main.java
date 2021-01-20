/**
 * travail pratique 1
 * inf 2120 automne 2019
 *
 * Nom et prenom : Ahmad Farhat
 * Code permanent : FARA02079604
 * Courriel: dc091075@ens.uqam.ca
 * 10 octobre 2019
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String nomFichier = Demander();
        ArrayList<Double> lesY = new ArrayList<>();
        int d = 0;

        try {
            FileReader fr = new FileReader(nomFichier);
            BufferedReader fichier = new BufferedReader(fr);
            Scanner folder = new Scanner(fichier);
            folder.useLocale(Locale.CANADA);
            if (folder.hasNextInt()) {
                d = folder.nextInt();
                Erreur(d);
            }
            while (folder.hasNextDouble()) {
                lesY.add(folder.nextDouble());
            }

        } catch (FileNotFoundException e) {
            System.err.println(Text.MSSG_ERR_FICHIER);
            System.exit(-2);
        } catch (InputMismatchException e) {
            System.err.println(Text.MSSG_ERR_DONNER);
            System.exit(-2);
        }

        echantillage(lesY , d );

    }

    /**
     * Demande l'utilisateur de rentre le nom du fichier
     * @return <>nomFichier</> le nom entre par l'utlisateur
     */
    public static String Demander() {
        String nomFichier;
        Scanner sc = new Scanner(System.in);
        System.out.print(Text.QUESTION_NOM_DU_FICHIER);
        nomFichier = sc.nextLine();
        return nomFichier;

    }

    /**
     * Affiche la valeur apres traitement sur une ligne
     * @param liste les valeurs a afficher
     */
    public static void Imprimer(ArrayList<Double> liste) {
        for (double i : liste) {
            System.out.println(i);
        }
    }

    /**
     * Verifie si le degre donner sera traiter
     * si le degre est n ' entre  pas   1 et 3 insclusiment un erreur sera lancer
     * @param degre  la valeur donner par l'utilisateur
     */
    public static void Erreur(int degre) {
        if (degre > 3 || degre < 1) {
            System.err.print(Text.MSSG_ERR_DEGRE);
            System.exit(-1);
        }
    }

    /**
     * Echantillone la fonction a chaque 0.25
     * @param lesY liste des arguments donner
     * @param d degre de la fonction
     */
    public static void echantillage(ArrayList<Double> lesY , int d){
        double h ;
        double x0 ;
        h = lesY.get(0);
        lesY.remove(0);
        x0 = lesY.get(0);
        lesY.remove(0);


        double y = 0;
        ArrayList<Double> b = new ArrayList<>();

        switch (d) {

            case 1:
                while (lesY.size() >= 2) {


                    for (double i = x0; i < x0 + h ; i = x0 + y * h) {

                        Lineaire a = new Lineaire(x0, h, lesY.get(1), lesY.get(0));

                        b.add(a.calculerY(i));

                        y = y + 0.25;

                    }
                    lesY.remove(0);
                    x0 = x0 + h;
                    y = 0;

                }
                b.add(lesY.get(0));

                break;
            case 2:
                while (lesY.size() >= 3) {


                    for (double j = x0; j < x0+h; j = x0 + y * h) {
                        Quadratique a = new Quadratique(x0, h, lesY.get(2), lesY.get(1), lesY.get(0));
                        b.add(a.calculerY(j));
                        y = y + 0.25;
                    }
                    lesY.remove(0);
                    x0 = x0 + h;
                    y = 0;

                }
                b.add(lesY.get(0));


                break;
            case 3:
                while (lesY.size() >= 4) {



                    for (double i = x0; i < x0 + h ; i = x0 + y * h) {

                        Cubique a = new Cubique(x0, h, lesY.get(3), lesY.get(2), lesY.get(1), lesY.get(0));

                        b.add(a.calculerY(i));

                        y = y + 0.25;

                    }
                    lesY.remove(0);
                    x0 = x0 + h;
                    y = 0;

                }
                b.add(lesY.get(0));

                break;
        }

        Imprimer(b);


    }


}