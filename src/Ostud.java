import java.util.Scanner;


public class Ostud {

    public static void tühimaaOst(int kogus) {
        int tühiSumma = 0;
        for (int i = 0; i < kogus; i++) {
            tühiSumma += (int) (Main.tühiMaa.getAlgHind() * Math.pow(1.1, Main.tühiMaa.getMaa() + i));
        }

        if (tühiSumma >= Main.getRaha()) {
            System.out.println(tühiSumma);
            System.out.println(Main.getRaha());
            System.out.println("Pole piisavalt raha tehinguks");
            System.out.println("Puudu jääb: " + (tühiSumma - Main.getRaha()) + "eurot.");
        } else {
            Main.payDay(-tühiSumma);
            Main.tühiMaa.addMaa(kogus);
        }

    }

    public static void karjamaaOst(int kogus) {

        if (kogus <= Main.tühiMaa.getMaa()) {

            int karjamaaSumma = 0;

            for (int i = 0; i < kogus; i++) {
                karjamaaSumma += (int) (Main.karjaMaa.getAlgHind() * Math.pow(1.1, Main.karjaMaa.getMaa() + i));
            }
            System.out.println(karjamaaSumma);
            if (karjamaaSumma > Main.getRaha()) {
                System.out.println("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (karjamaaSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - Tühi maa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-karjamaaSumma);
                        Main.karjaMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    }

                    else if (tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }

                    else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }

                }
            }
        } else {
            System.out.println("Pole piisavalt maad, mida muuta!");
        }
    }

    public static void põllumaaOst(int kogus) {

        if (kogus <= Main.tühiMaa.getMaa() && kogus > Main.karjaMaa.getMaa()) {

            int põllumaaSumma = 0;
            for (int i = 0; i < kogus; i++) {
                põllumaaSumma += (int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i));
            }

            if (põllumaaSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (põllumaaSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - Tühi maa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-põllumaaSumma);
                        Main.põlluMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    }
                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }

                    else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }
                }
            }
        } else if (kogus > Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa()) {

            int põllumaaSumma = 0;
            for (int i = 0; i < kogus; i++) {
                põllumaaSumma += (int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i));
            }

            if (põllumaaSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (põllumaaSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - Karjamaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-põllumaaSumma);
                        Main.põlluMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    }
                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }

                    else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }
                }
            }
        } else if (kogus <= Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa()) {

            int põllumaaSumma = 0;
            for (int i = 0; i < kogus; i++) {
                põllumaaSumma += (int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i));
            }

            if (põllumaaSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (põllumaaSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - Tühi maa, karjamaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-põllumaaSumma);
                        Main.põlluMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-põllumaaSumma);
                        Main.põlluMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;

                    }
                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }

                    else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }
                }
            }
        } else {
            System.out.println("Pole piisavalt maad, mida muuta!");
        }
    }

    public static void hotelliOst(int kogus) {

        if (kogus <= Main.tühiMaa.getMaa() && kogus > Main.karjaMaa.getMaa() && kogus > Main.põlluMaa.getMaa()){

            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
            hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
        }

            if (hotelliSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            }

            else{
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - Tühi maa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    }
                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }

                    else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }


                }
            }
        }

        else if (kogus > Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa() && kogus > Main.põlluMaa.getMaa()) {

            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
            }

            if (hotelliSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - karjamaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    }
                    else if (tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }

                    else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }

                }
            }
        }

       else if (kogus > Main.tühiMaa.getMaa() && kogus > Main.karjaMaa.getMaa() && kogus <= Main.põlluMaa.getMaa()) {

            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
            }

            if (hotelliSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - põllumaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("põllu")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.põlluMaa.addMaa(-kogus);
                        break;
                    }
                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }
                    else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }
                }
            }
        }

       else if (kogus <= Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa() && kogus > Main.põlluMaa.getMaa()){

            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
            }

            if (hotelliSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            }

            else{
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - Tühi maa, karjamaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();

                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    }
                    else if(tüüp.toLowerCase().contains("karja")){
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    }

                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }


                    else {

                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");

                    }

                }

            }

        }

       else if (kogus <= Main.tühiMaa.getMaa() && kogus > Main.karjaMaa.getMaa() && kogus <= Main.põlluMaa.getMaa()){

            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
            }

            if (hotelliSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            }

            else{
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - Tühi maa, põllumaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();

                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    }
                    else if(tüüp.toLowerCase().contains("põllu")){
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.põlluMaa.addMaa(-kogus);
                        break;
                    }

                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }
                    else {

                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");

                    }

                }

            }

        }

       else if (kogus > Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa() && kogus <= Main.põlluMaa.getMaa()){

            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
            }

            if (hotelliSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            }

            else{
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - karjamaa, põllumaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();

                    if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    }
                    else if(tüüp.toLowerCase().contains("põllu")){
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.põlluMaa.addMaa(-kogus);
                        break;
                    }

                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }



                    else {

                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");

                    }

                }

            }

        }

       else if (kogus <= Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa() && kogus <= Main.põlluMaa.getMaa()){

            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
            }

            if (hotelliSumma > Main.getRaha()) {
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            }

            else{
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - Tühi maa, karjamaa, põllumaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();

                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    }
                    else if(tüüp.toLowerCase().contains("karja")){
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    }

                    else if (tüüp.toLowerCase().contains("põllu")){
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.põlluMaa.addMaa(-kogus);
                        break;
                    }

                    else if(tüüp.toLowerCase().contains("exit")){
                        Menu.menu();
                        break;
                    }


                    else {

                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");

                    }

                }

            }

        }

        else{
            System.out.println("Pole piisavalt maad, mida muuta!");
        }
    }
}
