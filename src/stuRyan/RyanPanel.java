/*
  Trevor Ryan
  2/21/18
  CSC 220
  Project Explanation:
    In this project, I created a simple game of BlackJack. I used the cards class to 
  be able to print the cards out. I used 2 ArrayLists, one for player and one for
  dealer, along with another multicard ArrayList. I also created a sub class of cards
  named RyanCard. RyanCard is used to create the cards and make the ArrayLists. I 
  also created buttons for rules, to start a new game, for the player to hit, for the 
  player to stay and the dealer's automatic dealing starts, for the player to select 
  for the dealer to deal out a new hand to both the player and dealer. There is also a 
  mousePressed that was used in this programe to make it so when you press the left
  mouse button down on the last card dealt to the player, it runs the hitButton
  method giving another card to the player.

  Enhancements:
    -One enhancement that was used for this project was totaling the card value of the 
  cards in both the player and dealer hands. This allowed me to keep track of the 
  total card value of both hands and determine who the winner was.
  
    -Another enhancement that was used in my program was whenever the player got an ace
  as their first or second cards, the player had the option to choose whether the 
  value of the ace is 1 or 11. This was used by making the buttons invisible unless
  a card with an index of the aces was detected, then the buttons would become visible 
  and usable.

Project URL: https://drive.google.com/drive/folders/1iiLIuCfOQTNyZvxLSDEa0F-sjxPwsNvc
 */
 
package stuRyan;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import helperCards.Card;
import helperCards.MultiCard;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 * @author Trevor Ryan
 * @author klaydejr
 */
public class RyanPanel extends javax.swing.JPanel implements MouseListener, MouseMotionListener{
    
    private MultiCard multiCard;
    private ArrayList<RyanCard> player,dealer;
    private ArrayList<Card> cards;
    private Integer playerOver= 225;
    private Integer dealerOver = 55;
    private Integer playerDown = 75;
    private Integer dealerDown = 50;
    private int PlayerTotal = 0;
    private int DealerTotal = 0;
    private boolean PlayerBusted, DealerBusted;
    
    public RyanPanel() {
        initComponents();
        
//Instantiating ArrayList
        multiCard = new MultiCard();
        player  = new ArrayList<>();
        dealer = new ArrayList<>();
        cards = new ArrayList<>();
        
//Adding cards to multiCard
        for(Integer i = 0; i < 52; i++){
            cards.add(multiCard.getCardAtIndex(i));
        }
        
//Setting face cards to 10
        cards.get(10).setValue(10);
        cards.get(11).setValue(10);
        cards.get(12).setValue(10);
        
        cards.get(23).setValue(10);
        cards.get(24).setValue(10);
        cards.get(25).setValue(10);
        
        cards.get(36).setValue(10);
        cards.get(37).setValue(10);
        cards.get(38).setValue(10);
        
        cards.get(49).setValue(10);
        cards.get(50).setValue(10);
        cards.get(51).setValue(10);
        
//Adding mousListener and mouseMotionListener
        addMouseListener( this);
        addMouseMotionListener(this);
        
//Shuffling cards
        Collections.shuffle(cards);
       
//Setting button invisible
        CardOneAceIsOne.setVisible(false);
        CardOneAceIsEleven.setVisible(false);
        CardTwoAceIsOne.setVisible(false);
        CardTwoAceIsEleven.setVisible(false);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1000, 1000);
      
        for (int i=0; i<dealer.size(); i++){
            dealer.get(i).drawCard(g,this);
        }
        
        for(int i = 0; i < player.size(); i++){
            player.get(i).drawCard(g,this);
        }

//Totals player everytime repaint is called
        PlayerTotal=0;
        
        for (int i=0;i<player.size();i++){
            PlayerTotal += player.get(i).getValue();
        }
     
        DealerTotal=0;
        for (int i=0;i<dealer.size();i++){
            DealerTotal += dealer.get(i).getValue();
            System.out.println("Dealer index: "+i+" Value: "+dealer.get(i).getValue());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newDrawButton = new javax.swing.JButton();
        hitButton = new javax.swing.JButton();
        stayButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        rulesButton = new javax.swing.JButton();
        CardOneAceIsOne = new javax.swing.JButton();
        CardOneAceIsEleven = new javax.swing.JButton();
        CardTwoAceIsOne = new javax.swing.JButton();
        CardTwoAceIsEleven = new javax.swing.JButton();
        newGame = new javax.swing.JButton();

        newDrawButton.setText("New Hand");
        newDrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDrawButtonActionPerformed(evt);
            }
        });

        hitButton.setText("Hit");
        hitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitButtonActionPerformed(evt);
            }
        });

        stayButton.setText("Stay");
        stayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stayButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Dealer");

        jLabel2.setText("Player");

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        rulesButton.setText("Rules");
        rulesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesButtonActionPerformed(evt);
            }
        });

        CardOneAceIsOne.setText("Ace = 1");
        CardOneAceIsOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardOneAceIsOneActionPerformed(evt);
            }
        });

        CardOneAceIsEleven.setText("Ace = 11");
        CardOneAceIsEleven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardOneAceIsElevenActionPerformed(evt);
            }
        });

        CardTwoAceIsOne.setText("Ace = 1");
        CardTwoAceIsOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardTwoAceIsOneActionPerformed(evt);
            }
        });

        CardTwoAceIsEleven.setText("Ace = 11");
        CardTwoAceIsEleven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardTwoAceIsElevenActionPerformed(evt);
            }
        });

        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(newDrawButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rulesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newGame))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hitButton)
                        .addGap(10, 10, 10)
                        .addComponent(stayButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CardOneAceIsOne, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CardOneAceIsEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CardTwoAceIsEleven)
                            .addComponent(CardTwoAceIsOne))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CardOneAceIsOne)
                            .addComponent(CardTwoAceIsOne))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CardOneAceIsEleven)
                            .addComponent(CardTwoAceIsEleven))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hitButton)
                            .addComponent(stayButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newDrawButton)
                            .addComponent(rulesButton)
                            .addComponent(newGame))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newDrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDrawButtonActionPerformed
        
        TextArea.setText("Dealing out a new hand \n");
        player.clear();
        dealer.clear();
        playerOver=225;
        DealerTotal = 0;
        dealerOver = 55;
        PlayerTotal=0;
        dealerDown = 75;
        playerDown = 75;
        DealerBusted = false;
        PlayerBusted = false;
        
        for(Integer i =0; i<1; i++){ 
            
        //Adding first player card
            player.add(new RyanCard(cards.get(i).getSuit(),cards.get(i).getValue(),
                    cards.get(i).getOver(),cards.get(i).getDown(),cards.get(i).getImage()) );
            
        //Setting position of player card 1
            player.get(player.size()-1).setDown(50);
            player.get(player.size()-1).setOver(175);
            
        //Adding Second player card
            player.add(new RyanCard(cards.get(i+2).getSuit(),cards.get(i+2).getValue(),
                    cards.get(i+2).getOver(),cards.get(i+2).getDown(),cards.get(i+2).getImage()));
            
        //Setting position of player card 2
            player.get(player.size()-1).setDown(75);
            player.get(player.size()-1).setOver(200);
            
        //Adding first dealer card
            dealer.add(new RyanCard(cards.get(i+1).getSuit(),cards.get(i+1).getValue(),
                    cards.get(i+1).getOver(),cards.get(i+1).getDown(),cards.get(i+1).getImage()));
            dealer.get(dealer.size()-1).setDown(50);
            dealer.get(dealer.size()-1).setOver(30);
            
        //Adding second dealer card
            dealer.add(new RyanCard(cards.get(i+3).getSuit(),cards.get(i+3).getValue(),
                    cards.get(i+3).getOver(),cards.get(i+3).getDown(),cards.get(i+3).getImage()));
            //setting position of dealer card 2
            dealer.get(dealer.size()-1).setDown(75);
            dealer.get(dealer.size()-1).setOver(55);
            dealerOver += 25;
            dealerDown += 25;
            
        //Setting one of dealers cards to be face down
            dealer.get(dealer.size()-1).setFaceDown();
        }
        //Removing dealer cards 1 and 2 and players cards 1 and 2
            cards.remove(0);
            cards.remove(1);
            cards.remove(2);
            cards.remove(3);
        
        if (player.get(0).getValue()==1){
            CardOneAceIsOne.setVisible(true);
            CardOneAceIsEleven.setVisible(true);
        }
        if (player.get(player.size()-1).getValue()==1){
            CardTwoAceIsOne.setVisible(true);
            CardTwoAceIsEleven.setVisible(true);
        }
        //
        //
        //
        processCards();
        
        repaint();
    }//GEN-LAST:event_newDrawButtonActionPerformed

    private void stayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stayButtonActionPerformed
        dealer.get(1).setImage();
        repaint();
        if(!PlayerBusted){
            if (DealerTotal<17){
                Dealercard();
            }
            repaint();
            processCards();
            DecideVictor();
        }
        repaint();
    }//GEN-LAST:event_stayButtonActionPerformed

    private void Dealercard() {
        if (DealerTotal<17){
            dealer.add(new RyanCard(cards.get(cards.size()-1).getSuit(),cards.get(cards.size()-1).getValue(),
                            cards.get(cards.size()-1).getOver(),cards.get(cards.size()-1).getDown(),cards.get(cards.size()-1).getImage()));
        dealer.get(dealer.size()-1).setOver(dealerOver);
        dealer.get(dealer.size()-1).setDown(dealerDown);
        dealerOver += 25;
        dealerDown += 25;
        cards.remove(cards.size()-1);
        }
        processCards();
        repaint();
        if(DealerTotal<17){
            Dealercard();
        }
        else {
            repaint();
            processCards();
            DecideVictor();
        }
        
    }
    
    private void hitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitButtonActionPerformed
        if(!PlayerBusted){
            player.add(new RyanCard(cards.get(0).getSuit(),cards.get(0).getValue(),
                        cards.get(0).getOver(),cards.get(0).getDown(),cards.get(0).getImage()));
            player.get(player.size()-1).setOver(playerOver);
            player.get(player.size()-1).setDown(playerDown);
            playerOver += 25;
            playerDown+= 25;
            cards.remove(0);
            repaint();
            processCards();
            repaint();
        }
    }//GEN-LAST:event_hitButtonActionPerformed

    private void rulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesButtonActionPerformed
        JOptionPane.showMessageDialog(null, 
                "BlackJack Rules"
                + "\n The Main goal of BlackJack as the player is"
                + "\n to get as close to 21 without going over but also"
                + "\n getting a higher card value than the dealer."
                + "\n Player Goals:"
                + "\n\t\t\t\t-Get as close to 21 withought going over"   
                + "\n\t\t\t\t-Get a higher card value than the dealer"        
                + "\n Player Rules:"
                + "\n\t\t\t\t -To get another card, click the 'hit' button"
                + "\n\t\t\t\t -To 'stay', and move the play to the dealer, hit the 'stay' button"
                + "\n\t\t\t\t -If you go over 21, you bust and the dealer wins"
                + "\n Dealer Rules:"
                + "\n\t\t\t\t -Starts with one card face up and one face down"
                + "\n\t\t\t\t -Doesn't go until Player's turn is up"
                + "\n\t\t\t\t -When turn starts, flip face down card up"
                + "\n\t\t\t\t - Keep giving cards until card value is 17 or greater"
                + "\n\t\t\t\t - If the dealer goes over 21, the dealer busts and the player wins"
                + "\n Other Rules and Info:"
                + "\n\t\t\t\t -Hit new hand button to deal out a new hand"
                + "\n\t\t\t\t -If an ace comes up, you can use it as either a one or eleven"
                        
                       
                );
        
    }//GEN-LAST:event_rulesButtonActionPerformed

    private void CardOneAceIsOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardOneAceIsOneActionPerformed
        player.get(0).setValue(1);
        CardOneAceIsOne.setVisible(false);
        CardOneAceIsEleven.setVisible(false);
        CardTwoAceIsOne.setVisible(false);
        CardTwoAceIsEleven.setVisible(false);
        repaint();
        
    }//GEN-LAST:event_CardOneAceIsOneActionPerformed

    private void CardOneAceIsElevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardOneAceIsElevenActionPerformed
        player.get(0).setValue(11);
        CardOneAceIsOne.setVisible(false);
        CardOneAceIsEleven.setVisible(false);
        CardTwoAceIsOne.setVisible(false);
        CardTwoAceIsEleven.setVisible(false);
        repaint();
    }//GEN-LAST:event_CardOneAceIsElevenActionPerformed

    private void CardTwoAceIsOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardTwoAceIsOneActionPerformed
       player.get(player.size()-1).setValue(1);
       CardOneAceIsOne.setVisible(false);
       CardOneAceIsEleven.setVisible(false);
       CardTwoAceIsOne.setVisible(false);
       CardTwoAceIsEleven.setVisible(false);
       repaint();
    }//GEN-LAST:event_CardTwoAceIsOneActionPerformed

    private void CardTwoAceIsElevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardTwoAceIsElevenActionPerformed
       player.get(player.size()-1).setValue(11);
       CardOneAceIsOne.setVisible(false);
       CardOneAceIsEleven.setVisible(false);
       CardTwoAceIsOne.setVisible(false);
       CardTwoAceIsEleven.setVisible(false);
       repaint();
    }//GEN-LAST:event_CardTwoAceIsElevenActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        player.clear();
        dealer.clear();
        cards.clear();
        for(Integer i = 0; i < 52; i++){
            cards.add(multiCard.getCardAtIndex(i));
        }
        
        //setting face cards to 10
        cards.get(10).setValue(10);
        cards.get(11).setValue(10);
        cards.get(12).setValue(10);
        
        cards.get(23).setValue(10);
        cards.get(24).setValue(10);
        cards.get(25).setValue(10);
        
        cards.get(36).setValue(10);
        cards.get(37).setValue(10);
        cards.get(38).setValue(10);
        
        cards.get(49).setValue(10);
        cards.get(50).setValue(10);
        cards.get(51).setValue(10);
        //shuffling cards
        Collections.shuffle(cards);
       
        //setting button invisible
        CardOneAceIsOne.setVisible(false);
        CardOneAceIsEleven.setVisible(false);
        CardTwoAceIsOne.setVisible(false);
        CardTwoAceIsEleven.setVisible(false);
        repaint();
    }//GEN-LAST:event_newGameActionPerformed

    public void processCards(){
        //set txt to show value
        PlayerTotal=0;
        for (int i=0;i<player.size();i++){
            PlayerTotal += player.get(i).getValue();
        }
        
        if(PlayerTotal>21){
            PlayerBusted=true;
            DecideVictor();
        }
        DealerTotal=0;
        for (int i=0;i<dealer.size();i++){
            DealerTotal += dealer.get(i).getValue();
            System.out.println("Dealer index: "+i+" Value: "+dealer.get(i).getValue());
        }
        
        if(DealerTotal>21){
            DealerBusted = true;
            DecideVictor();
        }
        if(!PlayerBusted){
        TextArea.append("Player Card Total ="+PlayerTotal+". You can either select "
                + "to stay or to hit\n");
        }
        
    }
    
    public void DecideVictor(){
      if(PlayerBusted ){
          TextArea.setText(" The Player Busted, The Dealer Wins.\n");
          System.out.println("The Player Busted, The Dealer Wins.");
        }
        if(DealerBusted){
          TextArea.setText("Dealer Busted, Player Wins... Congrats!\n");
          System.out.println("Dealer Busted, Player Wins... Congrats!");
        }
        if (!PlayerBusted&&!DealerBusted){
            if (PlayerTotal>DealerTotal){
                TextArea.setText("Player Total is more than Dealer Total... Player wins!\n");
                System.out.println("Player Total is more than Dealer Total... Player wins!");
            } 
            else if (PlayerTotal<DealerTotal){
                TextArea.setText("Player Total is less than Dealer Total... Dealer wins\n");
                System.out.println("Player Total is less than Dealer Total... Dealer wins");
            } 
            else if (PlayerTotal==DealerTotal){
                TextArea.setText("Player Total is equal to Dealer Total... Dealer wins\n");
                System.out.println("Player Total is equal to Dealer Total... Dealer wins");
            }
        } 
    }
    
    public void mouseClicked(MouseEvent e) {
//        System.out.println("mouseClicked at "+e.getX()+", "+e.getY());
        
    }

    public void mousePressed(MouseEvent e) {
        if(!PlayerBusted){
            System.out.println("mouse pressed");
        
        if (!player.isEmpty()){
            System.out.println("first if test i hate my life");
        if(player.get(player.size()-1).containsPoint(e.getX(),e.getY())){
            player.add(new RyanCard(cards.get(0).getSuit(),cards.get(0).getValue(),
                    cards.get(0).getOver(),cards.get(0).getDown(),cards.get(0).getImage()));
            System.out.println("second if test i");
        player.get(player.size()-1).setOver(playerOver);
        player.get(player.size()-1).setDown(playerDown);
        playerOver += 25;
        playerDown+= 25;
        cards.remove(0);
        repaint();
        processCards();
        repaint();
        }}
        }
    }

    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouseReleased at "+e.getX()+", "+e.getY());
    }

    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouseEntered at "+e.getX()+", "+e.getY());
    }

    
    public void mouseExited(MouseEvent e) {
//        System.out.println("mouseExited at "+e.getX()+", "+e.getY());
    }

    
    public void mouseDragged(MouseEvent e) {
//        System.out.println("mouseDragged at "+e.getX()+", "+e.getY());
    }

    
    public void mouseMoved(MouseEvent e) {
//        System.out.println("mouseMoved at "+e.getX()+", "+e.getY());
    }
    
 
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CardOneAceIsEleven;
    private javax.swing.JButton CardOneAceIsOne;
    private javax.swing.JButton CardTwoAceIsEleven;
    private javax.swing.JButton CardTwoAceIsOne;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JButton hitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newDrawButton;
    private javax.swing.JButton newGame;
    private javax.swing.JButton rulesButton;
    private javax.swing.JButton stayButton;
    // End of variables declaration//GEN-END:variables

    
}