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
            if (d < 0){ d *=-1;  n*=-1;}
            int GCD = GCD(n,d);
            setHigh(n/GCD);
            setLow(d/GCD);
        }

//override if only one number is put in / no input
        public Fraction(int n){
            this(n,1);
        }

//default fraction
        public Fraction(){
            this(0,1);
        }

//toString is already attached to object, override and test cases that need to return string values other than int value uses 
        @Override
        public String toString(){
            if(getHigh() == 0 && getLow() ==0) return "NaN";
            if (getLow() == 0){
                if (getHigh() > 0){
                    return "infinity";
                }
                else{
                    return "-infinity";
                }
            }
            if(getLow() == 1) return String.valueOf(getHigh());
            return getHigh() + "/" + getLow();
        }

// Math Functionality of the program

//Dividing is just multiplying the fractions while flipping the divisor so i create a new fraction object and send to multiply to return
    public Fraction divide(Fraction Divisor){
        Fraction divFlip = new Fraction (Divisor.getLow(),Divisor.getHigh());
        return multiply(divFlip);
   }

//Returns a Fraction object that has been multiplyed and keeps the current fraction from being changed
    public Fraction multiply(Fraction mult){
        return new Fraction(
            this.getHigh() * mult.getHigh(),
            this.getLow() * mult.getLow()
        );
    }

//Adds two fractions together by finding greatest common denominator and returning a new Fraction object


//-----------------------------private variables------------------------------------------
        
        private int numerator;
        private int denominator;

//get and set methods
        private int getHigh(){
            return this.numerator;

        }
        private int getLow(){
            return this.denominator;
        }

        private void setHigh(int changeHigh){
            this.numerator = changeHigh;
        }

        private void setLow(int changeLow){
            this.denominator = changeLow;
        }

//finds Greatest Common divisable to use for fraction simplication
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

        private int ComDen(Fraction Frac1, Fraction Frac2){

        }
    } 

    public static void main(String[] args){

        Fraction fr = new Fraction(8,-6);
        Fraction fr2 = new Fraction(-1,0);
        Fraction fr3 = new Fraction(7);
        Fraction fr4 = new Fraction(8,-6).divide(fr);

        System.out.println(fr.toString());
        System.out.println(fr2.toString());
        System.out.println(fr3.toString());
        System.out.println(fr4.toString());

    }

    
}