package edu.insightr.spellmonger;

import org.json.simple.parser.ParseException;
import sun.misc.IOUtils;

import java.io.*;
import java.net.URL;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import javax.json.Json;
import javax.json.stream.JsonParser;

import static org.apache.log4j.helpers.Loader.getResource;


/**
 * Created by Karim_Utilisateur on 10/11/2016.
 */
public class JsonRead {

    String login, mdp;
    String[] tabLog;
    String[] tabMdp;
    JsonRead(){
        tabLog = new String[3];
        tabMdp = new String[3];
        try {
            this.Read();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public void Read() throws ParseException {
        int cpt = 0;
        int cpt2 = 0;
         URL url = getResource("participants.json");
        Object obj = null;
        try {
            try (InputStream is = url.openStream();
                 JsonParser parser = Json.createParser(is)){
                while (parser.hasNext()) {

                    JsonParser.Event e = parser.next();
                    if (e == JsonParser.Event.KEY_NAME) {

                if((parser.getString().equals("Login"))) {
                    parser.next();
                    if (parser.getString() != null) {
                        login = parser.getString();
//                        System.out.print(login);
//                        System.out.print(" : ");
                        if ((cpt < tabLog.length) && (login != null)) {
                            tabLog[cpt] = login;
                            cpt++;
                        }

                    }
                }
                        if ((parser.getString().equals("Mdp"))) {
                            parser.next();
                            if (parser.getString() != null) {
                                mdp = parser.getString();
//                                System.out.print(mdp);
//                                System.out.print(" ------- ");
                                if ((cpt2 < tabMdp.length) && (mdp != null)) {
                                    tabMdp[cpt2] = mdp;
                                    cpt2++;
                                }

                            }
                        }

                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        for(int i = 0; i < tabMdp.length && i < tabLog.length; i++){
//            System.out.println(i +""+ tabMdp[i]);
//            System.out.println(i +""+ tabLog[i]);
//
//        }


    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException {
        JsonRead reader = new JsonRead();
        try {
            reader.Read();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
