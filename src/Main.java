import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    public static Maa tühiMaa = new Maa(1, 100);
    public static Maa karjaMaa = new Maa(10, 250);
    public static Maa põlluMaa = new Maa(50, 500);
    public static Maa hotellMaa = new Maa(100, 1000);
    private static int raha;

    // private static boolean pressed = false;
    //private static boolean end = false;
    //public static final Thread lõime = new Thread(new Checker());

    //public static void setEnd(boolean end) {
    //Main.end = end;
    //}

    //public static void setPressed(boolean pressed) {
    //Main.pressed = pressed;
    //}

    public static int getRaha() {
        return raha;
    }

    public static void setRaha(int raha) {
        Main.raha = raha;
    }

    public static void payDay(int x) {
        raha += x;
    }

    public static int saabOsta(int algHind, int algMaa, int kogus, int summa) {

        int raha = getRaha();
        int üheHind = algHind;
        if (summa > raha) {
            return kogus;
        } else {

            üheHind = (int) (algHind * Math.pow(1.1, algMaa));
            summa += üheHind;
            return saabOsta(üheHind, algMaa + 1, kogus + 1, summa);
        }
    }


    public void maad(HBox mainh, Label tuupMaa, Text haArv, Text haSek, Text maaSek, Text maaHind, Text saadOsta, final Text mure) {
        GridPane maa = new GridPane();

        maa.add(tuupMaa, 1, 0);
        maa.add(haArv, 1, 1);
        maa.add(new Label(" ha"), 2, 1);

        maa.add(new Label("1 ha annab: "), 0, 2);
        maa.add(haSek, 1, 2);
        maa.add(new Label(" $/sek"), 2, 2);

        maa.add(new Label("Kokku: "), 0, 3);
        maa.add(maaSek, 1, 3);
        maa.add(new Label(" $/sek"), 2, 3);

        maa.add(new Label("Uks ha maksab: "), 0, 4);
        maa.add(maaHind, 1, 4);
        maa.add(new Label(" $"), 2, 4);

        maa.add(new Label("Sul on raha, et osta: "), 0, 5);
        maa.add(saadOsta, 1, 5);
        maa.add(new Label(" ha "), 2, 5);

        if (tuupMaa.getText().equals("TUHIMAA")) {
            maa.add(new Label("Ostan "), 0, 6);

            final TextField kast = new TextField();
            kast.setPrefWidth(20);
            maa.add(kast, 1, 6);
            kast.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    mure.setText("");
                    try {
                        int kogus = Integer.parseInt(kast.getText());
                        int tühiSumma = 0;
                        int algKogus = tühiMaa.getMaa();
                        int algRaha = getRaha();
                        int temporary = Main.tühiMaa.getAlgHind();
                        for (int i = 0; i < kogus; i++) {
                            tühiSumma = (Main.tühiMaa.getAlgHind());
                            Main.tühiMaa.setAlgHind((int) (Main.tühiMaa.getAlgHind() * Math.pow(1.1, Main.tühiMaa.getMaa())));

                            if (tühiSumma > Main.getRaha()) {
                                Main.tühiMaa.setAlgHind(temporary);
                                tühiMaa.setMaa(algKogus);
                                setRaha(algRaha);
                                throw new RahaPoleException();
                            } else {
                                Main.payDay(-tühiSumma);
                                Main.tühiMaa.addMaa(1);
                            }
                        }

                    } catch (RahaPoleException rpe) {
                        mure.setText("Raha pole piisavalt");
                    } catch (NullPointerException ne) {
                        mure.setText("Vali maa ja sisesta kogus!");
                    } catch (NumberFormatException nfe) {
                        mure.setText("Vali maa ja sisesta kogus!");
                    }
                    kast.clear();
                }
            });
            maa.add(new Label(" ha "), 2, 6);

            Button ostaNupp = new Button("OSTA");
            maa.add(ostaNupp, 0, 7);

            ostaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                           @Override
                                           public void handle(MouseEvent event) {
                                               mure.setText("");
                                               try {
                                                   int kogus = Integer.parseInt(kast.getText());
                                                   int tühiSumma = 0;
                                                   int algKogus = tühiMaa.getMaa();
                                                   int algRaha = getRaha();
                                                   int temporary = Main.tühiMaa.getAlgHind();
                                                   for (int i = 0; i < kogus; i++) {
                                                       tühiSumma = (Main.tühiMaa.getAlgHind());
                                                       Main.tühiMaa.setAlgHind((int) (Main.tühiMaa.getAlgHind() * Math.pow(1.1, Main.tühiMaa.getMaa())));

                                                       if (tühiSumma > Main.getRaha()) {
                                                           Main.tühiMaa.setAlgHind(temporary);
                                                           tühiMaa.setMaa(algKogus);
                                                           setRaha(algRaha);
                                                           throw new RahaPoleException();
                                                       } else {
                                                           Main.payDay(-tühiSumma);
                                                           Main.tühiMaa.addMaa(1);
                                                       }
                                                   }

                                               } catch (RahaPoleException rpe) {
                                                   mure.setText("Raha pole piisavalt");
                                               } catch (NullPointerException ne) {
                                                   mure.setText("Vali maa ja sisesta kogus!");
                                               } catch (NumberFormatException nfe) {
                                                   mure.setText("Vali maa ja sisesta kogus!");
                                               }
                                               kast.clear();
                                           }
                                       }
            );
        } else {
            maa.add(new Label("Muudan "), 0, 6);

            final TextField kast = new TextField();
            kast.setPrefWidth(20);
            maa.add(kast, 1, 6);

            maa.add(new Label(" ha "), 2, 6);
            if (tuupMaa.getText().equals("KARJAMAA")) {
                final ChoiceBox cb = new ChoiceBox();
                cb.getItems().addAll("tuhimaa");
                maa.add(cb, 0, 7);
                Button muudaNupp = new Button("MUUDA");
                maa.add(muudaNupp, 1, 7);
                muudaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mure.setText("");
                        try {

                            int kogus = Integer.parseInt(kast.getText());

                            if (kogus <= Main.tühiMaa.getMaa()) {
                                int temporary = Main.karjaMaa.getAlgHind();
                                int karjamaaSumma = 0;
                                int algKogus = karjaMaa.getMaa();
                                int algRaha = getRaha();
                                for (int i = 0; i < kogus; i++) {
                                    karjamaaSumma += (Main.karjaMaa.getAlgHind());
                                    Main.karjaMaa.setAlgHind((int) (Main.karjaMaa.getAlgHind() * Math.pow(1.1, Main.karjaMaa.getMaa())));
                                }
                                if (karjamaaSumma > Main.getRaha()) {
                                    Main.karjaMaa.setAlgHind(temporary);
                                    karjaMaa.setMaa(algKogus);
                                    setRaha(algRaha);
                                    throw new RahaPoleException();
                                } else if (cb.getValue().equals("tuhimaa")) {
                                    Main.payDay(-karjamaaSumma);
                                    Main.karjaMaa.addMaa(1);
                                    Main.tühiMaa.addMaa(-1);
                                }
                            }

                        } catch (NullPointerException ne) {
                            mure.setText("Vali maa ja sisesta kogus!");
                        } catch (NumberFormatException nfe) {
                            mure.setText("Vali maa ja sisesta kogus!");
                        } catch (RahaPoleException r) {
                            mure.setText("Raha pole piisavalt");
                        }
                        kast.clear();
                    }
                });
            } else if (tuupMaa.getText().equals("POLLUMAA")) {
                final ChoiceBox cb = new ChoiceBox();
                cb.getItems().addAll("tuhimaa", "karjamaa");
                maa.add(cb, 0, 7);
                Button muudaNupp = new Button("MUUDA");
                maa.add(muudaNupp, 1, 7);
                muudaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mure.setText("");
                        try {
                            int kogus = Integer.parseInt(kast.getText());
                            if (cb.getValue().equals("tuhimaa") && kogus <= tühiMaa.getMaa()) {
                                int temporary = Main.põlluMaa.getAlgHind();
                                int põllumaaSumma = 0;
                                int algKogus = põlluMaa.getMaa();
                                int algRaha = getRaha();
                                for (int i = 0; i < kogus; i++) {
                                    põllumaaSumma += Main.põlluMaa.getAlgHind();
                                    Main.põlluMaa.setAlgHind((int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa())));
                                }

                                if (põllumaaSumma > Main.getRaha()) {
                                    Main.põlluMaa.setAlgHind(temporary);
                                    põlluMaa.setMaa(algKogus);
                                    setRaha(algRaha);
                                    throw new RahaPoleException();
                                } else {
                                    Main.payDay(-põllumaaSumma);
                                    Main.põlluMaa.addMaa(1);
                                    Main.tühiMaa.addMaa(-1);
                                }

                            } else if (cb.getValue().equals("karjamaa") && kogus <= karjaMaa.getMaa()) {
                                int temporary = Main.põlluMaa.getAlgHind();
                                int põllumaaSumma = 0;
                                int algKogus = põlluMaa.getMaa();
                                int algRaha = getRaha();
                                for (int i = 0; i < kogus; i++) {
                                    põllumaaSumma += Main.põlluMaa.getAlgHind();
                                    Main.põlluMaa.setAlgHind((int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa())));
                                }

                                if (põllumaaSumma > Main.getRaha()) {
                                    Main.põlluMaa.setAlgHind(temporary);
                                    põlluMaa.setMaa(algKogus);
                                    setRaha(algRaha);
                                    throw new RahaPoleException();
                                } else {
                                    Main.payDay(-põllumaaSumma);
                                    Main.põlluMaa.addMaa(kogus);
                                    Main.karjaMaa.addMaa(-kogus);
                                }

                            }
                        } catch (NullPointerException ne) {
                            mure.setText("Vali maa ja sisesta kogus!");
                        } catch (NumberFormatException nfe) {
                            mure.setText("Vali maa ja sisesta kogus!");
                        } catch (RahaPoleException r) {
                            mure.setText("Raha pole piisavalt");
                        }
                        kast.clear();
                    }
                });
            } else if (tuupMaa.getText().equals("HOTELLIMAA")) {
                final ChoiceBox cb = new ChoiceBox();
                cb.getItems().addAll("tuhimaa", "karjamaa", "pollumaa");
                maa.add(cb, 0, 7);
                Button muudaNupp = new Button("MUUDA");
                maa.add(muudaNupp, 1, 7);
                muudaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mure.setText("");
                        try {
                            int kogus = Integer.parseInt(kast.getText());
                            if (cb.getValue().equals("tuhimaa") && kogus <= tühiMaa.getMaa()) {
                                int temporary = Main.hotellMaa.getAlgHind();
                                int hotelliSumma = 0;
                                int algKogus = hotellMaa.getMaa();
                                int algRaha = getRaha();
                                for (int i = 0; i < kogus; i++) {
                                    hotelliSumma += Main.hotellMaa.getAlgHind();
                                    Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa())));
                                }

                                if (hotelliSumma > Main.getRaha()) {
                                    Main.hotellMaa.setAlgHind(temporary);
                                    hotellMaa.setMaa(algKogus);
                                    setRaha(algRaha);
                                    throw new RahaPoleException();
                                } else {
                                    Main.payDay(-hotelliSumma);
                                    Main.hotellMaa.addMaa(1);
                                    Main.tühiMaa.addMaa(-1);
                                }


                            } else if (cb.getValue().equals("karjamaa") && kogus <= karjaMaa.getMaa()) {
                                int temporary = Main.hotellMaa.getAlgHind();
                                int hotelliSumma = 0;
                                int algKogus = hotellMaa.getMaa();
                                int algRaha = getRaha();
                                for (int i = 0; i < kogus; i++) {
                                    hotelliSumma += Main.hotellMaa.getAlgHind();
                                    Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa())));
                                }

                                if (hotelliSumma > Main.getRaha()) {
                                    Main.hotellMaa.setAlgHind(temporary);
                                    hotellMaa.setMaa(algKogus);
                                    setRaha(algRaha);
                                    throw new RahaPoleException();
                                } else {
                                    Main.payDay(-hotelliSumma);
                                    Main.hotellMaa.addMaa(kogus);
                                    Main.karjaMaa.addMaa(-kogus);
                                }
                            } else if (cb.getValue().equals("pollumaa") && kogus <= põlluMaa.getMaa()) {
                                int temporary = Main.hotellMaa.getAlgHind();
                                int hotelliSumma = 0;
                                int algKogus = hotellMaa.getMaa();
                                int algRaha = getRaha();
                                for (int i = 0; i < kogus; i++) {
                                    hotelliSumma += Main.hotellMaa.getAlgHind();
                                    Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa())));
                                }

                                if (hotelliSumma > Main.getRaha()) {
                                    Main.hotellMaa.setAlgHind(temporary);
                                    hotellMaa.setMaa(algKogus);
                                    setRaha(algRaha);
                                    throw new RahaPoleException();
                                } else {
                                    Main.payDay(-hotelliSumma);
                                    Main.hotellMaa.addMaa(kogus);
                                    Main.põlluMaa.addMaa(-kogus);
                                }
                            }

                        } catch (NullPointerException ne) {
                            mure.setText("Vali maa ja sisesta kogus!");
                        } catch (NumberFormatException nfe) {
                            mure.setText("Vali maa ja sisesta kogus!");
                        } catch (RahaPoleException r) {
                            mure.setText("Raha pole piisavalt");
                        }
                        kast.clear();
                    }
                });
            }

        }

        mainh.getChildren().add(maa);
    }


    public void start(Stage peaLava) {


        BorderPane mainbp = new BorderPane();
        mainbp.setMinWidth(1000);

        final Text sissetulekSek = new Text("1");


        GridPane ulemine = new GridPane();

        ulemine.add(new Label("RAHA HETKEL: "), 0, 0);
        final Text rahaHetkel = new Text("100");
        ulemine.add(rahaHetkel, 1, 0);
        ulemine.add(new Label("SISSETULEK SEK: "), 0, 1);
        ulemine.add(sissetulekSek, 1, 1);
        ulemine.setPadding(new Insets(0, 10, 10, 10));

        mainbp.setTop(ulemine);

        HBox alumine = new HBox();
        final Text mure = new Text("Teretulemast mangima");
        alumine.getChildren().add(mure);
        alumine.setPadding(new Insets(10, 10, 10, 10));
        mainbp.setBottom(alumine);



        Button saveNupp = new Button("Salvesta");
        saveNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                File fail = new File("C:/Temp/IdleSave.txt");
                if(fail.exists()){
                    fail.delete();
                    File uusFail = new File("C:/Temp/IdleSave.txt");
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(uusFail, false));

                        bw.write(Integer.toString(getRaha()));
                        bw.newLine();

                        bw.write(Integer.toString(tühiMaa.getMaa()));
                        bw.newLine();
                        bw.write(Integer.toString(tühiMaa.getAlgHind()));

                        bw.newLine();
                        bw.write(Integer.toString(põlluMaa.getMaa()));
                        bw.newLine();
                        bw.write(Integer.toString(põlluMaa.getAlgHind()));

                        bw.newLine();
                        bw.write(Integer.toString(karjaMaa.getMaa()));
                        bw.newLine();
                        bw.write(Integer.toString(karjaMaa.getAlgHind()));

                        bw.newLine();
                        bw.write(Integer.toString(hotellMaa.getMaa()));
                        bw.newLine();
                        bw.write(Integer.toString(hotellMaa.getAlgHind()));

                        bw.close();
                    }
                    catch (IOException io){
                        mure.setText("Salvestamisel tekkis viga!");
                    }
                }
                else{
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(fail, false));

                        bw.write(Integer.toString(getRaha()));
                        bw.newLine();

                        bw.write(Integer.toString(tühiMaa.getMaa()));
                        bw.newLine();
                        bw.write(Integer.toString(tühiMaa.getAlgHind()));

                        bw.newLine();
                        bw.write(Integer.toString(põlluMaa.getMaa()));
                        bw.newLine();
                        bw.write(Integer.toString(põlluMaa.getAlgHind()));

                        bw.newLine();
                        bw.write(Integer.toString(karjaMaa.getMaa()));
                        bw.newLine();
                        bw.write(Integer.toString(karjaMaa.getAlgHind()));

                        bw.newLine();
                        bw.write(Integer.toString(hotellMaa.getMaa()));
                        bw.newLine();
                        bw.write(Integer.toString(hotellMaa.getAlgHind()));

                        bw.close();
                    }
                    catch (IOException io) {
                        mure.setText("Salvestamisel tekkis viga!");
                    }
                }
            }
        });

        Button laadiNupp = new Button("Lae viimane");
        laadiNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                File fail = new File("C:/Temp/IdleSave.txt");
                if(fail.exists()) {
                    try {

                        Scanner s = new Scanner(fail);
                        ArrayList<String> list = new ArrayList<String>();
                        while (s.hasNext()){
                            list.add(s.next());
                        }
                        s.close();

                        setRaha(Integer.parseInt(list.get(0)));

                        tühiMaa.setMaa(Integer.parseInt(list.get(1)));
                        tühiMaa.setAlgHind(Integer.parseInt(list.get(2)));

                        põlluMaa.setMaa(Integer.parseInt(list.get(3)));
                        põlluMaa.setAlgHind(Integer.parseInt(list.get(4)));

                        karjaMaa.setMaa(Integer.parseInt(list.get(5)));
                        karjaMaa.setAlgHind(Integer.parseInt(list.get(6)));

                        hotellMaa.setMaa(Integer.parseInt(list.get(7)));
                        hotellMaa.setAlgHind(Integer.parseInt(list.get(8)));


                    } catch (IOException io) {
                        mure.setText("Laadimisel tekkis viga!");
                    }
                }
                else{
                    mure.setText("Salvestusi pole!");
                }
            }
        });


        ulemine.add(saveNupp,2,0);
        ulemine.add(laadiNupp,3,0);
        ulemine.setHgap(20);

        HBox mainh = new HBox();

        mainh.setSpacing(30);
        mainh.setPadding(new Insets(10, 10, 10, 10));


        Label tuhimaa = new Label("TUHIMAA");
        final Text tuhimaaHaArv = new Text("0");


        final Text tuhimaaHaSek = new Text("0");

        final Text tuhimaaSek = new Text("0");
        final Text tuhimaaHind = new Text("0");
        final Text tuhimaaSaadOsta = new Text("0");

        maad(mainh, tuhimaa, tuhimaaHaArv, tuhimaaHaSek, tuhimaaSek, tuhimaaHind, tuhimaaSaadOsta, mure);

        Label karjamaa = new Label("KARJAMAA");
        final Text karjamaaHaArv = new Text("0");

        final Text karjamaaHaSek = new Text("0");
        final Text karjamaaSek = new Text("0");
        final Text karjamaaHind = new Text("0");
        final Text karjamaaSaadOsta = new Text("0");

        maad(mainh, karjamaa, karjamaaHaArv, karjamaaHaSek, karjamaaSek, karjamaaHind, karjamaaSaadOsta, mure);

        Label pollumaa = new Label("POLLUMAA");
        final Text pollumaaHaArv = new Text("0");
        final Text pollumaaHaSek = new Text("0");
        final Text pollumaaSek = new Text("0");
        final Text pollumaaHind = new Text("0");
        final Text pollumaaSaadOsta = new Text("0");

        maad(mainh, pollumaa, pollumaaHaArv, pollumaaHaSek, pollumaaSek, pollumaaHind, pollumaaSaadOsta, mure);

        Label hotellimaa = new Label("HOTELLIMAA");
        final Text hotellimaaHaArv = new Text("0");
        final Text hotellimaaHaSek = new Text("0");
        final Text hotellimaaSek = new Text("0");
        final Text hotellimaaHind = new Text("0");
        final Text hotellimaaSaadOsta = new Text("0");

        maad(mainh, hotellimaa, hotellimaaHaArv, hotellimaaHaSek, hotellimaaSek, hotellimaaHind, hotellimaaSaadOsta, mure);


        mainbp.setCenter(mainh);

        Scene stseen1 = new Scene(mainbp, 1000, 250, Color.SNOW);
        peaLava.setScene(stseen1);
        peaLava.setTitle("IDLE MANG");
        peaLava.show();

        peaLava.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });


        new Thread() {
            @Override
            public void run() {
                try {
                    Main.newGame();
                    while (true) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                sissetulekSek.setText(Integer.toString(Main.kokkuIncome()));
                                rahaHetkel.setText(Integer.toString(Main.getRaha()));

                                tuhimaaHaArv.setText(Integer.toString(tühiMaa.getMaa()));
                                tuhimaaHaSek.setText(Integer.toString(tühiMaa.getAlgIps()));
                                tuhimaaHind.setText(Integer.toString(tühiMaa.cost()));
                                tuhimaaSek.setText(Integer.toString(tühiMaa.income()));
                                tuhimaaSaadOsta.setText(Integer.toString(saabOsta(tühiMaa.getAlgHind(), tühiMaa.getMaa(), 0, tühiMaa.getAlgHind())));

                                pollumaaHaArv.setText(Integer.toString(põlluMaa.getMaa()));
                                pollumaaHaSek.setText(Integer.toString(põlluMaa.getAlgIps()));
                                pollumaaHind.setText(Integer.toString(põlluMaa.cost()));
                                pollumaaSaadOsta.setText(Integer.toString(saabOsta(põlluMaa.getAlgHind(), põlluMaa.getMaa(), 0, põlluMaa.getAlgHind())));
                                pollumaaSek.setText(Integer.toString(põlluMaa.income()));

                                karjamaaHaArv.setText(Integer.toString(karjaMaa.getMaa()));
                                karjamaaHaSek.setText(Integer.toString(karjaMaa.getAlgIps()));
                                karjamaaHind.setText(Integer.toString(karjaMaa.cost()));
                                karjamaaSaadOsta.setText(Integer.toString(saabOsta(karjaMaa.getAlgHind(), karjaMaa.getMaa(), 0, karjaMaa.getAlgHind())));
                                karjamaaSek.setText(Integer.toString(karjaMaa.income()));

                                hotellimaaHaArv.setText(Integer.toString(hotellMaa.getMaa()));
                                hotellimaaHaSek.setText(Integer.toString(hotellMaa.getAlgIps()));
                                hotellimaaHind.setText(Integer.toString(hotellMaa.cost()));
                                hotellimaaSaadOsta.setText(Integer.toString(saabOsta(hotellMaa.getAlgHind(), hotellMaa.getMaa(), 0, hotellMaa.getAlgHind())));
                                hotellimaaSek.setText(Integer.toString(hotellMaa.income()));
                            }
                        });
                        int tick = Update.getTick();
                        Update.Tick();
                        Thread.sleep(tick * 1000);
                    }

                } catch (InterruptedException ie) {
                    System.out.println("ERROR");
                }
            }
        }.start();
    }


    public static void main(final String[] args) {

        launch(args);
    }


    public static void newGame() {
        Main.raha = 1000;

    }

    public static int kokkuMaad() {
        return tühiMaa.getMaa() + karjaMaa.getMaa() + põlluMaa.getMaa() + hotellMaa.getMaa();
    }

    public static int kokkuIncome() {
        return tühiMaa.income() + karjaMaa.income() + põlluMaa.income() + hotellMaa.income();
    }


}
