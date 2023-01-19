package com.example.laborator12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OBradFrumos extends Application {
    private static TextArea rezultatCautare = new TextArea();
    private static Label nrInregistrari = new Label();
    private ImageView imageView;
    private static Label Nume = new Label("Nume:");
    private ChoiceBox Selectare_nume = new ChoiceBox<>();
    private static Label Localitate = new Label("Localitate:");
    private ChoiceBox Selectare_localitate = new ChoiceBox<>();
    private Button citire_fisier = new Button("Citire fisier");
    private Text topText;
    private Label eticValSelectata;
    private ListaMosului listaMosului;
    //
// puteti COMPLETA cu campuri și metode
//
    private static TextArea getTextArea(String textInitial) {
        TextArea ta = new TextArea();
        ta.appendText(textInitial);
        ta.setPrefWidth(400);
        ta.setPrefHeight(370);
        ta.setWrapText(true);
        return ta;
    }
    private ChoiceBox getChoiceBox(Map<String, List<Student>> map) {
        ObservableList<String> listaItemi = null;
        listaItemi.addAll(map.keySet());
        //
        // DE COMPLETAT listaItemi cu valorile cheilor din map
        //
        // sugestie clasa ConsultareDictionar din aplicația Dictionar ilustrat prezentata
        // la cursul Controale grafice
        //
        ChoiceBox<String> list = new ChoiceBox<>(listaItemi);
        list.getSelectionModel().selectedItemProperty()
                .addListener(new SelectareItem(map));
        // este necesar sa scrieti clasa SelectareItem care sa implementeze ChangeListener
        // scheletul clasei SelectareItem este prezentat în continuare
        return list;
    }
    Slider getSlider() {
        Slider valMedie = new Slider();
        valMedie.setPrefSize(550,200);
        valMedie.setMin(0);
        valMedie.setMax(10);
        valMedie.setValue(0);
        valMedie.setMinorTickCount(0);
        valMedie.setMajorTickUnit(0.5);
        valMedie.setSnapToTicks(true);
        valMedie.setShowTickLabels(true);
        valMedie.setShowTickMarks(true);
        valMedie.valueProperty().addListener ( new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                double valSelectata = new_val.doubleValue();
                eticValSelectata.setText(String.format("Stud. cu media >= %.2f", new_val));
                List <Student> lstDupaMedie=null;
                lstDupaMedie.add(new Student("Viorel", 7.45, "Suceava"));
                //
                // DE COMPLETAT cu instructiunile pentru obtinerea listei studentilor
                // lstDupaMedie care au media cel putin egala cu new_val
                //
                afișareRezultat(lstDupaMedie);
            }
        });
        return valMedie;
    }
    // package protected
    static void afișareRezultat(List<Student> lstud) {
        nrInregistrari.setText("Inregistrari: "+lstud.size());
        for(int i=0;i<lstud.size();i++)
            rezultatCautare.appendText(lstud.get(i).toString());
    }
    private BorderPane getPanou() throws FileNotFoundException {
        BorderPane panou = new BorderPane();
        FileInputStream input = new FileInputStream("C:\\Users\\Sorin\\IdeaProjects\\Laborator 12\\src\\main\\resources\\images\\download.jpg");
        Image image = new Image(input);
        imageView = new ImageView(image);
        Selectare_nume.setPrefSize(150,20);
        Selectare_localitate.setPrefSize(150,20);
        //
        // DE COMPLETAT
        //
        // sugestie: aplicația Dictionar ilustrat prezentata
        // la cursul Controale grafice
        //
        Slider valMedie = getSlider();
        // sugestie pentru Slider: cursul Scurt tutorial JavaFX,
        // aplicația FORMULARE CU CONTROALE GRAFICE DIVERSE
        eticValSelectata = new Label(" . . . DE COMPLETAT . . . " );
        panou.setBottom(new HBox(10, valMedie, eticValSelectata));
        panou.setCenter(new HBox(10,rezultatCautare,nrInregistrari,imageView));
        panou.setTop(new HBox(10,Nume,Selectare_nume,Localitate,Selectare_localitate,citire_fisier));
        return panou;
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        listaMosului = new ListaMosului();
        Scene scena = new Scene(getPanou(), 700, 500);
        primaryStage.setScene(scena);
        primaryStage.setTitle("O, brad frumos!");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
