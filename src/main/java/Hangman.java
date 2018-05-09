import java.io.*;
import java.util.Random;

public class Hangman {
    
    private char[] word;
    Console myConsole =  System.console();
    int guessMade;
    int score;
    int guess;

    public static char[] star;
    public static void main (String args[]){
      
        Hangman randomWord = new Hangman();
        randomWord.selectCar(); //selecting a random car.
        randomWord.start();

    }

    public void selectCar(){
        Random c = new Random();
        String[] car = {"toyota","mercedes","buggatti","maserati","lamboghini","suzuki","opel","volkswagen","lotus","bmw"};
        int y = c.nextInt(car.length);
        String carSelected = car[y];
        word = carSelected.toCharArray();//breaks car selected into  separate characters
        System.out.println("Guess the ride you will drive today");
    }

    public void start(){
        int length = word.length;
        System.out.println("HINT:the ride's name has " + length + " letters");
        
        // the game's code
     guessMade = 0;
     int lengthOfWord = word.length;
     score = 0;
     guess = 10;
     char[] car = new char[lengthOfWord];
     for(int i=0;i<lengthOfWord;i++){
         car[i] = '_';//fills array with an underscore    
     }
     String answer = new String(car);//converts the created array into a string
     StringBuilder output = new StringBuilder(answer);
     for(int j=0;j<11;j++){
         System.out.println("guess a letter");
         String guessedLetter = myConsole.readLine();
         char firstLetter = guessedLetter.charAt(0);
         System.out.println("Letter selescted:" + firstLetter + "\r\n you have" + guess + "left");
         for(int k=0;k<lengthOfWord;k++){
             if (firstLetter==word[k]){
                 output.setCharAt(k, firstLetter);//changes the undescore into a letter if the correct letter is input
                 System.out.println(output + "\r\n");
                 score++;//adds the score per correct  letter guess
                }  
             }

             guessMade++;
             guess--;
             if(score == lengthOfWord){
                 System.out.println("Apo sawa!! Enjoy you ride! it is " + output);
                 j = 11;
             }
             if(guessMade == 11){
                 System.out.println("You lost your ride. Try again?");
             }
         }
     }


    }


