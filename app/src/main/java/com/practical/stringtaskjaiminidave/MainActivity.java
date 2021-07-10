package com.practical.stringtaskjaiminidave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    TextView txtinput,txtoutput;
    Button btnout;
    EditText edtinput,edtskip;
    int skipwords=0;
    String giveninput="",inputprocess="",outtext="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindViews();
       btnout.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view) {
                  outtext="";
                  giveninput="";
                  skipwords=Integer.parseInt(edtskip.getText().toString().trim());
               giveninput= edtinput.getText().toString();

               System.out.println("pragraph ==="+giveninput);

               giveninput=giveninput.replace(".",":");
               String[] inputarray=giveninput.split(":");


               System.out.println("pragraph size==="+inputarray.length);
               for (int i = 0; i < inputarray.length; i++) {
                   inputprocess=inputarray[i];
                   System.out.println("pragraph ==="+inputprocess);

                   String status="";

                    if(inputprocess.split(" ").length>skipwords) {
                        status = reversesentance(inputprocess) + ".";
                    }else{
                        status=inputprocess+".";
                    }
                    outtext=outtext+status;

               }

               txtoutput.setText(outtext);
            //   System.out.println("final vlue==="+outtext);


           }
       });



    }

    public  String reversesentance(String s)
    {

        System.out.println("string ==="+s);

        String[] words = s.split(" ");
        //String name = words[words.length - 2] +" "+ words[words.length - 1] ;
        String name="";
        for(int i=1;i<=skipwords;i++)
        {
            name=name+" "+words[words.length-i];
        }
        System.out.println("name===" + name);

        String last = "";
            for (int i = 0; i <words.length-skipwords ; i++) {
                System.out.println("last===" + last);

                last =  words[i]+" "+last;
            }
            inputprocess =  last+name;
            System.out.println("name===" + inputprocess);
            return  inputprocess;

        /*words = RevString(words, words.length);

        s = String.join(" ", words);
        string=s;
        System.out.println("final out put ==="+s);*/
    }
    public void FindViews()
    {
        edtinput=(EditText) findViewById(R.id.edtinput);
        txtoutput=(TextView) findViewById(R.id.txtonput);
        edtskip= (EditText) findViewById(R.id.edtskipword);
        txtinput=(TextView) findViewById(R.id.lblInput);
        btnout=(Button) findViewById(R.id.btnoutput);

    }
}