/*****************************************************************************************
* - Project: Assignment 2
*
* - Author: Clyde Cartee
*
* - Compiler: javac 25.0.1
*
* - Date 1/23/25
*
* - Purpose: :This is a program to work with fractions without allowing the use of doubles. 
*
* - I used W3schools java documentation to help me with syntax
*************************************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* <Clyde Cartee>
* <W30648739>
********************************************************************/

public class CSCI271_Assignment2_ClydeLeeFisherCartee_W30648739 {

//Fraction class that creates an instance of every fraction
    public static class Fraction{

//public method for the main to create fraction
        public Fraction(int n, int d){
            this.numerator = n;
            this.denominator = d;

            if (this.denominator < 0){ this.denominator *=-1;  this.numerator*=-1;}

            int GCD = this.GCD(this.numerator,this.denominator);

            this.numerator = this.numerator/GCD;
            this.denominator = this.denominator/GCD;
        }

//override if only one number is put in / no input
        public Fraction(int n){
            this(n,1);
        }
//default fraction
        public Fraction(){
            this(0,1);
        }

        @Override
        public String toString(){

            if (this.denominator == 0){
                if (this.numerator > 0){
                    return "infinity";
                }
                else{
                    return "-infinity";
                }
            }

            if(this.numerator == 0 && this.denominator ==0) return "NaN";

            if(this.denominator == 1) return String.valueOf(this.numerator);

            return this.numerator + "/" + this.denominator;
        }
// Math Functionality of the program
 //       public Fraction add(){

//        }



//private variables------------------------------------------
        
//default values for num and den
        private int numerator;
        private int denominator;

        private int GCD(int n, int d){

            if (n < 0) n = -n;

            while (d != 0){
                int r = n%d;
                n = d;
                d = r;
            }

            if (n == 0) n = 1;

            return n;


        }
        
    } 




    public static void main(String[] args){

        Fraction fr = new Fraction(8,-6);
        Fraction fr2 = new Fraction(-1,0);
        Fraction fr3 = new Fraction(7);
        Fraction fr4 = new Fraction(6,0);

        System.out.println(fr.toString());
        System.out.println(fr2.toString());
        System.out.println(fr3.toString());
        System.out.println(fr4.toString());

    }

    
}