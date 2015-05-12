/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dat
 */
public class WC {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        if(args.length < 1){
            System.out.println("Please specify the input file");
           System.exit(1);
        }
        
        String output="";
        if(args.length >=2)
            output = args[1];
        
            
        if(output == null || output.isEmpty())
            output="output.txt";
        
        try {
            BufferedReader br = new BufferedReader( new FileReader(args[0]));
            BufferedWriter wr = new BufferedWriter(new FileWriter(output));
            
            Map<String,Integer> wc = new HashMap<>();
            
            String line = br.readLine();
            //Pattern spliter = Pattern.compile("\\s+");
            
            while(line != null){
                String[] words =  line.split("\\s+");
                for( String w: words){
                    // if it is there
                    if(!w.isEmpty() && w.length() >0){
                        Integer n = wc.get(w);
                        if(n == null)
                            n=1;
                        n++;

                        wc.put(w, n);
                        //System.out.println("word:"+w + " counted:"+n.toString());
                    }
                }
                    
                
                line = br.readLine();
            }
            
            //Iterator iter = wc.entrySet().iterator();
            
            for( Map.Entry<String,Integer> en: wc.entrySet()){
                 
                
                String oLine = en.getKey()+ "\t"+ en.getValue().toString();
                wr.write(oLine);
                wr.newLine();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(WC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
