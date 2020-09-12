/* SELF ASSESSMENT 
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment:
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:
Did I return the correct item?
Mark out of 5: 5 
Comment:
   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment:
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2.5
Comment:
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment:
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment:
   3.  sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:
Did I make calls to other methods?
Mark out of 5: 5
Comment:      
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment:
   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment:
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: 
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:    
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:        
Did I ensure the parameter to be used is not null?  
Mark out of 3:3 
Comment:
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment:
   6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments:
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment:  
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment:  
   7.  Overall
Is my code indented correctly?
Mark out of 4:4 
Comments:
Do my variable names make sense?
Mark out of 4: 4
Comments:
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments:
      Total Mark out of 100 (Add all the previous marks): 
 */
import java.util.Scanner;
import java.lang.Math;
public class SieveOfEratosthenes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter int>=2: ");
		int numberLimit = input.nextInt();

		int arrayOfIntegers[]=new int[numberLimit-1];
		arrayOfIntegers=sieve(numberLimit);
	}

	public static int[] createSequence(int N){
		int arrayOfIntegers[]=new int[N-1];
		int firstNumber =2;
		for(int i =0; i<N-1; i++) {
			arrayOfIntegers[i]= firstNumber++;
		}
		return arrayOfIntegers;
	}
	public static int[] crossOutHigherMultiples(int arrayOfIntegers[], int nextMultiple) {

		int i = 0;

		if (nextMultiple==2) {
			i=nextMultiple;
		}
		else if (nextMultiple==3){
			i=nextMultiple+1;
		}
		else {
			i=nextMultiple-2;
		}
		for(int n=i; n<arrayOfIntegers.length;n+=nextMultiple) {
			if (((arrayOfIntegers[n])%nextMultiple == 0) && (nextMultiple != arrayOfIntegers[n])) {

				arrayOfIntegers[n]=1;
			}
		}
		return arrayOfIntegers;
	}
	public static int[] sieve(int n) {
		int arrayOfIntegers[] = new int[n];
		arrayOfIntegers = createSequence(n);
		System.out.println(sequenceToString(arrayOfIntegers));

		for(int nextMultiple= 2; nextMultiple< Math.sqrt(n+1); nextMultiple++ ) {
			arrayOfIntegers = crossOutHigherMultiples(arrayOfIntegers, nextMultiple);
			System.out.println(sequenceToString(arrayOfIntegers));
		}
		System.out.println(nonCrossedOutSubSeqToString(arrayOfIntegers));
		return arrayOfIntegers;
	}
	public static String sequenceToString (int sequence[]) {
		String primedSequence= " ";
		for(int i =0; i<sequence.length; i++) {
			if(sequence[i]==1) {
				primedSequence += ", [" + (i+2)+ "]";
			}
			else {
				primedSequence += ", "+sequence[i];
			}
			if (sequence[i]==2) {
				primedSequence= "[2";
			}
		}
		primedSequence+=  "]";
		return primedSequence;
	}
	public static String nonCrossedOutSubSeqToString(int sequence[]) {
		String crossedOutString="";
		for(int i =0; i<sequence.length; i++) {
			if (sequence[i]==1) {
				crossedOutString+="";
			}
			else {
				crossedOutString +=", "+sequence[i];
			}
			if (sequence[i]==2) {
				crossedOutString= "[2";
			}
		}
		crossedOutString+= "]";
		return crossedOutString;
	}
}
