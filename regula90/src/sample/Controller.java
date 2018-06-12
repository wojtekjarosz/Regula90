package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Controller {


    @FXML
    Button startButton;
    @FXML
    TextField textField;
    @FXML
    Canvas canvas;
    GraphicsContext gc;
    @FXML
    public void initialize() {
        textField.setText("90");
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
    }

    @FXML
    public void handleStart() {


    int rule = Integer.parseInt(textField.getText());
    if(rule>255) rule=255;
    if(rule<0) rule=0;
    textField.setText(rule+"");
    String output = Integer.toBinaryString(rule);
    String binaryRule = String.format("%8s", output).replace(' ','0');
    String[] ary = binaryRule.split("");


    //textField.setText(binaryRule);
    int width = 200;
    int time=200;
    char[] state = new char[width];
    for(int k=0; k<width;k++){
        state[k]='0';
    }
    state[width/2]='1';
        char[] state1 = new char[width];
    //char[] state = {'0' , '0' , '0' , '0', '0' , '1' , '0', '0' ,'0' ,'0','0'};
    //char[] state1={'0','0','0','0','0','0','0','0','0','0','0'};
        for(int b=0;b<state.length-1;b++){
            System.out.print(" " +state[b]);
            if(state[b]=='1')
                gc.setFill(Color.BLACK);
            else
                gc.setFill(Color.WHITE);
            gc.fillRect(0+b*4,0,4,4);
        }
        System.out.println("");
    int p,k;
    for(int t=0; t <time; t++){
        for(int i = 0; i <state.length-1; i++){
            p=i-1; k=i+1;
            if(i==0)
                p=(state.length-1);
            else
                p = i - 1;
            if(i==(state.length-1))
                k=0;
            else
                k = i + 1;

            if(state[p] == '1' && state[i]=='1' && state[k] == '1'){
                state1[i]= ary[0].charAt(0);
                //state1[i]='0';
            }
            if(state[p] == '1' && state[i]=='1' && state[k] == '0'){
                state1[i]= ary[1].charAt(0);
                //state1[i]='1';
            }
            if(state[p] == '1' && state[i]=='0' && state[k] == '1'){
                state1[i]= ary[2].charAt(0);
                //state1[i]='0';
            }
            if(state[p] == '1' && state[i]=='0' && state[k] == '0'){
                state1[i]= ary[3].charAt(0);
                //state1[i]='1';
            }
            if(state[p] == '0' && state[i]=='1' && state[k] == '1'){
                state1[i]= ary[4].charAt(0);
                //state1[i]='1';
            }
            if(state[p] == '0' && state[i]=='1' && state[k] == '0'){
                state1[i]= ary[5].charAt(0);
                //state1[i]='0';
            }
            if(state[p] == '0' && state[i]=='0' && state[k] == '1'){
                state1[i]= ary[6].charAt(0);
                //state1[i]='1';
            }
            if(state[p] == '0' && state[i]=='0' && state[k] == '0'){
                state1[i]= ary[7].charAt(0);
                //state1[i]='0';
            }
        }
        state = state1.clone();
        for(int b=0;b<state.length;b++) {
            System.out.print(" " + state[b]);
            if(state[b]=='1')
                gc.setFill(Color.BLACK);
            else
                gc.setFill(Color.WHITE);
            gc.fillRect(0+b*4,0+t*4+4,4,4);
        }
        System.out.println("");
    }
}
    }
