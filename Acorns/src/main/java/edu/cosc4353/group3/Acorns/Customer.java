package edu.cosc4353.group3.Acorns;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Customer {
    private String user;
	private String passwd;
	private String card;
	private double accountBalance;
	private int portIdent;
	private String AccountTypeCOrP;

	private char[] ports;
    private String accountChoice;
    
    private boolean isInvested;
    private double[] stockData, bondData;
    private int InvArray_Length;

        File file = new File("");
        public static final int PASS_LENGTH = 6;

	public Customer(String username, String password, String cardNumber,int portIndent, double balance, String AccountType, boolean isInvest,
					double[] stock, double[] bond, int SD_Length) {
		user = username;
		passwd = password;
		card = cardNumber;
		accountBalance = balance;
		portIdent = portIndent;
		AccountTypeCOrP = AccountType;
		
		isInvested = isInvest;
		stockData = stock;
		bondData = bond;
		InvArray_Length = SD_Length;
		
		ports = new char[4];
	}
	
	public Customer() {
		user = "";
		passwd = "";
		card = "";
		ports = new char[4];
		AccountTypeCOrP= "";
	}
	
	public static String getCardNumberI(Customer c) {
            String temp= c.card;
            return temp;
	}
        
	public String getUser_Name() {
		return user;
	}
        
	public String getUser_Pass() {
		return passwd;
	}
	
	public String getUser_AccountType() {
		return AccountTypeCOrP;
	}
        
	public String getUser_CardNumb() {
		return card;
	}
	
	public double getUser_balance() {
		return accountBalance;
	}
	
	public int getUser_PortId() {
		return portIdent;
	}
        
	public void setUser_balance(double change) {
		accountBalance =  accountBalance + change;
	}
        
      
             
        public void setInvestData(double[] data, int dataType)  // 0 FOR BOND    1 FOR STOCK
        {
        	if (dataType == 0){	bondData = data;	}
        	else {	stockData = data;	}
        	
        }
        public double[] getInvestData(int dataType)  // 0 FOR BOND    1 FOR STOCK
        {
        	if (dataType == 0){	return bondData;	}
        	else {	return stockData;	}
        	
        }
        
        public void setStatus_Invest(boolean status)
        {
        	isInvested = status;
        }
        public boolean getStatus_Invest()
        {
        	return isInvested;
        }
        
        
        public void InvestArray_Length(int length)
        {
        	InvArray_Length = length;
        }
	
        
	public int getInvestArray_Length() {
		return InvArray_Length;
	}
	
	public void setCardNumber(Customer c ,String number) {
		c.card = number;
	}
        
	public static void setPortfolio(Customer c, int id) {
		c.portIdent = id;
	}
	
	public static int hashUsername(String username) {
		int nameLength = username.length();
		int user[] = new int[nameLength];
		int total = 0;
		
		for(int i = 0; i < nameLength; i++) {
			user[i] = username.charAt(i);
		}
		for(int i = 0; i < nameLength; i++) {
			total += user[i];
		}
		return((total)%5);
	}
	// Username hash to store and identify object
	public void storeUser() {
		
	}

        //Create New User Account
	public static boolean CreateAccountPersonal (String accountChoice) {
		Scanner input = new Scanner(System.in);
        System.out.println("User Creation! ");
        String username = "";
        String password = "";
        String cardId = "";
            
        boolean CreateError = true;
        while (CreateError) {
            System.out.println("Enter A Username: ");
             username = input.next();
            
            if (isNotUnique(username)){   
            	System.out.println("Username Taken, Try Again...." + "\n");
            }
            else { 
            	CreateError = false; 
            	System.out.println("Username Accepted!" + "\n"); 
            }
        }
        CreateError = true;
        while (CreateError) {
        	System.out.println("Enter A " + PASS_LENGTH + " Character password: ");
        	password = input.next();
                
        	if (password.length() != PASS_LENGTH){ 
        		CreateError = true; 
        			System.out.println("Password Length Error, Try Again...." + "\n");
        	}
            else {  
            	CreateError = false; 
            	System.out.println("Password Accepted, Account Created!" + "\n");
            }
        }
        System.out.println("Card Registration");
        System.out.println("------------------");

        cardId = CreditCardValidation.initializeCard();
        System.out.println("------------------");

           // CreateError = true; //Smeets Code Here
           // while(CreateError)
           // {
            //    System.out.println("Enter a 16 digit Debit Card number: ");
            //    cardId = input.next();
                
             //   if (cardId.length() < 16) { CreateError = true; System.out.println("Card Number Error.....");   }
             //   else {  CreateError = false;    }
            //}
            
            //Enter Card Info Here

        System.out.println("Card id: " + cardId); 
        StoreUserData(username, password, cardId, accountChoice); //Add card Argument
        System.out.println("------------------");

        return true;
	}
        
        
    public static boolean CreateAccountCorporate ( String accountChoice) {
        Scanner input = new Scanner(System.in);
        System.out.println("User Creation! ");
        String username = "";
        String password = "";
        String cardId = "";
            
        boolean CreateError = true;
        while (CreateError) {
            System.out.println("Enter A Username: ");
            username = input.next();
            if (isNotUnique(username)){
            	System.out.println("Username Taken, Try Again...." + "\n");
            }
            else { 
            	CreateError = false; 
            	System.out.println("Username Accepted!" + "\n"); 
            }
        }
        CreateError = true;
        while (CreateError) {
        	System.out.println("Enter A " + PASS_LENGTH + " Character password: ");
        	password = input.next();
                
        	if (password.length() != PASS_LENGTH){ 
        		CreateError = true; 
        		System.out.println("Password Length Error, Try Again...." + "\n");
        	}
        	else {  
        		CreateError = false; 
        		System.out.println("Password Accepted, Account Created!" + "\n");
        	}    
        }
        System.out.println("Card Registration");
        System.out.println("------------------");

        cardId = CreditCardValidation.initializeCard();
        System.out.println("------------------");

           // CreateError = true; //Smeets Code Here
           // while(CreateError)
           // {
            //    System.out.println("Enter a 16 digit Debit Card number: ");
            //    cardId = input.next();
                
             //   if (cardId.length() < 16) { CreateError = true; System.out.println("Card Number Error.....");   }
             //   else {  CreateError = false;    }
            //}
            
            //Enter Card Info Here
        System.out.println("Card id: " + cardId); 
        StoreUserData(username, password, cardId, accountChoice); //Add card Argument
        System.out.println("------------------");

            return true;
        }
        
        //Store Accepted User Login Data in .txt
        public static void StoreUserData(String user, String pass, String cardNumb, String accountChoice)
        {
            String Storage = user + " " + pass + " " + cardNumb + " " + "-1" + " "+ "0" + " " + accountChoice; //user0 pass1 cardNo2 portfolio3 accountStatus4
            System.out.println(Storage);
            
            try
            {
                String filename = "LoginInfo.txt";
                BufferedWriter  outP;
                outP = new BufferedWriter(new FileWriter(filename, true));

                
    		outP.newLine(); 
    		outP.append(Storage);
    		outP.close();
    	} catch(IOException ioe) {
                System.err.println("IOException: " + ioe.getMessage());
    	}
	}
        //Check Originality of Username
	public static boolean isNotUnique(String UserInput) {
		File file = new File("LoginInfo.txt");
		try {    
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String TempScan = sc.next();
                if (UserInput.equals(TempScan)) {// write first word from line
                    return true;
                }
                else{   
                	sc.nextLine();  
                }
            }
        } catch (IOException e) { 
        	e.printStackTrace();    
        }
        return false;
    }
        //Check User Existance in .txt
}

