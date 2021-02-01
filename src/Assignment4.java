//Jacob Vesche
// Assignment 4
// "I have neither given nor received unauthorized aid in completing this work, nor have I presented someone else's work as my own."
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
// 1234 Joe Smith 123.90 12-11-2019 1 4 7 3 4
public class Assignment4 extends JFrame implements ActionListener {
	
	public static Vector firstV = new Vector(),lastV = new Vector(),userV = new Vector(),prod1 = new Vector(),prod2 = new Vector(),prod3 = new Vector(),prod4 = new Vector(),prod5 = new Vector(),dateV = new Vector(),totalV = new Vector(); 
	public static boolean newUser = false, wrong = true;
	public static int customerId;
	public static int[] productId = new int[5];
	public static int product1,product01,product02,product03,product04,product05;
	public static int product2;
	public static int product3;
	public static int product4;
	public static int product5;
	public static double price, price01; 
	public static double[] productPrice = new double[5];
	
	public static int b = 0;
	
	public static String firstName, customerId01, lastName, date, firstName01, lastName01, date01;
	public static String[] productName = new String[5];
	public static String[] productDescription = new String[5];
	
	
	private JLabel payingFullL, payingFullYN, enterName, calcL, pencilL, gumL, tabletL, binderL, custL, firstL, lastL, priceProd1, priceProd2, priceProd3, priceProd4, priceProd5;
	private JButton buyExport, pencilDes, calcDes, gumDes, tabletDes, binderDes;
	
	private JTextField payingFullTxt, name, calcTxt, pencilTxt, gumTxt, tabletTxt, binderTxt,custTxt, firstTxt, lastTxt;
	
	
	private JButton click, buy;
	private JButton click2;
	private String userId = "";
	public static String[] customerId1;
	
	public static java.io.File fileProducts = new java.io.File("products.txt");
	public static java.io.File exportFile;
	public static File fileUsers = new File("Users.txt");
	public static PrintWriter output;
	public static PrintWriter exportFile1, outputFinal;
	public static String[] firstName1; 
	public static String[] lastName1; 
	public static double[] price1; 
	public static String[] date1;
	public static int[] product11, product21, product31, product41, product51;
	public static Scanner input4;
	public Assignment4() {
		setLayout(null);
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enterName = new JLabel("Enter Customer ID ");
		click = new JButton("Sumbit");
		click2 = new JButton("Purchase Products");
		
		name = new JTextField();
		enterName.setBounds(90,30,120,30);
		name.setBounds(80,60,130,30);
		click.setBounds(100,120,90,30);
		click.addActionListener(this);
		
		click2.setBounds(50,160,190,30);
		
		add(click);
		add(name);
		add(enterName);
		
		
		OKListenerClass listener1 = new OKListenerClass();
		
		click2.addActionListener(listener1);
		add(click2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == click) {
			boolean found = false;
			userId = name.getText();
			for (int j = 0; j < b; j++) {
				if (userId.equals(customerId1[j])) {
					found = true;
					
					JOptionPane.showMessageDialog(null, "Hello " + firstName1[j] + " " + lastName1[j] + " User ID: " + customerId1[j] + "\n"
							 + "Total Value of last transaction: $" + price + "\n" + 
							"Number of items purchased:\n" + 
							"Calculator: " + product1 + "\n" + 
							"Pencil: " + product2 + "\n" + 
							"Binder: " + product3 + "\n" + 
							"Tablet: " + product4 + "\n" +
							"Gum: " + product5 + "\n"
							);
				}
				
			}
			if(!found) {
				
				JOptionPane.showMessageDialog(null, "Invalid User ID: " + userId);
			}
		}
	}
	class OKListenerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			setLayout(null);
			setSize(700,600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			custL= new JLabel("Customer ID ");
			firstL= new JLabel("First Name ");
			lastL= new JLabel("Last Name ");
			
			pencilDes = new JButton("Pencil Description");
			calcDes= new JButton("Calculator Description");
			gumDes= new JButton("Gum Description");
			tabletDes = new JButton("Tablet Description");
			binderDes= new JButton("Binder Description");
			
			calcDes.setBounds(300,220,160,30);
			pencilDes.setBounds(300,260,160,30);
			gumDes.setBounds(300,300,160,30);
			tabletDes.setBounds(300,340,160,30);
			binderDes.setBounds(300,380,160,30);
			
			priceProd1 = new JLabel("$" + productPrice[0]+"0");
			priceProd2 = new JLabel("$"+ productPrice[1]+"0");
			priceProd3 = new JLabel("$"+ productPrice[2]+"0");
			priceProd4 = new JLabel("$"+ productPrice[3]+"0");
			priceProd5 = new JLabel("$"+ productPrice[4]+"0");
			payingFullYN = new JLabel("Yes = 1, No = 0");
			
			priceProd1.setBounds(500,220,130,30);
			priceProd2.setBounds(500,260,130,30);
			priceProd3.setBounds(500,300,130,30);
			priceProd4.setBounds(500,340,130,30);
			priceProd5.setBounds(500,380,130,30);
			payingFullYN.setBounds(300,420,130,30);
			
			
			custL.setBounds(60,60,120,30);
			firstL.setBounds(60,100,120,30);
			lastL.setBounds(60,140,120,30);
			
			
			custTxt= new JTextField();
			firstTxt= new JTextField();
			lastTxt= new JTextField();
			custTxt.setBounds(150,60,130,30);
			firstTxt.setBounds(150,100,130,30);
			lastTxt.setBounds(150,140,130,30);
			
			payingFullTxt = new JTextField();
			calcTxt= new JTextField();
			pencilTxt = new JTextField(); 
			gumTxt= new JTextField();
			tabletTxt = new JTextField();
			binderTxt = new JTextField();
			calcL= new JLabel("Calculators: ");
			pencilL = new JLabel("Pencils: ");
			gumL = new JLabel("Gum: ");
			tabletL = new JLabel("Tablets: ");
			binderL = new JLabel("Binders: ");
			buy = new JButton("Purchase");
			payingFullL = new JLabel("Pay in Full");
			buyExport = new JButton("Purchase and Export");
			
			buyExport.setBounds(200,460,170,30);
			payingFullTxt.setBounds(150,420,130,30);
			buy.setBounds(100,460,90,30);
			calcL.setBounds(60,220,120,30);
			pencilL.setBounds(60,260,120,30);
			gumL.setBounds(60,300,120,30);
			tabletL.setBounds(60,340,120,30);
			binderL.setBounds(60,380,120,30);
			
			calcTxt.setBounds(150,220,130,30);
			pencilTxt.setBounds(150,260,130,30);
			
			gumTxt.setBounds(150,380,130,30);
			tabletTxt.setBounds(150,340,130,30);
			binderTxt.setBounds(150,300,130,30);
			payingFullL.setBounds(60,420,120,30);
			add(pencilDes);
			add(calcDes);
			add(gumDes);
			add(tabletDes);
			add(binderDes);
			add(custL);
			add(firstL);
			add(lastL);
			add(custTxt);
			add(firstTxt);
			add(lastTxt);
			remove(click2);
			add(buy);
			remove(click);
			remove(name);
			remove(enterName);
			add(binderTxt);
			add(tabletTxt);
			add(pencilTxt);
			add(calcTxt);
			add(gumTxt);
			add(binderL);
			add(tabletL);
			add(pencilL);
			add(calcL);
			add(gumL);
			add(priceProd1);
			add(priceProd2);
			add(priceProd3);
			add(priceProd4);
			add(priceProd5);
			add(payingFullTxt);
			add(payingFullL);
			add(payingFullYN);
			add(buyExport);
			BuyListenerClass listener2 = new BuyListenerClass();
			pencilDesListenerClass listener3 = new pencilDesListenerClass();
			binderDesListenerClass listener4 = new binderDesListenerClass();
			calcDesListenerClass listener5 = new calcDesListenerClass();
			tabletDesListenerClass listener6 = new tabletDesListenerClass();
			gumDesListenerClass listener7 = new gumDesListenerClass();
			purchaseExportListenerClass listener8 = new purchaseExportListenerClass();
			
			
			pencilDes.addActionListener(listener3);
			binderDes.addActionListener(listener4);
			calcDes.addActionListener(listener5);
			tabletDes.addActionListener(listener6);
			gumDes.addActionListener(listener7);
			
			buyExport.addActionListener(listener8);
			buy.addActionListener(listener2);
		}
	}
	class BuyListenerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Purchased!");
			wrong = true;
			try {
				output = new PrintWriter(fileUsers);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 1234 Joe Smith 123.90 12-11-2019 1 4 7 3 4
			String userStr = custTxt.getText();
			String calcStr = calcTxt.getText();
			String binderStr = binderTxt.getText();
			String pencilStr = pencilTxt.getText();
			String tabletStr = tabletTxt.getText();
			String gumStr = gumTxt.getText();
			String payStr = payingFullTxt.getText();
			int calcInt = 0, userInt, binderInt = 0, gumInt = 0, pencilInt = 0, tabletInt = 0;
			try {
				userInt = Integer.parseInt(userStr);
			} catch(Exception e1) {
				System.out.println("Enter a correct Customer ID");
				wrong = false;
				JOptionPane.showMessageDialog(null, "Enter a correct Customer ID!");
				
			}
			
			try {
				calcInt = Integer.parseInt(calcStr);
				if(calcInt < 0) {
					JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for calculator!");
					wrong = false;
					
				}
			} catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for calculator!");
				wrong = false;
			}
			
			
			try {
				binderInt = Integer.parseInt(binderStr);
				if(binderInt < 0) {
					JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for binder!");
					wrong = false;
					
				}
			} catch(Exception e3) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for binder!");
				wrong = false;
			}
			
			
			try {
				pencilInt = Integer.parseInt(pencilStr);
				if(pencilInt < 0) {
					JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for pencil!");
					wrong = false;
					
				}
			} catch(Exception e4) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for pencil!");
				wrong = false;
			}
			
			
			try {
				tabletInt = Integer.parseInt(tabletStr);
				if(tabletInt < 0) {
					JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for tablet!");
					wrong = false;
					
				}
			} catch(Exception e4) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for tablet!");
				wrong = false;
			}
			
			
			try {
				gumInt = Integer.parseInt(gumStr);
				if(gumInt < 0) {
					JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for gum!");
					wrong = false;
					
				}
			} catch(Exception e4) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for gum!");
				wrong = false;
			}
			
			
			
			int payInt;
			boolean payFull = false;
			try {
				payInt = Integer.parseInt(payStr);
				if(payInt == 1) {
					payFull = true;
					
				}
				else if(payInt == 0){
					payFull = false;
				}
				else {
					wrong = false;
				}
			}catch(Exception e8) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for paying in full!");
				wrong = false;
			}
			
			
			
			
			double totalPriceF = getTotal(calcInt, pencilInt, binderInt, tabletInt, gumInt,productPrice, payFull);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
			LocalDateTime now = LocalDateTime.now();  

			newUser = true;
			if(wrong) {
				
			
				customerId01 = custTxt.getText();
				firstName01 = firstTxt.getText();
				lastName01 = lastTxt.getText();
				price01 = totalPriceF;
				date01 = dtf.format(now);
				product01 = product1;
				product02 = product2;
				product03 = product3;
				product04 = product4;
				product05 = product5;
				userV.add(customerId01);
				firstV.add(firstName01);
				lastV.add(lastName01);
				totalV.add(price01);
				dateV.add(date01);
				prod1.add(product01);
				prod2.add(product02);
				prod3.add(product03);
				prod4.add(product04);
				prod5.add(product05);
				try {
					addUser();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				System.out.println("Invalid Input");
			}
			output.close();
			
			JOptionPane.showMessageDialog(null,"Item Purchased!");
			System.exit(0);
			}
		}
	class pencilDesListenerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
				if(e.getSource() == pencilDes) {
					JOptionPane.showMessageDialog(null,"Pencil ID: " + productId[1] + "\nDescription:\n"
							+ productDescription[1]
							
							
							);
				}
			}
		}
	class purchaseExportListenerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			exportFile = new java.io.File("customer" +custTxt.getText() + ".txt");
			exportFile1 = null;
			wrong = true;
			
			try {
				exportFile1 = new PrintWriter(exportFile);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(exportFile.createNewFile()) {
					System.out.println("File was created!");
					
				}
				else {
					System.out.println("File is already created!");
					
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String userStr = custTxt.getText();
			String calcStr = calcTxt.getText();
			String binderStr = binderTxt.getText();
			String pencilStr = pencilTxt.getText();
			String tabletStr = tabletTxt.getText();
			String gumStr = gumTxt.getText();
			String payStr = payingFullTxt.getText();
			
			int calcInt = 0, userInt = 0, binderInt = 0, gumInt = 0, pencilInt = 0, tabletInt = 0;
			try {
				userInt = Integer.parseInt(userStr);
			} catch(Exception e1) {
				System.out.println("Enter a correct Customer ID");
				wrong = false;
				JOptionPane.showMessageDialog(null, "Enter a correct Customer ID!");
				
			}
			
			try {
				calcInt = Integer.parseInt(calcStr);
			} catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for calculator!");
				wrong = false;
			}
			
			if(calcInt < 0) {
				JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for calculator!");
				wrong = false;
				
			}
			try {
				binderInt = Integer.parseInt(binderStr);
			} catch(Exception e3) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for binder!");
				wrong = false;
			}
			
			if(binderInt < 0) {
				JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for binder!");
				wrong = false;
				
			}
			try {
				pencilInt = Integer.parseInt(pencilStr);
			} catch(Exception e4) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for pencil!");
				wrong = false;
			}
			
			if(pencilInt < 0) {
				JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for pencil!");
				wrong = false;
				
			}
			try {
				tabletInt = Integer.parseInt(tabletStr);
			} catch(Exception e4) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for tablet!");
				wrong = false;
			}
			
			if(tabletInt < 0) {
				JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for tablet!");
				wrong = false;
				
			}
			try {
				gumInt = Integer.parseInt(gumStr);
			} catch(Exception e4) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for gum!");
				wrong = false;
			}
			
			if(gumInt < 0) {
				JOptionPane.showMessageDialog(null, "Enter a number greater than 0 for gum!");
				wrong = false;
				
			}
			int payInt = 0;
			try {
				payInt = Integer.parseInt(payStr);
			}catch(Exception e8) {
				JOptionPane.showMessageDialog(null, "Enter a correct number for paying in full!");
				wrong = false;
			}
			
			boolean payFull = false;
			if(payInt == 1) {
				payFull = true;
				
				
			}
			else if(payInt == 0){
				payFull = false;
			}
			else {
				wrong = false;
			}
			double totalPriceF = getTotal(calcInt, pencilInt, binderInt, tabletInt, gumInt,productPrice, payFull);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
			LocalDateTime now = LocalDateTime.now();  
			
			
			
			if(wrong) {
				exportFile1.print(custTxt.getText() + " ");
				exportFile1.print(firstTxt.getText()+ " ");
				exportFile1.print(lastTxt.getText()+ " ");
				exportFile1.printf("%.2f ",totalPriceF);
				exportFile1.print(dtf.format(now) + " ");
				exportFile1.print(calcTxt.getText()+ " ");
				exportFile1.print(pencilTxt.getText()+ " ");
				exportFile1.print(binderTxt.getText()+ " ");
				exportFile1.print(tabletTxt.getText()+ " ");
				exportFile1.print(gumTxt.getText());
			}
			
			else {
				System.out.println("Invalid Input");
			}
			
			exportFile1.close();
			JOptionPane.showMessageDialog(null,"File exported!\nFile Name: customer" + custTxt.getText() + ".txt");
			System.exit(0);
			}
		}
	class binderDesListenerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == binderDes) {
				JOptionPane.showMessageDialog(null,"Binder ID: " + productId[2] + "\nDescription:\n"
						+ productDescription[2]
						
						
						);
				}
			}
		}
	class calcDesListenerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == calcDes) {
				JOptionPane.showMessageDialog(null,"Calculator ID: " + productId[0] + "\nDescription:\n"
						+ productDescription[0]
						
						
						);
				}
			}
		}
	class tabletDesListenerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tabletDes) {
				JOptionPane.showMessageDialog(null,"Tablet ID: " + productId[3] + "\nDescription:\n"
						+ productDescription[3]
						
						
						);
				}
			}
		}
	class gumDesListenerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == gumDes) {
				JOptionPane.showMessageDialog(null,"Gum ID: " + productId[4] + "\nDescription:\n"
						+ productDescription[4]
						
						
						);
				}
			}
		}
	
	public static double getTotal(int calcInt, int pencilInt, int binderInt, int tabletInt, int gumInt, double[] productPrice,boolean payFull) {
		double total = 0.0, temp = 0.0;
		
		if(calcInt > 9) {
			temp = productPrice[0] * .9;
		}
		else {
			temp = productPrice[0];
		}
		total += temp;
		if(pencilInt > 9) {
			temp = productPrice[1] * .9;
		}
		else {
			temp = productPrice[1];
		}
		total += temp;
		if(binderInt > 9) {
			temp = productPrice[2] * .9;
		}
		else {
			temp = productPrice[2];
		}
		total += temp;
		if(tabletInt > 9) {
			temp = productPrice[3] * .9;
		}
		else {
			temp = productPrice[3];
		}
		total += temp;
		if(gumInt > 9) {
			temp = productPrice[4] * .9;
		}
		else {
			temp = productPrice[4];
		}
		
		total += temp;
		
		if(payFull) {
			total = total * .95; // giving 5% off if paying in full
		}
		
		total = total * 1.06; // adding tax
		
		return total;
	}
	public void addUser() throws IOException {
		//Scanner input5 = new Scanner(fileUsers);
		outputFinal = new PrintWriter(fileUsers);
		FileWriter fileWrite = new FileWriter(fileUsers, false);
		BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
		PrintWriter write = new PrintWriter(bufferedWrite);
		
		if(newUser) {
			
			//System.out.println(input5.hasNext());
			
			for(int i = 0; i < userV.size();i++) {
				write.print(userV.get(i) + " ");
				write.print(firstV.get(i)+ " ");
				write.print(lastV.get(i)+ " ");
				write.print(totalV.get(i)+ " ");
				write.print(dateV.get(i)+ " ");
				write.print(prod1.get(i)+ " ");
				write.print(prod2.get(i)+ " ");
				write.print(prod3.get(i)+ " ");
				write.print(prod4.get(i)+ " ");
				write.print(prod5.get(i));
				if( i != (userV.size() - 1)) {
					write.println();
				}
				
			}
			
			
		}
		
		write.close();
		
	}
	public static void main(String[] args) throws java.io.IOException {
		
		
		
		if(fileProducts.createNewFile()) {
			System.out.println("File was created!");
			
		}
		else {
			System.out.println("File is already created!");
			
		}
		if(fileUsers.createNewFile()) {
			System.out.println("File was created!");
			
		}
		else {
			System.out.println("File is already created!");
			
		}
		 
		
		Scanner input = new Scanner(fileProducts);
		Scanner input1 = new Scanner(fileUsers);
		Scanner input2 = new Scanner(fileUsers);
		Scanner input6 = new Scanner(fileUsers);
		//System.out.println("input6 =" +input6.hasNext());
		int i = 0;
		while(input.hasNext()) {
			productId[i] = input.nextInt();
			productName[i] = input.next();
			productPrice[i] = input.nextDouble();
			productDescription[i] = input.nextLine();
			i++;
		}
		
		input.close();
		//System.out.println(productDescription[0]);
		
		
		
		
		while(input1.hasNext()){
			customerId = input1.nextInt();
			
			firstName = input1.next();
			
			lastName = input1.next();
			
			price = input1.nextDouble();
			
			date = input1.next();
			product1 = input1.nextInt();
			product2 = input1.nextInt();
			product3 = input1.nextInt();
			product4 = input1.nextInt();
			product5 = input1.nextInt();
			userV.add(customerId);
			firstV.add(firstName);
			lastV.add(lastName);
			totalV.add(price);
			dateV.add(date);
			prod1.add(product1);
			prod2.add(product2);
			prod3.add(product3);
			prod4.add(product4);
			prod5.add(product5);
			b++;
		}
		input1.close();
		int c = 0;
		
		firstName1 = new String[b];
		customerId1 = new String[b];
		lastName1 = new String[b];
		price1 = new double[b];
		date1 = new String[b];
		product11 = new int[b];
		product21 = new int[b];
		product31 = new int[b];
		product41 = new int[b];
		product51 = new int[b];
		
		while(input2.hasNext()){
			customerId1[c] = input2.next();
			
			firstName1[c] = input2.next();
			
			lastName1[c] = input2.next();
			
			price1[c] = input2.nextDouble();
			
			date1[c] = input2.next();
			product11[c] = input2.nextInt();
			product21[c] = input2.nextInt();
			product31[c] = input2.nextInt();
			product41[c] = input2.nextInt();
			product51[c] = input2.nextInt();
			
		}
		input2.close();
		//System.out.println(customerId1[0]);
		//System.out.println(b);
		input1.close();
		
		Assignment4 s = new Assignment4();
		s.setVisible(true);

	}
}
