
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	public static int counter;
	public static int counter1;
	public static String line;
	public static int i;
	public static int value;
	public static boolean z;



	public static void main(final String[] args) throws FileNotFoundException{

		//Use of Scanner to retrieve a file

		try{
			Scanner getFile = new Scanner(new File("input.txt"));
			File newFile = new File("output.txt");
			newFile.createNewFile();
			FileWriter filew = new FileWriter(newFile);
			BufferedWriter buffw = new BufferedWriter(filew);

			//Loop to iterate through a file
			while(getFile.hasNextLine()){
				i=0;value = 0;
				counter=0;
				counter1=0;
				line = getFile.nextLine();

				//to eliminate whitespace
				if(line.trim().length() > 0){


					System.out.println(line);
					if (expression()!= false && i <= line.length())
					{
						buffw.write("The string, "+ line +", is in the language\n");
						System.out.println("The string read from file: "+line);
						System.out.println("The string, "+ line +", is in the language\n");
					}
					else
					{
						buffw.write("The string, "+ line +", is in not the language\n");
						System.out.println("The string read from file: "+line);
						System.out.println("The string, "+line+", is not in the language\n");
					}
				}
			}
			getFile.close();
			buffw.close();


		}
		catch(Exception e)
		{
			System.out.println("File not found!!\n");
			e.printStackTrace();
			System.exit(0);
		}

	}//end of main
	public static boolean expression()
	{
		if(P(0)!=false){ // checking for first character of the expression...if it is true than move to if statement.
			if(i==line.length()) // check if length of line == to i; then make the expression true
				return true;
			else
			{
				if(opertr()){// operator
					int k;
					k =i;


					if(line.charAt(i)==line.charAt(k++)){
						if (k==line.length()){
							return false;
						}
						if (line.charAt(k)=='+'){
							return false;
						}
						else if(line.charAt(k)=='*'){
							i=k++;
							i++;

							if(P(1)!=false)
								return true;
						}
						else
						{
							i++;
							if(i==line.length()){
								return false;}
							if(P(1)!=false)
								return true;
						}
					}
				}
				else if(line.charAt(i)==')'){
					paranthesis();
					if(counter==counter1 && i==line.length()){
						return true;
					}
					else{
						if(opertr())    {
							i++;
							if(P(1)!=false)
								return true;
						}
					}
				}
			}
		}//end of P(false) if statement
		return false;
	}//end of expression()

	public static boolean P(int j)
	{
		if(chars()!=false){
			if(j==0){
				i=value; // i will get value
				return true;
			}
			else{
				if(value==line.length()){
					i=value;
					return true;
				}
				else
					return expression();
			}

		}
		else if(paranthesis()!=false){
			if(j==0){
				i=value; // i will get value
				return true;
			}
			else{
				if(value==line.length()){
					i=value;
					return true;
				}
				else
					return expression();
			}

		}
		else if(digit()!=false){
			if(j==0)
			{
				i=value;
				return true;
			}
			else
			{
				if(value==line.length()){
					i=value;
					return true;
				}
				else
					return expression();
			}
		}
		else if(unifier_chars()!=false){
			if(j==0){
				i=value;
				return true;
			}
			else
			{
				if(value==line.length()){
					i=value;
					return true;
				}
				else
					return expression();
			}
		}
		else if(unifier_digit()!=false)
		{
			if(j==0)
			{
				i=value;
				return true;
			}
			else
			{
				if(value==line.length())
				{
					i=value;
					return true;
				}
				else
					return expression();
			}
		}
		else if(j==1)
			return expression();

		else
			return false;

	}
	public static boolean digit()                                      /////digit check
	{
		value=i;
		while(value<line.length()){
			if(line.charAt(value)>='0'&&line.charAt(value)<='9')
				value++;
			else
				break;
		}
		if(value==i)
			return false;
		else
			return true;
	}
	public static boolean paranthesis(){                            ////paranthesis
		value=i;
		while(value<line.length()){
			if(line.charAt(value)>='a'&& line.charAt(value)<='z'){
				value++;
				i=value;
			}

			if(line.charAt(value)=='('){
				value++;
				i=value;
				counter++;}
			else if(line.charAt(value)==')'){
				value++;
				i=value;
				counter1++;
			}

			else
				break;
		}
		if(i==line.length()&& counter==counter1){
			return true;
		}
		else
			return false;

	}
	public static boolean chars(){                                 ////chars check
		value=i;
		while(value<line.length()){
			if(line.charAt(value)>='a'&&line.charAt(value)<='z')
				value++;
			else
				break;
		}
		if(value==i)
			return false;

		else
			return true;

	}
	public static boolean chars1(){
		if(line.charAt(value)>='a'&& line.charAt(value)<='z')
		{
			return true;
		}

		else{
			return false;}
	}
	public static boolean unifier_chars(){
		value=i;
		int t=i;
		if(value<line.length()&&(line.charAt(value)=='+'||line.charAt(value)=='-'||line.charAt(value)=='!'))
		{
			value++;
			i=value;
			if(chars()!=false)
			{
				i=value;
				return true;
			}
		}
		i=t;
		return false;
	}

	public static boolean unifier_digit(){
		value=i;
		int t=i;
		if(value<line.length()&&(line.charAt(value)=='+'||line.charAt(value)=='-'||line.charAt(value)=='!'))
		{
			value++;
			i=value;
			if(digit()!=false){
				i=value;
				return true;
			}
		}
		i=t;
		return false;
	}

	public static boolean opertr(){
		if(line.charAt(i)=='+'||line.charAt(i)=='-'||line.charAt(i)=='*'||line.charAt(i)=='/')
		{
			return true;
		}
		else{
			return false;}
	}
	//

}

