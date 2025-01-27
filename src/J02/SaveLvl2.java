package J02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SaveLvl2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J02/entree.txt"));
        int nbrSafe = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            List<Integer> listLine = new ArrayList<>();
            List<Integer> streamList = Arrays.stream((line.split(" "))).map(string -> Integer.valueOf(string)).toList();
            listLine.addAll(streamList);
            TypeLigne typeLigne = TypeLigne.INCONNU;
            boolean isFirstUnsafePassed = false;
            for (int i = 0; i < listLine.size()-1; i++) {
                if (i+1 != listLine.size()-1) {
                    if (typeLigne == TypeLigne.INCONNU) {
                        // PREMIERE PASSE
                        if (listLine.get(i) > listLine.get(i + 1)) {
                            // DECROISSANT
                            if (listLine.get(i) - listLine.get(i + 1) > 3) {
                                if (!isFirstUnsafePassed) {
                                    listLine.remove(i);
                                    typeLigne = TypeLigne.INCONNU;
                                    i = 0;
                                    isFirstUnsafePassed = true;
                                } else {
                                    typeLigne = TypeLigne.TROPEQUARTE;
                                }
                            } else {
                                typeLigne = TypeLigne.DECROISSANT;
                            }
                        } else if (listLine.get(i) < listLine.get(i + 1)) {
                            // CROISSANT
                            if (listLine.get(i + 1) - listLine.get(i) > 3) {
                                if (!isFirstUnsafePassed) {
                                    listLine.remove(i);
                                    typeLigne = TypeLigne.INCONNU;
                                    i = 0;
                                    isFirstUnsafePassed = true;
                                } else {
                                    typeLigne = TypeLigne.TROPEQUARTE;
                                }
                            } else {
                                typeLigne = TypeLigne.CROISSANT;
                            }
                        } else {
                            // MEME NOMBRE
                            if (!isFirstUnsafePassed) {
                                // ERREUR TOLERÉ
                                listLine.remove(i);
                                typeLigne = TypeLigne.INCONNU;
                                i = 0;
                                isFirstUnsafePassed = true;
                            } else {
                                typeLigne = TypeLigne.STAGNANT;
                            }
                        }
                    } else if (typeLigne == TypeLigne.CROISSANT) {
                        // DEUXIEME PASSE CROISSANT
                        if (listLine.get(i) < listLine.get(i + 1)) {
                            // BON SENS
                            if (listLine.get(i + 1) - listLine.get(i) > 3) {
                                typeLigne = TypeLigne.TROPEQUARTE;
                                if (!isFirstUnsafePassed) {
                                    listLine.remove(i);
                                    typeLigne = TypeLigne.INCONNU;
                                    i = 0;
                                    isFirstUnsafePassed = true;
                                }
                            }
                        } else {
                            // CHANGEMENT DE SENS
                            if (!isFirstUnsafePassed) {
                                listLine.remove(i);
                                typeLigne = TypeLigne.INCONNU;
                                i = 0;
                                isFirstUnsafePassed = true;
                            } else {
                                typeLigne = TypeLigne.INCOHERENT;
                            }
                        }
                    } else if (typeLigne == TypeLigne.DECROISSANT) {
                        // DEUXIEME PASSE DECROISSANT
                        if (listLine.get(i) > listLine.get(i + 1)) {
                            if (listLine.get(i) - listLine.get(i + 1) > 3) {
                                typeLigne = TypeLigne.TROPEQUARTE;
                                if (!isFirstUnsafePassed) {
                                    listLine.remove(i);
                                    typeLigne = TypeLigne.INCONNU;
                                    i = 0;
                                    isFirstUnsafePassed = true;
                                }
                            }
                        } else {
                            if (!isFirstUnsafePassed) {
                                listLine.remove(i);
                                typeLigne = TypeLigne.INCONNU;
                                i = 0;
                                isFirstUnsafePassed = true;
                            } else {
                                typeLigne = TypeLigne.INCOHERENT;
                            }
                        }
                    }
                }else{
                    if (!isFirstUnsafePassed){
                        System.out.println("Clean : ");
                        nbrSafe++;
                        System.out.println(nbrSafe + " " + listLine + " " + isFirstUnsafePassed);
                    }else {

                        if (typeLigne == TypeLigne.CROISSANT) {
                            // DEUXIEME PASSE CROISSANT
                            if (listLine.get(i) < listLine.get(i + 1)) {
                                // BON SENS
                                if (listLine.get(i + 1) - listLine.get(i) > 3) {
                                    typeLigne = TypeLigne.TROPEQUARTE;
                                    if (!isFirstUnsafePassed) {
                                        listLine.remove(i);
                                        typeLigne = TypeLigne.INCONNU;
                                        i = 0;
                                        isFirstUnsafePassed = true;
                                    }
                                }
                            } else {
                                // CHANGEMENT DE SENS
                                if (!isFirstUnsafePassed) {
                                    listLine.remove(i);
                                    typeLigne = TypeLigne.INCONNU;
                                    i = 0;
                                    isFirstUnsafePassed = true;
                                } else {
                                    typeLigne = TypeLigne.INCOHERENT;
                                }
                            }
                        } else if (typeLigne == TypeLigne.DECROISSANT) {
                            // DEUXIEME PASSE DECROISSANT
                            if (listLine.get(i) > listLine.get(i + 1)) {
                                if (listLine.get(i) - listLine.get(i + 1) > 3) {
                                    typeLigne = TypeLigne.TROPEQUARTE;
                                    if (!isFirstUnsafePassed) {
                                        listLine.remove(i);
                                        typeLigne = TypeLigne.INCONNU;
                                        i = 0;
                                        isFirstUnsafePassed = true;
                                    }
                                }
                            } else {
                                if (!isFirstUnsafePassed) {
                                    listLine.remove(i);
                                    typeLigne = TypeLigne.INCONNU;
                                    i = 0;
                                    isFirstUnsafePassed = true;
                                } else {
                                    typeLigne = TypeLigne.INCOHERENT;
                                }
                            }
                        }
                        if (i + 1 == listLine.size() - 1) {
                            // DERNIERE PASSE
                            if ((typeLigne == TypeLigne.CROISSANT || typeLigne == TypeLigne.DECROISSANT)) {
                                nbrSafe++;
                                System.out.println("Clean : ");
                            } else {
                                if (!isFirstUnsafePassed) {
                                    System.out.println("Clean : ");
                                    nbrSafe++;
                                }
                            }
                            System.out.println(nbrSafe + " " + listLine + " " + isFirstUnsafePassed);

                        }
                    }
                }
            }

        }
        System.out.println(nbrSafe);
    }
}
