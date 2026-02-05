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

//default values for num and den
        private int numerator = 0;
        private int denominator = 1;

//public method for the main to create fraction
        public Fraction(int n, int d){
            this.numerator = n;
            this.denominator = d;

            this.print();
        }

//override if only one number is put in / no input
        public Fraction(int n){
            this.numerator = n;
            this.print();
        }
        public Fraction(){
            this.print();
        }

//print method
        private void print(){
            System.out.println(this.numerator + "/" + this.denominator);
        }
        
    } 




    public static void main(String[] args){

        Fraction fr = new Fraction();
        Fraction fr2 = new Fraction(17);
        Fraction fr3 = new Fraction(2,4);

    }

    
}