import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{
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

    public static void payDay(int x) {
        raha += x;
    }



    public void maad(HBox mainh,Label tuupMaa, Text haArv, Text haSek, Text maaSek, Text maaHind, Text saadOsta){
        GridPane maa = new GridPane();

        maa.add(tuupMaa,1,0);
        maa.add(haArv,1,1);
        maa.add(new Label(" ha"), 2, 1);

        maa.add(new Label("1 ha annab: "), 0, 2);
        maa.add(haSek,1,2);
        maa.add(new Label(" $/sek"), 2, 2);

        maa.add(new Label("Kokku: "), 0, 3);
        maa.add(maaSek, 1, 3);
        maa.add(new Label(" $/sek"), 2, 3);

        maa.add(new Label("Uks ha maksab: "), 0, 4);
        maa.add(maaHind, 1, 4);
        maa.add(new Label(" $"), 2, 4);

        maa.add(new Label("Saad osta : "), 0, 5);
        maa.add(saadOsta, 1, 5);
        maa.add(new Label(" ha maad"), 2, 5);

        if(tuupMaa.getText().equals("TUHIMAA")){
            maa.add(new Label("Ostan "),0,6);

            final TextField kast = new TextField();
            kast.setPrefWidth(20);
            maa.add(kast, 1,6);

            maa.add(new Label(" ha "),2,6);

            Button ostaNupp = new Button("OSTA");
            maa.add(ostaNupp,0,7);
            ostaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    int kogus = Integer.parseInt(kast.getText());
                    int tühiSumma = 0;
                    int temporary = Main.tühiMaa.getAlgHind();
                    for (int i = 0; i < kogus; i++) {
                        tühiSumma += (int) (Main.tühiMaa.getAlgHind() * Math.pow(1.1, Main.tühiMaa.getMaa() + i));
                        Main.tühiMaa.setAlgHind((int) (Main.tühiMaa.getAlgHind() * Math.pow(1.1, Main.tühiMaa.getMaa() + i)));

                        if (tühiSumma > Main.getRaha()) {
                            Main.tühiMaa.setAlgHind(temporary);
                        }
                            else{

                            Main.payDay(-tühiSumma);
                            Main.tühiMaa.addMaa(kogus);
                        }
                    }


                }
            });
        }
            else{
            maa.add(new Label("Muudan "),0,6);

            final TextField kast = new TextField();
            kast.setPrefWidth(20);
            maa.add(kast, 1,6);

            maa.add(new Label(" ha "),2,6);
            if(tuupMaa.getText().equals("KARJAMAA")) {
                final ChoiceBox cb = new ChoiceBox();
                cb.getItems().addAll("tuhimaa");
                maa.add(cb, 0, 7);
                Button muudaNupp = new Button("MUUDA");
                maa.add(muudaNupp, 1, 7);
                muudaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        int kogus = Integer.parseInt(kast.getText());

                        if (kogus <= Main.tühiMaa.getMaa()) {
                            int temporary = Main.karjaMaa.getAlgHind();
                            int karjamaaSumma = 0;
                            for (int i = 0; i < kogus; i++) {
                                karjamaaSumma += (int) (Main.karjaMaa.getAlgHind() * Math.pow(1.1, Main.karjaMaa.getMaa() + i));
                                Main.karjaMaa.setAlgHind((int) (Main.karjaMaa.getAlgHind() * Math.pow(1.1, Main.karjaMaa.getMaa() + i)));
                            }
                            if (karjamaaSumma > Main.getRaha()) {
                                Main.karjaMaa.setAlgHind(temporary);
                            } else if (cb.getValue().equals("tuhimaa")) {
                                Main.payDay(-karjamaaSumma);
                                Main.karjaMaa.addMaa(kogus);
                                Main.tühiMaa.addMaa(-kogus);
                            }
                        }
                    }
                });
            }
            else if(tuupMaa.getText().equals("POLLUMAA")) {
                final ChoiceBox cb = new ChoiceBox();
                cb.getItems().addAll("tuhimaa","karjamaa");
                maa.add(cb, 0, 7);
                Button muudaNupp = new Button("MUUDA");
                maa.add(muudaNupp, 1, 7);
                muudaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        int kogus = Integer.parseInt(kast.getText());
                        if (cb.getValue().equals("tuhimaa") && kogus <= tühiMaa.getMaa()){
                            int temporary = Main.põlluMaa.getAlgHind();
                            int põllumaaSumma = 0;
                            for (int i = 0; i < kogus; i++) {
                                põllumaaSumma += (int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i));
                                Main.põlluMaa.setAlgHind((int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i)));
                            }

                            if (põllumaaSumma > Main.getRaha()) {
                                Main.põlluMaa.setAlgHind(temporary);
                            }
                            else{
                                Main.payDay(-põllumaaSumma);
                                Main.põlluMaa.addMaa(kogus);
                                Main.tühiMaa.addMaa(-kogus);
                            }

                        }
                        else if(cb.getValue().equals("karjamaa") && kogus <= karjaMaa.getMaa()){
                            int temporary = Main.põlluMaa.getAlgHind();
                            int põllumaaSumma = 0;
                            for (int i = 0; i < kogus; i++) {
                                põllumaaSumma += (int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i));
                                Main.põlluMaa.setAlgHind((int) (Main.põlluMaa.getAlgHind() * Math.pow(1.1, Main.põlluMaa.getMaa() + i)));
                            }

                            if (põllumaaSumma > Main.getRaha()) {
                                Main.põlluMaa.setAlgHind(temporary);
                            }
                            else{
                                Main.payDay(-põllumaaSumma);
                                Main.põlluMaa.addMaa(kogus);
                                Main.karjaMaa.addMaa(-kogus);
                            }

                        }
                    }
                });
            }
            else if(tuupMaa.getText().equals("HOTELLIMAA")) {
                final ChoiceBox cb = new ChoiceBox();
                cb.getItems().addAll("tuhimaa","karjamaa","pollumaa");
                maa.add(cb, 0, 7);
                Button muudaNupp = new Button("MUUDA");
                maa.add(muudaNupp, 1, 7);
                muudaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        int kogus = Integer.parseInt(kast.getText());
                        if (cb.getValue().equals("tuhimaa") && kogus <= tühiMaa.getMaa()) {
                            int temporary = Main.hotellMaa.getAlgHind();
                            int hotelliSumma = 0;
                            for (int i = 0; i < kogus; i++) {
                                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
                            }

                            if (hotelliSumma > Main.getRaha()) {
                                Main.hotellMaa.setAlgHind(temporary);
                            } else {
                                Main.payDay(-hotelliSumma);
                                Main.hotellMaa.addMaa(kogus);
                                Main.tühiMaa.addMaa(-kogus);
                            }


                        } else if (cb.getValue().equals("karjamaa") && kogus <= karjaMaa.getMaa()) {
                            int temporary = Main.hotellMaa.getAlgHind();
                            int hotelliSumma = 0;
                            for (int i = 0; i < kogus; i++) {
                                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
                            }

                            if (hotelliSumma > Main.getRaha()) {
                                Main.hotellMaa.setAlgHind(temporary);
                            } else {
                                Main.payDay(-hotelliSumma);
                                Main.hotellMaa.addMaa(kogus);
                                Main.karjaMaa.addMaa(-kogus);
                            }
                        }
                        else  if (cb.getValue().equals("pollumaa") && kogus <= põlluMaa.getMaa()) {
                            int temporary = Main.hotellMaa.getAlgHind();
                            int hotelliSumma = 0;
                            for (int i = 0; i < kogus; i++) {
                                hotelliSumma += (int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i));
                                Main.hotellMaa.setAlgHind((int) (Main.hotellMaa.getAlgHind() * Math.pow(1.1, Main.hotellMaa.getMaa() + i)));
                            }

                            if (hotelliSumma > Main.getRaha()) {
                                Main.hotellMaa.setAlgHind(temporary);
                            } else {
                                Main.payDay(-hotelliSumma);
                                Main.hotellMaa.addMaa(kogus);
                                Main.põlluMaa.addMaa(-kogus);
                            }
                        }

                    }
                });
            }

        }

        mainh.getChildren().add(maa);
    }


    public void start(Stage peaLava) {


        BorderPane mainbp = new BorderPane();
        mainbp.setMinWidth(250);

        final Text  sissetulekSek = new Text("1");



        HBox ulemine = new HBox();
        ulemine.getChildren().addAll(new Label("Sissetulek sekundis: "),sissetulekSek);
        mainbp.setTop(ulemine);

        HBox mainh = new HBox();
        mainh.setSpacing(30);


        Label tuhimaa = new Label("TUHIMAA");
        final Text tuhimaaHaArv = new Text("0");


        final Text tuhimaaHaSek = new Text("0");

        final Text tuhimaaSek = new Text("0");
        final Text tuhimaaHind = new Text("0");
        Text tuhimaaSaadOsta = new Text("0");

        maad(mainh,tuhimaa,tuhimaaHaArv, tuhimaaHaSek, tuhimaaSek, tuhimaaHind, tuhimaaSaadOsta);

        Label karjamaa = new Label("KARJAMAA");
        final Text karjamaaHaArv = new Text("0");

        final Text karjamaaHaSek = new Text("0");
        final Text karjamaaSek = new Text("0");
        final Text karjamaaHind = new Text("0");
        final Text karjamaaSaadOsta = new Text("0");

        maad(mainh,karjamaa,karjamaaHaArv, karjamaaHaSek, karjamaaSek, karjamaaHind, karjamaaSaadOsta);

        Label pollumaa = new Label("POLLUMAA");
        final Text pollumaaHaArv = new Text("0");
        final Text pollumaaHaSek = new Text("0");
        final Text pollumaaSek = new Text("0");
        final Text pollumaaHind = new Text("0");
        final Text pollumaaSaadOsta = new Text("0");

        maad(mainh,pollumaa,pollumaaHaArv, pollumaaHaSek, pollumaaSek, pollumaaHind, pollumaaSaadOsta);

        Label hotellimaa = new Label("HOTELLIMAA");
        final Text hotellimaaHaArv = new Text("0");
        final Text hotellimaaHaSek = new Text("0");
        final Text hotellimaaSek = new Text("0");
        final Text hotellimaaHind = new Text("0");
        final Text hotellimaaSaadOsta = new Text("0");

        maad(mainh,hotellimaa,hotellimaaHaArv, hotellimaaHaSek, hotellimaaSek, hotellimaaHind, hotellimaaSaadOsta);


        mainbp.setCenter(mainh);

        Scene stseen1 = new Scene(mainbp, 900, 250, Color.SNOW);
        peaLava.setScene(stseen1);
        peaLava.setTitle("IDLE MANG");
        peaLava.show();

        peaLava.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });



        new Thread()  {
            @Override
            public void run() {
                try {
                    Main.newGame();
                    while (true) {
                        int tick = Update.getTick();
                        Update.Tick();
                        Thread.sleep(tick * 1000);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                sissetulekSek.setText(Integer.toString(Main.kokkuIncome()));

                                tuhimaaHaArv.setText(Integer.toString(tühiMaa.getMaa()));
                                tuhimaaHaSek.setText(Integer.toString(tühiMaa.getAlgIps()));
                                tuhimaaHind.setText(Integer.toString(tühiMaa.cost()));
                                tuhimaaSek.setText(Integer.toString(tühiMaa.income()));

                                pollumaaHaArv.setText(Integer.toString(põlluMaa.getMaa()));
                                pollumaaHaSek.setText(Integer.toString(põlluMaa.getAlgIps()));
                                pollumaaHind.setText(Integer.toString(põlluMaa.cost()));
                                pollumaaSaadOsta.setText("0");
                                pollumaaSek.setText(Integer.toString(põlluMaa.income()));

                                karjamaaHaArv.setText(Integer.toString(karjaMaa.getMaa()));
                                karjamaaHaSek.setText(Integer.toString(karjaMaa.getAlgIps()));
                                karjamaaHind.setText(Integer.toString(karjaMaa.cost()));
                                karjamaaSaadOsta.setText("0");
                                karjamaaSek.setText(Integer.toString(karjaMaa.income()));

                                hotellimaaHaArv.setText(Integer.toString(hotellMaa.getMaa()));
                                hotellimaaHaSek.setText(Integer.toString(hotellMaa.getAlgIps()));
                                hotellimaaHind.setText(Integer.toString(hotellMaa.cost()));
                                hotellimaaSaadOsta.setText("0");
                                hotellimaaSek.setText(Integer.toString(hotellMaa.income()));
                            }
                        });
                    }

                }
                catch (InterruptedException ie){
                    System.out.println("ERROR");
                }
            }
        }.start();
    }






    public static void main(final String[] args)  {

        launch(args);
    }


    public static void newGame() {
        Main.raha = 10000;
        tühiMaa.setMaa(1);
        //lõime.start();
    }

    public static int kokkuMaad() {
        return tühiMaa.getMaa() + karjaMaa.getMaa() + põlluMaa.getMaa() + hotellMaa.getMaa();
    }

    public static int kokkuIncome() {
        return tühiMaa.income() + karjaMaa.income() + põlluMaa.income() + hotellMaa.income();
    }


}

