/*****************************************************************************************
* - Project: Assignment 2
*
* - Author: Clyde Cartee
*
* - Compiler: javac 25.0.1
*
* - Date 2/06/25
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
    public Fraction add(Fraction addFrac){
        int num;
        int den;
//if same base just adds and gives new Fraction object else it multiplies to get common denominators and returns fraction object (this simplifies itself when created)
        if(this.getLow() == addFrac.getLow()){
            num = this.getHigh() + addFrac.getHigh();
            den = this.getLow();
            return new Fraction(num,den);
        }
        else{
            den = this.getLow() * addFrac.getLow();
            num = (this.getHigh() * addFrac.getLow()) + (addFrac.getHigh() * this.getLow());
            return new Fraction(num,den);
        }
    
    }

//Subtraction is simmilar to addition in process of solving
    public Fraction subtraction(Fraction subFrac){
        int num;
        int den;

//if same base just subtracts and gives new Fraction object else it multiplies to get common denominators and returns fraction object (this simplifies itself when created)
        if(this.getLow() == subFrac.getLow()){
            num = this.getHigh() - subFrac.getHigh();
            den = this.getLow();
            return new Fraction(num,den);
        }
        else{
            den = this.getLow() * subFrac.getLow();
            num = (this.getHigh() * subFrac.getLow()) - (subFrac.getHigh() * this.getLow());
            return new Fraction(num,den);
        }
    
    }

//Negate I just multiply current fraction by -1
    public Fraction negate(){
        return new Fraction(-1 * this.getHigh(),this.getLow());
    }

//Fraction Pow calls multiplication over and over for value n
    public Fraction pow(int n){
        //anything to 0 is 1
        if(n == 0){
            return new Fraction(1);
        }
        //does the absolute value of n if negetive then divides 1 by the found number to make it the reciprical to find the value properly
        else if (n < 0) {
        
        n *= -1;
        Fraction toMultiply = new Fraction(this.getHigh(),this.getLow());

        for(int i = 1;i<n;i++){
            toMultiply = toMultiply.multiply(new Fraction(this.getHigh(),this.getLow()));
        }

        toMultiply = new Fraction(1,1).divide(toMultiply);
        return toMultiply;
            
        }else{
//if no special cases it finds it normally(I know there is a redundancy in code here that I might fix later)
        Fraction toMultiply = new Fraction(this.getHigh(),this.getLow());
        for(int i = 1;i<n;i++){
            toMultiply = toMultiply.multiply(new Fraction(this.getHigh(),this.getLow()));
        }
        return toMultiply;
        }
    }


//-----------------------------private variables------------------------------------------------------//

//individual numerators and denominators for each fraction object created       
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
    } 

//------------------------------------main program----------------------------------------------------------//
    public static void main(String[] args){
//Completes the first example problem and shows values arent altered through calculation
        System.out.println("This is the assignment example:");
        Fraction a = new Fraction(16);
        Fraction b = new Fraction(3,5).add(new Fraction(7));
        Fraction c = new Fraction(6,7);
        Fraction results = c.multiply(a.divide(b));
        System.out.println(results);

//Shows each of the examples for task 2
        Fraction fr = new Fraction(8,-6);
        Fraction fr2 = new Fraction(23,0);
        Fraction fr3 = new Fraction(-6,0);
        Fraction fr4 = new Fraction(7,1);
        Fraction fr5 = new Fraction(0,0);
//goes through the methods that are straight forward
        Fraction fr6 = new Fraction(1,2).divide(new Fraction(1,4));
        Fraction fr7 = new Fraction(1,2).multiply(new Fraction(6));
        Fraction fr8 = new Fraction(1,2).add(new Fraction(1,2));
        Fraction fr9 = new Fraction(1,2).subtraction(new Fraction(1,2));
        Fraction fr10 = new Fraction(1,2).negate();
        Fraction fr11 = new Fraction(1,2).pow(4);
//tests negate against NaN and infinity
        Fraction fr12 = fr3.negate();
        Fraction fr13 = fr5.negate();
//shows different pow capabilities and odd cases
        Fraction fr14 = new Fraction(1,2).pow(0);
        Fraction fr15 = new Fraction(1,2).pow(-1);
        Fraction fr16 = new Fraction(1,2).pow(-3);
        Fraction fr17 = new Fraction(2).pow(-3);
//show forgotten task one examples
        Fraction fr18 = new Fraction(6,-24);
        Fraction fr19 = new Fraction(0,8);
//shows I also created a defalt fraction through class chaining
        Fraction fr20 = new Fraction();


//all of the outputs for above Fraction objects
        System.out.println();
        System.out.println("Task 1 Examples:");
        System.out.println(fr18.toString());
        System.out.println(fr19.toString());
        System.out.println();
        System.out.println("Task 2 examples:");
        System.out.println(fr.toString());
        System.out.println(fr2.toString());
        System.out.println(fr3.toString());
        System.out.println(fr4.toString());
        System.out.println(fr5.toString());
        System.out.println();
        System.out.println("Shows off each one of the methods:");
        System.out.println(fr6.toString());
        System.out.println(fr7.toString());
        System.out.println(fr8.toString());
        System.out.println(fr9.toString());
        System.out.println(fr10.toString());
        System.out.println(fr11.toString());
        System.out.println();
        System.out.println("tests NaN and Infinity negates:");
        System.out.println(fr12.toString());
        System.out.println(fr13.toString());
        System.out.println();
        System.out.println("Shows odd pow cases");
        System.out.println(fr14.toString());
        System.out.println(fr15.toString());
        System.out.println(fr16.toString());
        System.out.println(fr17.toString());
        System.out.println();
        System.out.println("Default fraction to being empty object built:");
        System.out.println(fr20.toString());
    }

    
}