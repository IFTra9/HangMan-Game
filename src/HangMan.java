
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * @auther:ifat traubas
 * id : 301378790
 * 2019b
 * HANGMAN__________JOptionPane.showMessageDialog(null,"Hangman instructions :\n"
                          		+"Rules:\r\n" + 
                          		"Discover hidden words.\r\n" + 
                          		"You have 6 attempts.\r\n" + 
                          		"Each time you click on a letter:\r\n" + 
                          		"1. If the letter appears in the word,\r\n"
                          		+ " all the occurrences "
                          		+ "of the letter"
                          		+ " will appear on the screen.\r\n" + 
                          		"2. If the letter does "
                          		+ "not appear \r\nin the word,"
                          		+ " we will add another body part to the "
                          		+ "Hangman.\r\n" + 
                          		"The game ends when there's a full-screen "
                          		+ "\r\npainting of a man on the screen, and the"
                          		+ " hidden word will be reviled.\r\n");
 * 
 */
/**
* This class builds Hangman drawing, buttons,labels, panels,frames and the game whole in general.
* @param num1 The first number
* @param corectletters=0;
	@param mistakes -  user didnt revile any letters
	@param final int MAXmistakes=6;
		@param man;
		@param RandomWord,VisibleWord;
		@param keys,Start; start game using botton
		@param StartButton;
		@param Visible,triesLeft - visible word for user to see, 
		@param triesleft is keep trying to  
		@param pman;
        @param me;
* @param num2 The second number
* @return What we get from those two numbers
*/
public class HangMan extends JFrame implements ActionListener {
	int corectletters=0;
	int mistakes=0;
	final int MAXmistakes=6;
	HangmanWords man;
	String RandomWord,VisibleWord;
	JPanel keys,Start;
	JButton StartButton;
	JLabel Visible,triesLeft;
	DrawHangMan pman;
	JButton[] buttons;
    int i=0;

   public HangMan(){
	    initGame();
   }
 /**
  * clear game from screen 
  */
   public void DeleteGame()
   {

	   this.remove(keys);
	   this.remove(Visible);
       this.remove(pman);
       this.remove(triesLeft);
       this.remove(Start);
       
   }
   
   /**
    * initGame - 1.initialized random word from a txt file
    *            2.puts labels- when 
    */
   
   public void initGame( ) {
	   
		corectletters=0; //
		mistakes=0;  //user mistake input
		man=new HangmanWords(); 
		RandomWord=man.CatchWordFromFile("");// random word from animals.txt
		VisibleWord=man.UserVisibleWord(RandomWord); //Hidden word that will appear on user screen 
		keys=new JPanel();
		Start=new JPanel();	    
		Visible=new JLabel(ChangeVisible(VisibleWord),SwingConstants.CENTER);
		triesLeft = new JLabel("  Tries left: 6    ",SwingConstants.CENTER);

		buttons = new JButton[27];
		String  b[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","START"};
		keys.setLayout(new GridLayout(4,4,5,5));
		for(i = 0; i < buttons.length-1; i++) {
			buttons[i] = new JButton(b[i]);
			buttons[i].setSize(5,5);
			buttons[i].setBackground(Color.DARK_GRAY);
	        buttons[i].setForeground(Color.white);
	        buttons[i].setActionCommand(b[i]);
	        buttons[i].addActionListener(this); 
	        keys.add(buttons[i]);
	   }
	       /* create start/restart button */
	       StartButton = new JButton("START");
	       StartButton.setBackground(Color.blue);
	       StartButton.setForeground(Color.white);
	       StartButton.setFont(new Font("Ariel",Font.BOLD,25));
	      // StartButton.setPreferredSize(new Dimension(140,40));
	       
	       StartButton.addActionListener(this);
	       Start.add(StartButton);
	       
	       /* set displayed word and "tries left" lable */
	       Visible.setFont(new Font("Ariel",Font.BOLD,60));
	       triesLeft.setFont(new Font("Ariel",Font.BOLD,25));
	       
	       /* set hang man paint size */
	       pman = new DrawHangMan();
	       pman.setPreferredSize(new Dimension(150,330));   
	       add(Start,BorderLayout.NORTH);
	       add(pman,BorderLayout.LINE_START);
	       add(Visible,BorderLayout.CENTER);
	       add(triesLeft,BorderLayout.LINE_END);
	       /* set keyboard size */
	       keys.setPreferredSize(new Dimension(600,180));
	       add(keys,BorderLayout.SOUTH);
	       setSize(800,400);
	       this.pack();
	       this.setLocationRelativeTo(null);
	       setVisible(true);
   }
   /** This function "ChangeVisible" - adding spaces as '_'
   * @param ButtonPressed translate button to letter
   * @param s letter that was chosen
   * @return a letter
   */
   public char LetterInput(String ButtonPressed) {
	   char s;
	   s=ButtonPressed.charAt(0);
	   return s;
   }
   
   public void actionPerformed(ActionEvent e)  { 	
    	
	   JButton b=(JButton)e.getSource();
	   String choice = e.getActionCommand();
	   if (choice.equals("START") == true) { 	   //if user pressed START button.
		   
		   DeleteGame();
		   initGame();
		   
	   } else {
		  
		   char chr = LetterInput(choice);   	  //else if user pressed Keyboard buttons and guessed a letter
		   chr=(char) (chr+32);
           b.setVisible(false);
           playgame(chr);
	  
	   }     
   }  
       /** This function playgame - compare a letter with the word
        * if appears in word, display screen.
* @param boolean Ifexist   if clicked letter exist on word
*/
   	private void playgame(char letter) {   
   		
		   int Ifexist=0;
		   for (int i=0;i<RandomWord.length();i++) {     	   //check if the letter is in the word
			   if(RandomWord.charAt(i)==letter) {
				   VisibleWord=VisibleWord.substring(0,i) + letter + VisibleWord.substring(i+1);
		       Ifexist=1;    									//mark guess is correct, 
			       corectletters++; 							//update correct letter amount 
			   }
		   }
	
			   if (Ifexist == 1)  {     		  				//if player guessed a letter from word
				   Visible.setText(ChangeVisible(VisibleWord));
				  
			  } else {         									//if user input was wrong!
				   mistakes++;
			       pman.guesses=mistakes;
			       pman.repaint();
			       triesLeft.setText("  Tries left: " + (6 - mistakes)+"    ");
	
			       if (mistakes==MAXmistakes) {		 		    // if user reached max mistake count
					   JOptionPane.showMessageDialog(null,"END GAME - YOU LOST\n"
					   		+ "You can always try again using the START button  "); 
					   DeleteGame();
					   initGame();
	    		      
				       }   
			   }   //if user found all the correct answer.
			   if (corectletters == RandomWord.length()) {
				   JOptionPane.showMessageDialog(null,"you win"	+ "\nThe word is: "+RandomWord);
			       DeleteGame();
			       initGame();
			   }
	         }
	   
   /**      
* This function "ChangeVisible" - adding spaces as '_'
* @param String word is the word that we want to hide from user.
* @param int i,j counters - add spaces between letters.
* @return a String word adding spaces for '_'
*/
        
       public String ChangeVisible(String word) {
       int i=0,j=0;
       String str="";
       while(i<word.length()){
       str=str.substring(0,j) + " " + word.substring(i);
       i++;
       j+=2;
      	}
      	 return str; 
       }
 }
