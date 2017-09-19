#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;
int expression();
bool opertr();
int paranthesis();
int digit();
int chars();
int chars1();
int unifier_chars();
int unifier_digit();
int P(int t);
int equalcheck();
string line;
int i,value;
int counter;
int counter1;
int main()
{
    ifstream fin("input.txt");
    ofstream fout("output.txt", ios::out | ios::app);
        if(!fin.is_open()){
            cout<<"Sorry, file not found";
            }
        else{
            while(fin.good()){
                i=0;value = 0;
                counter=0;
                counter1=0;
                getline(fin, line);
                if(line.length()==0){
                  break;
                 }
                 fout<<"String from file: "<<line<<endl;
                 cout<<"String from file: "<<line<<endl;

            if(expression()!=false && i==line.length()){

                cout<<"The string, "<<line<<", is in the language\n\n";
                fout<<"The string, "<<line<<", is in the language\n\n";
                }
            else{
                cout<<"The string, "<<line<<", is not in the language\n\n";
                fout<<"The string, "<<line<<", is not in the language\n\n";
                }
            }
        }
    fin.close();
    return 0;
}

int expression()
{
if(P(false)!=false){ // checking for first character of the expression...if it is true than move to if statement.
   if(i==line.length()) // check if length of line == to i; then make the expression true
       return true;
    else
        {
       if(opertr()){// operator
            int k;
            k =i;

           if(line[i]==line[k++]){
                if (line[k]=='+'){
                return false;
                }
                else if(line[k]=='*'){
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
       else if(line[i]==')'){
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

int P(int t)
{
    if(chars()!=false){
       if(t==false){
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
   if(t==false){
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
       if(t==false)
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
       if(t==false){
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
       if(t==false)
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
       else if(t==1)
               return expression();

           else
               return false;
   return false;
}
int digit()                                      /////digit check
{
   value=i;
   while(value<line.length()){
       if(line[value]>='0'&&line[value]<='9')
           value++;
       else
           break;
   }
   if(value==i)
       return false;
   else
       return true;
}
int paranthesis(){                            ////paranthesis
   value=i;
   while(value<line.length()){
        if(line[value]>='a'&&line[value]<='z'){
            value++;
            i=value;
       }

       if(line[value]=='('){
           value++;
           i=value;
           counter++;}
       else if(line[value]==')'){
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
int chars(){                                 ////chars check
   value=i;
   while(value<line.length()){
       if(line[value]>='a'&&line[value]<='z')
           value++;
       else
           break;
   }
   if(value==i)
       return false;

   else
        return true;

}
int chars1(){
 if(line[value]>='a'&&line[value]<='z')
 {
    return true;
 }

 else{
    return false;}
}
int unifier_chars(){
   value=i;
   int t=i;
   if(value<line.length()&&(line[value]=='+'||line[value]=='-'||line[value]=='!'))
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

int unifier_digit(){
   value=i;
   int t=i;
   if(value<line.length()&&(line[value]=='+'||line[value]=='-'||line[value]=='!'))
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

bool opertr(){
 if(line[i]=='+'||line[i]=='-'||line[i]=='*'||line[i]=='/')
 {
    return true;
 }
 else{
    return false;}
}
//
