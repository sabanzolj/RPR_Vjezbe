package ba.unsa.etf.rpr.tutorijal06;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class Controller {


    public Button buttonNulaID;
    public Label display;

    public Button btn1;
    public Button btn0;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public Button dotBtn;
    public Button plusBtn;
    public Button equalsBtn;
    public Button minusBtn;

    private List<String> spremink=new ArrayList<>();
    double rezultat=0;

    boolean plus=true;
    boolean minus=false;

    boolean puta=false;

    boolean podijeljeno=false;

    boolean posto=false;


    public void nulaAkcija(ActionEvent actionEvent) {

        if(display.getText().equals("0")){
            display.setText("0");
        }
        else{
            display.setText(display.getText()+"0");
        }

    }

    public void jedanAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("1");
            }
            else{
                display.setText(display.getText()+"1");
            }

        }
        else{
            display.setText(display.getText()+"1");
        }
    }


    public void dvaAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("2");
            }
            else{
                display.setText(display.getText()+"2");
            }

        }
        else{
            display.setText(display.getText()+"2");
        }
    }

    public void triAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("3");
            }
            else{
                display.setText(display.getText()+"3");
            }

        }
        else{
            display.setText(display.getText()+"3");
        }
    }

    public void cetriAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("4");
            }
            else{
                display.setText(display.getText()+"4");
            }

        }
        else{
            display.setText(display.getText()+"4");
        }
    }

    public void petAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("5");
            }
            else{
                display.setText(display.getText()+"5");
            }

        }
        else{
            display.setText(display.getText()+"5");
        }
    }

    public void sestAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("6");
            }
            else{
                display.setText(display.getText()+"6");
            }

        }
        else{
            display.setText(display.getText()+"6");
        }
    }

    public void sedamAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("7");
            }
            else{
                display.setText(display.getText()+"7");
            }

        }
        else{
            display.setText(display.getText()+"7");
        }
    }

    public void osamAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("8");
            }
            else{
                display.setText(display.getText()+"8");
            }

        }
        else{
            display.setText(display.getText()+"8");
        }
    }

    public void buttonDevetAkcija(ActionEvent actionEvent) {
        if(display.getText().length()==1){
            if(display.getText().equals("0")){
                display.setText("9");
            }
            else{
                display.setText(display.getText()+"9");
            }

        }
        else{
            display.setText(display.getText()+"9");
        }
    }

    public void tackaAkcija(ActionEvent actionEvent) {
        display.setText(display.getText()+".");
    }

    public void postoAkcija(ActionEvent actionEvent) {
        double temp=Double.parseDouble(display.getText())/100;
        display.setText(Double.toString(temp));
        plus=false;
        minus=false;
        puta=true;
        podijeljeno=false;
        posto=false;

    }

    public void dijeljenjeAkcija(ActionEvent actionEvent) {
        if(plus){
            rezultat+=Double.parseDouble(display.getText());
            display.setText("0");
        }
        if(minus){
            rezultat-=Double.parseDouble(display.getText());
            display.setText("0");
        }

        if(podijeljeno){
            double temp=Double.parseDouble(display.getText());
            if(temp!=0) {
                rezultat = rezultat / temp;
                display.setText("0");
            }
            else{
                display.setText("Error");
            }

        }
        plus=false;
        minus=false;
        puta=false;
        podijeljeno=true;
        posto=false;

    }

    public void mnozenjeAkcija(ActionEvent actionEvent) {
        if(plus){
            rezultat+=Double.parseDouble(display.getText());
            display.setText("0");
        }
        if(minus){
            rezultat-=Double.parseDouble(display.getText());
            display.setText("0");
        }


        if(puta){
            double temp=Double.parseDouble(display.getText());
            rezultat=rezultat*temp;
            display.setText("0");
        }
        plus=false;
        minus=false;
        puta=true;
        podijeljeno=false;
        posto=false;
    }

    public void minusAkcija(ActionEvent actionEvent) {
        if(plus){
            rezultat+=Double.parseDouble(display.getText());
            display.setText("0");
        }
        plus=false;
        minus=true;
        puta=false;
        podijeljeno=false;
        posto=false;

        if(minus){
            double temp=Double.parseDouble(display.getText());
            temp*=(-1);
            rezultat+=temp;
            display.setText("0");
        }


    }

    public void plusAkcija(ActionEvent actionEvent) {
        plus=true;
        minus=false;
        puta=false;
        podijeljeno=false;
        posto=false;
        rezultat+=Double.parseDouble(display.getText());
        display.setText("0");

    }

    public void jednakoAkcija(ActionEvent actionEvent) {
        if(plus) {
            rezultat+=Double.parseDouble(display.getText());
            display.setText(Double.toString(rezultat));
            rezultat=0;
            plus=true;
            minus=false;
            puta=false;
            podijeljeno=false;
            posto=false;
        }
        else if(minus){
            double temp=Double.parseDouble(display.getText());
            temp*=(-1);
            rezultat+=temp;
            display.setText(Double.toString(rezultat));
            rezultat=0;
            plus=true;
            minus=false;
            puta=false;
            podijeljeno=false;
            posto=false;
        }
        else if(puta){
            double temp=Double.parseDouble(display.getText());
            rezultat=rezultat*temp;
            display.setText(Double.toString(rezultat));
            rezultat=0;
            plus=true;
            minus=false;
            puta=false;
            podijeljeno=false;
            posto=false;
        }
        else if(podijeljeno){
            double temp=Double.parseDouble(display.getText());
            if(temp!=0) {
                rezultat = rezultat / temp;
                display.setText(Double.toString(rezultat));
            }
            else{
                display.setText("Error");
            }
            rezultat=0;
            plus=true;
            minus=false;
            puta=false;
            podijeljeno=false;
            posto=false;

        }
    }


}
