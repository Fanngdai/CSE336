/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectures;

import java.io.*;

/**
 *
 * @author nick-
 */
public class SerializeCards {

    public SerializeCards() {
        
    }
    
    public void serializeCards() {
        Card[] cardList = new Card[5];
        Card c1 = new Card();
        Card c2 = new Card();
        Card c3 = new Card();
        Card c4 = new Card();
        Card c5 = new Card();

        c1.ageRange = "Adult (Ages 17 and over)";
        c2.ageRange = "Adult (Ages 17 and over)";
        c3.ageRange = "Seniors (Ages 62 and over)";
        c4.ageRange = "Young Adults (Age 13-16)";
        c5.ageRange = "Young Adults (Age 13-16)";

        c1.birthDate = "01/06/1992";
        c2.birthDate = "03/24/1989";
        c3.birthDate = "09/09/1964";
        c4.birthDate = "12/02/2005";
        c5.birthDate = "12/15/2003";

        c1.cardNumber = 123;
        c2.cardNumber = 222;
        c3.cardNumber = 595;
        c4.cardNumber = 440;
        c5.cardNumber = 789;

        c1.cellNumber = "123456789";

        c1.city = "Little Neck";
        c2.city = "Stony Brook";
        c3.city = "Stony Brook";
        c4.city = "Washington D.C.";
        c5.city = "Albany";

        c2.email = "nicholaschen@gmail.com";
        c3.email = "fannydai@gmail.com";
        c4.email = "sophia@hotmail.com";
        c5.email = "arpita@yahoo.com";

        c1.noticePref = "Phone Call";
        c2.noticePref = "Email (default)";
        c3.noticePref = "Email (default)";
        c4.noticePref = "Email (default)";
        c5.noticePref = "Email (default)";

        c1.firstName = "Bob";
        c2.firstName = "Nicholas";
        c3.firstName = "Fanny";
        c4.firstName = "Sophia";
        c5.firstName = "Arpita";

        c1.homeDiff = true;
        c2.homeDiff = false;
        c3.homeDiff = true;
        c4.homeDiff = false;
        c5.homeDiff = false;

        c1.lastName = "Smith";
        c2.lastName = "Chen";
        c3.lastName = "Dai";
        c4.lastName = "Song";
        c5.lastName = "Abrol";

        c1.mailCard = true;
        c2.mailCard = true;
        c3.mailCard = false;
        c4.mailCard = true;
        c5.mailCard = false;

        c1.middleInitial = 'G';
        c2.middleInitial = 'S';
        c3.middleInitial = 'D';
        c4.middleInitial = 'C';
        c5.middleInitial = 'F';

        c1.phoneNumber = "987654321";

        c1.signedUp = false;
        c2.signedUp = true;
        c3.signedUp = false;
        c4.signedUp = false;
        c5.signedUp = false;

        c1.state = "NY";
        c2.state = "NY";
        c3.state = "NY";
        c4.state = "NY";
        c5.state = "NY";

        c1.streetAddress = "4130 247. St.";
        c2.streetAddress = "200 Circle Rd.";
        c3.streetAddress = "220 Circle Rd.";
        c4.streetAddress = "15590 Square Avenue";
        c5.streetAddress = "Homeless";

        c3.suffix = "Sr.";

        c1.zipCode = 12345;
        c2.zipCode = 44422;
        c3.zipCode = 99999;
        c4.zipCode = 98765;
        c5.zipCode = 11790;

        cardList[0] = c1;
        cardList[1] = c2;
        cardList[2] = c3;
        cardList[3] = c4;
        cardList[4] = c5;

        try {
            for (int i = 1; i < 6; i++) {
                String fileName = "Card" + i;
                FileOutputStream fileOut = new FileOutputStream(fileName + ".ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(cardList[i - 1]);
                out.close();
                fileOut.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Card[] deSerializeCards() {
        Card[] cardList2 = new Card[5];
        try {
            for (int i = 1; i < 6; i++) {
                String cardName = "Card" + i + ".ser";
                FileInputStream fileIn = new FileInputStream("Card" + i + ".ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                cardList2[i - 1] = (Card) in.readObject();
                in.close();
                fileIn.close();
            }
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            c.printStackTrace();

        }
        return cardList2;
    }
}
