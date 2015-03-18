import java.util.Scanner;


public class Ostud {

    public static void tühimaaOst(int kogus) {
        int tühiSumma = 0;
        int temporary = Main.tühiMaa.getAlgHind();
        for (int i = 0; i < kogus; i++) {
            tühiSumma += (int) (Main.tühiMaa.getAlgHind() * Math.pow(1.1, Main.tühiMaa.getMaa() + i));
            Main.tühiMaa.setAlgHind((int) (Main.tühiMaa.getAlgHind() * Math.pow(1.1, Main.tühiMaa.getMaa() + i)));
        }

        if (tühiSumma >= Main.getRaha()) {
            Main.tühiMaa.setAlgHind(temporary);
            System.out.println("Pole piisavalt raha tehinguks");
            System.out.println("Puudu jääb: " + (tühiSumma - Main.getRaha()) + "eurot.");
        } else {
            Main.payDay(-tühiSumma);
            Main.tühiMaa.addMaa(kogus);
        }

    }

    public static void karjamaaOst(int kogus) {

        if (kogus <= Main.tühiMaa.getMaa()) {
            int temporary = Main.karjaMaa.getAlgHind();
            int karjamaaSumma = 0;
            for (int i = 0; i < kogus; i++) {
                karjamaaSumma += (int) (Main.karjaMaa.getAlgHind() * Math.pow(1.1, Main.karjaMaa.getMaa() + i));
                Main.karjaMaa.setAlgHind((int) (Main.karjaMaa.getAlgHind() * Math.pow(1.1, Main.karjaMaa.getMaa() + i)));
            }
            if (karjamaaSumma > Main.getRaha()) {
                Main.karjaMaa.setAlgHind(temporary);
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
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {
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
            int temporary = Main.põlluMaa.getAlgHind();
            int põllumaaSumma = 0;
            for (int i = 0; i < kogus; i++) {
                põllumaaSumma += (int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i));
                Main.põlluMaa.setAlgHind((int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i)));
            }

            if (põllumaaSumma > Main.getRaha()) {
                Main.põlluMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (põllumaaSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - TÜHI maa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-põllumaaSumma);
                        Main.põlluMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }
                }
            }
        } else if (kogus > Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa()) {
            int temporary = Main.põlluMaa.getAlgHind();
            int põllumaaSumma = 0;
            for (int i = 0; i < kogus; i++) {
                põllumaaSumma += (int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i));
                Main.põlluMaa.setAlgHind((int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i)));
            }

            if (põllumaaSumma > Main.getRaha()) {
                Main.põlluMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (põllumaaSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - KARJAmaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-põllumaaSumma);
                        Main.põlluMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }
                }
            }
        } else if (kogus <= Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa()) {
            int temporary = Main.põlluMaa.getAlgHind();
            int põllumaaSumma = 0;
            for (int i = 0; i < kogus; i++) {
                põllumaaSumma += (int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i));
                Main.tühiMaa.setAlgHind((int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i)));
            }

            if (põllumaaSumma > Main.getRaha()) {
                Main.põlluMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (põllumaaSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - TÜHI maa, karjamaa");
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

                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {
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

        if (kogus <= Main.tühiMaa.getMaa() && kogus > Main.karjaMaa.getMaa() && kogus > Main.põlluMaa.getMaa()) {
            int temporary = Main.hotellMaa.getAlgHind();
            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
            }

            if (hotelliSumma > Main.getRaha()) {
                Main.hotellMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - TÜHI maa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }


                }
            }
        } else if (kogus > Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa() && kogus > Main.põlluMaa.getMaa()) {
            int temporary = Main.hotellMaa.getAlgHind();
            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
            }

            if (hotelliSumma > Main.getRaha()) {
                Main.hotellMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - KARJAmaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }

                }
            }
        } else if (kogus > Main.tühiMaa.getMaa() && kogus > Main.karjaMaa.getMaa() && kogus <= Main.põlluMaa.getMaa()) {
            int temporary = Main.hotellMaa.getAlgHind();
            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
            }

            if (hotelliSumma > Main.getRaha()) {
                Main.hotellMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - PÕLLUmaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();
                    if (tüüp.toLowerCase().contains("põllu")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.põlluMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {
                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");
                    }
                }
            }
        } else if (kogus <= Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa() && kogus > Main.põlluMaa.getMaa()) {
            int temporary = Main.hotellMaa.getAlgHind();
            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
            }

            if (hotelliSumma > Main.getRaha()) {
                Main.hotellMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - TÜHI maa, KARJAmaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();

                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {

                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");

                    }

                }

            }

        } else if (kogus <= Main.tühiMaa.getMaa() && kogus > Main.karjaMaa.getMaa() && kogus <= Main.põlluMaa.getMaa()) {
            int temporary = Main.hotellMaa.getAlgHind();
            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
            }

            if (hotelliSumma > Main.getRaha()) {
                Main.hotellMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - TÜHI maa, PÕLLUmaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();

                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("põllu")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.põlluMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {

                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");

                    }

                }

            }

        } else if (kogus > Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa() && kogus <= Main.põlluMaa.getMaa()) {
            int temporary = Main.hotellMaa.getAlgHind();
            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
            }

            if (hotelliSumma > Main.getRaha()) {
                Main.hotellMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - KARJAmaa, PÕLLUmaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();

                    if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("põllu")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.põlluMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {

                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");

                    }

                }

            }

        } else if (kogus <= Main.tühiMaa.getMaa() && kogus <= Main.karjaMaa.getMaa() && kogus <= Main.põlluMaa.getMaa()) {
            int temporary = Main.hotellMaa.getAlgHind();
            int hotelliSumma = 0;
            for (int i = 0; i < kogus; i++) {
                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
            }

            if (hotelliSumma > Main.getRaha()) {
                Main.hotellMaa.setAlgHind(temporary);
                System.out.print("Pole piisavalt raha tehinguks");
                System.out.println("Puudu jääb: " + (hotelliSumma - Main.getRaha()) + "eurot.");
            } else {
                while (true) {
                    System.out.println("Sisesta millist maad muuta: ");
                    System.out.println("Valikus - TÜHI maa, KARJAmaa, PÕLLUmaa");
                    System.out.println("Kirjuta EXIT, et kuvada menüü.");
                    Scanner sc = new Scanner(System.in);
                    String tüüp = sc.nextLine();

                    if (tüüp.toLowerCase().contains("tühi")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.tühiMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("karja")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.karjaMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("põllu")) {
                        Main.payDay(-hotelliSumma);
                        Main.hotellMaa.addMaa(kogus);
                        Main.põlluMaa.addMaa(-kogus);
                        break;
                    } else if (tüüp.toLowerCase().contains("exit")) {
                        Menu.menu();
                        break;
                    } else {

                        System.out.println("Viga!");
                        System.out.println("Ei saanud aru, millist maad muuta!");

                    }

                }

            }

        } else {
            System.out.println("Pole piisavalt maad, mida muuta!");
        }
    }
}
