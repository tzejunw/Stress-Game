
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
import javax.swing.*;

public class Stress implements KeyListener {

    Set<Integer> pressedKeys = new HashSet<>();
    // int[] pressedKeys = new int[2];
    // do i limit the size of the hash map?

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        if (pressedKeys.size() == 2) {
            // Check for desired key combinations based on pressedKeys
            System.out.println("THIS IS PRESSED KEYS STORED");
            System.out.println(pressedKeys);
            
            if (pressedKeys.contains(KeyEvent.VK_W) && pressedKeys.contains(KeyEvent.VK_E)) {
                // Action for w + E combination
                System.out.println("W + E was detected by the listener");
                callStress(1);
                System.out.println(pileA);
            }

            //stackCard calls
            
            // playCard calls
            if (pressedKeys.contains(KeyEvent.VK_A) && pressedKeys.contains(KeyEvent.VK_W)) {
                // Action for A + W combination
                System.out.println("A + W was detected by the listener");
                // NEED TO INSERT VALID MOVE CHECKER
                // playCard from player row, Pos 0, Pile A
                playCard(playerRow, 0, pileA);
                System.out.println("NEW PILEA");
                System.out.println(pileA);
            }
            if (pressedKeys.contains(KeyEvent.VK_A) && pressedKeys.contains(KeyEvent.VK_E)) {
                // Action for A + E combination
                System.out.println("A + E was detected by the listener");
                playCard(playerRow, 0, pileB);
            }
            if (pressedKeys.contains(KeyEvent.VK_S) && pressedKeys.contains(KeyEvent.VK_W)) {
                // Action for S + W combination
                System.out.println("S + W was detected by the listener");
                playCard(playerRow, 1, pileA);
            }
            if (pressedKeys.contains(KeyEvent.VK_S) && pressedKeys.contains(KeyEvent.VK_E)) {
                // Action for S + E combination
                System.out.println("S + E was detected by the listener");
                playCard(playerRow, 1, pileB);
            }
            if (pressedKeys.contains(KeyEvent.VK_D) && pressedKeys.contains(KeyEvent.VK_W)) {
                // Action for D + W combination
                System.out.println("D + W was detected by the listener");
                playCard(playerRow, 2, pileA);
            }
            if (pressedKeys.contains(KeyEvent.VK_D) && pressedKeys.contains(KeyEvent.VK_E)) {
                // Action for D + E combination
                System.out.println("D + E was detected by the listener");
                playCard(playerRow, 2, pileB);
            }
            if (pressedKeys.contains(KeyEvent.VK_F) && pressedKeys.contains(KeyEvent.VK_W)) {
                // Action for F + W combination
                System.out.println("F + W was detected by the listener");
                playCard(playerRow, 3, pileA);
            }
            if (pressedKeys.contains(KeyEvent.VK_F) && pressedKeys.contains(KeyEvent.VK_E)) {
                // Action for F + E combination
                System.out.println("F + E was detected by the listener");
                playCard(playerRow, 3, pileB);
            }

            gamePanel.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        // Remove the released key from the combination check
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this example
    }

    // game attributes of stress
    // deck and shuffling
    ArrayList<Card> deck;
    Random random = new Random();

    // player
    ArrayList<ArrayList<Card>> playerRow;
    ArrayList<Card> playerDrawPile;

    // AI
    ArrayList<ArrayList<Card>> aiRow;
    ArrayList<Card> aiDrawPile;

    // center piles
    ArrayList<Card> pileA;
    ArrayList<Card> pileB;

    // window
    int boardWidth = 600;
    int boardHeight = 700;

    int cardWidth = 110;
    int cardHeight = 154;

    int X_OFFSET = cardWidth / 2;
    int Y_OFFSET = cardHeight / 2;

    JFrame frame = new JFrame("Stress");
    JPanel gamePanel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            try {
                // Image hiddenCardImg = new
                // ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
                // g.drawImage(hiddenCardImg, 20, 20, cardWidth, cardHeight, null);

                // draw/paint playerRow
                for (int i = 0; i < playerRow.size(); i++) {
                    Card card = playerRow.get(i).get(0);
                    Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                    g.drawImage(cardImg, 75 + (cardWidth + 5) * i, 460, cardWidth, cardHeight, null);
                }

                // draw/paint aiRow
                for (int i = 0; i < aiRow.size(); i++) {
                    Card card = aiRow.get(i).get(0);
                    Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                    g.drawImage(cardImg, 75 + (cardWidth + 5) * i, 20, cardWidth, cardHeight, null);
                }

                // draw/paint piles. always print the last card in each pile
                Card pileACard = pileA.get(pileA.size() - 1);
                Image pileAImg = new ImageIcon(getClass().getResource(pileACard.getImagePath())).getImage();
                g.drawImage(pileAImg, 150, 250, cardWidth, cardHeight, null);

                Card pileBCard = pileB.get(pileB.size() - 1);
                Image pileBImg = new ImageIcon(getClass().getResource(pileBCard.getImagePath())).getImage();
                g.drawImage(pileBImg, 350, 250, cardWidth, cardHeight, null);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("FRAME REPAINTED FROM JPANEL FUNCTION");
            }

        }
    };

    Stress() {
        startGame();
        frame.addKeyListener(this);
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(53, 101, 77));
        frame.add(gamePanel);
        gamePanel.repaint();

        //tutorial says to leave this here
        System.out.println("GAME PANEL WAS ADDED TO THE FRAME, repaint and paintcomponent");
    }

    public void startGame() {
        // create deck, shuffle it, give the player half the deck.
        // init and fill up the initial player row with 4 cards
        // initalise A and B from each of the player's draw pile's
        buildDeck();
        // shuffleDeck();

        // player
        playerRow = new ArrayList<>();
        playerDrawPile = splitDeck1(deck);
        intialiseRow(playerRow, playerDrawPile);

        System.out.println("INITAL PLAYER DRAW PILE");
        System.out.println(playerDrawPile);

        // ai
        aiRow = new ArrayList<>();
        aiDrawPile = splitDeck2(deck);
        intialiseRow(aiRow, aiDrawPile);

        // piles

        pileA = new ArrayList<Card>();
        pileB = new ArrayList<Card>();
        flipOnPiles();

        System.out.println("PILES");
        System.out.println(pileA);
        System.out.println(pileB);

        System.out.println(" FIRST PLAYER ROW");
        System.out.println(playerRow);
        System.out.println();

        // essentially, there are 8 possible "playCard" moves and 12 stack commands. 1
        // stress call. 1 flip card.
        // they all have to start with a stack.
        // do i have enumerate all of them?
        // i need scanner to listen for 2 consec keystrokes and execute the unique
        // function

        System.out.println("PLAYER PLAYS A CARD TO PILE A");

        playCard(playerRow, 3, pileA);
        System.out.println("NEW PLAYER DRAW PILE");
        System.out.println(playerDrawPile);
        System.out.println("NEW PLAYER ROW");
        System.out.println(playerRow);
        System.out.println("NEW PILE A");
        System.out.println(pileA);

        frame.repaint();
    }

    public void buildDeck() {
        deck = new ArrayList<Card>();
        String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String[] types = { "C", "D", "H", "S" };

        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(values[j], types[i]);
                deck.add(card);
            }
        }
        System.out.println("BUILD DECK");
        System.out.println(deck);
        System.out.println();
    }

    public void shuffleDeck() {
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            Card currCard = deck.get(i);
            Card randomCard = deck.get(j);
            deck.set(i, randomCard);
            deck.set(j, currCard);
        }

        System.out.println("AFTER SHUFFLE");
        System.out.println(deck);
    }

    public ArrayList<Card> splitDeck1(ArrayList<Card> deck) {
        int halflength = deck.size() / 2;
        ArrayList<Card> returndeck = new ArrayList<Card>();
        for (int i = 0; i < halflength; i++) {
            // add card to new list
            returndeck.add(deck.get(i));
        }
        return returndeck;
    }

    public ArrayList<Card> splitDeck2(ArrayList<Card> deck) {
        int halflength = deck.size() / 2;
        ArrayList<Card> returndeck = new ArrayList<Card>();
        for (int i = halflength; i < halflength * 2; i++) {
            // add card to new list
            returndeck.add(deck.get(i));
        }
        return returndeck;
    }

    public void intialiseRow(ArrayList<ArrayList<Card>> row, ArrayList<Card> drawPile) {
        // Initialize the outer list with 4 empty inner lists
        // row = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            row.add(new ArrayList<Card>()); // Add an empty inner list for each iteration
        }

        // Add elements to each inner list
        for (int i = 0; i < 4; i++) {
            row.get(i).add(drawPile.remove(drawPile.size() - 1)); // Add to the each of the 4 inner list
        }
    }

    public void flipOnPiles() {
        // just add last of playerDraw pile to pileA, aiDrawPile to pileB
        // if there are no moves
        // get an int array of all the values in my row. 
        // loop to check if any possible move
        int[] intArray = new int[4];
        for (int i = 0 ; i < 4 ; i++) {

        }
        pileA.add(playerDrawPile.remove(playerDrawPile.size() - 1));
        pileB.add(aiDrawPile.remove(aiDrawPile.size() - 1));
    }

    public void playCard(ArrayList<ArrayList<Card>> playerRow, int rowPosition, ArrayList<Card> pile) {
        // given a position, clear the whole array stack and add each card to the back
        // oF the
        // specified pileA/B

        // if the value of the last card in inner array is one over or one below the last card in pile, then execute

        // pile value
        int pile_value = pile.get(pile.size() - 1).getValue();
        int stack_size = playerRow.get(rowPosition).size();
        int stack_value = playerRow.get(rowPosition).get(stack_size - 1).getValue();

        if (stack_value == (pile_value + 1) || stack_value == (pile_value - 1) || 
                (stack_value == 14 && pile_value == 2) || (stack_value == 2 && pile_value == 14)) {

            pile.addAll(playerRow.get(rowPosition));
            playerRow.get(rowPosition).clear();
    
            // played card is replaced immediately from the BACK of the drawpile. if, theres still cards to draw
            if (playerDrawPile.size() != 0) {
                playerRow.get(rowPosition).add(0, playerDrawPile.remove(playerDrawPile.size() - 1));
            } 
        }

    }

    public void stackCards(ArrayList<Card> movingStack, ArrayList<Card> mainStack) { //lets not implement this
        // transfer the ALL cards from moving stack to back of main stack
        // if the back of moving stack is same as back of main stack
        int movingStackSize = movingStack.size();
        int mainStackSize = mainStack.size();
        if (movingStack.get(movingStackSize - 1) == mainStack.get(mainStackSize - 1)) {
            mainStack.addAll(movingStack);
            movingStack.clear();
    
            // moved row is replaced immediately from the back of the drawpile
            movingStack.add(0, playerDrawPile.remove(playerDrawPile.size() - 1));
        }

    }

    public void callStress(int player) {
        // add and clear pileA and pileB to the opponents drawpile
        // if the value of the last cards in pileA and pileB are equal, then stress can
        // be called

        int last_index_A = pileA.size() - 1;
        int last_index_B = pileB.size() - 1;
        if (pileA.get(last_index_A).getValue() == pileB.get(last_index_B).getValue()) {
            if (player == 1) {
                aiDrawPile.addAll(pileA);
                aiDrawPile.addAll(pileB);
            } else {
                playerDrawPile.addAll(pileA);
                playerDrawPile.addAll(pileB);
            }
            pileA.clear();
            pileB.clear();
        }
        System.out.println("STRESS CALLED");
        // after stress is called, there is a need to replace the pile AB with cards from the drawpiles
        // what if the drawpile is empty? implement it
        pileA.add(playerDrawPile.remove(playerDrawPile.size() - 1));
        pileB.add(aiDrawPile.remove(aiDrawPile.size() - 1));
    }
}
