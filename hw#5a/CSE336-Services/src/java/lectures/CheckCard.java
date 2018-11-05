/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectures;

import com.google.gson.Gson;
import java.io.*;
import static java.lang.Integer.parseInt;
import javax.json.*;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author nick-
 */
@Path("checkcard")
public class CheckCard {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String CheckCard() {
        Card[] cardList;
        SerializeCards sc = new SerializeCards();
        sc.serializeCards();
        cardList = sc.deSerializeCards();
        MultivaluedMap<String, String> queryParams = context.getQueryParameters();
        for (int i = 0; i < 5; i++) {
            int cardNum = cardList[i].cardNumber;
            int cardNo = parseInt(queryParams.getFirst("cardno"));
            if (cardNum == cardNo && cardList[i].lastName.equals(queryParams.getFirst("lastname"))) {
                Gson gson = new Gson();
                return gson.toJson(cardList[i]).toString();
            }
        }
        return null;
    }

    /*
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        MultivaluedMap<String, String> queryParams = context.getQueryParameters();
        if(queryParams.getFirst("cnum").equals("123")) {
            return "<html><body><h1>Welcome back Alonzo!!</h1></body></html>";
        } else {
            return "<html><body><h1>Would you like to apply for a library card?</h1></body></html>";
        }
    }*/
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {

    }
}
