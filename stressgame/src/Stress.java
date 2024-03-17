
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.Timer;

public class Stress implements KeyListener {

    Set<Integer> pressedKeys1 = new HashSet<>();
    Set<Integer> pressedKeys2 = new HashSet<>();

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W ||
                e.getKeyCode() == KeyEvent.VK_E ||
                e.getKeyCode() == KeyEvent.VK_A ||
                e.getKeyCode() == KeyEvent.VK_S ||
                e.getKeyCode() == KeyEvent.VK_D ||
                e.getKeyCode() == KeyEvent.VK_F) {

            pressedKeys1.add(e.getKeyCode());
        }

        if (e.getKeyCode() == KeyEvent.VK_U ||
                e.getKeyCode() == KeyEvent.VK_I ||
                e.getKeyCode() == KeyEvent.VK_O ||
                e.getKeyCode() == KeyEvent.VK_P ||
                e.getKeyCode() == KeyEvent.VK_K ||
                e.getKeyCode() == KeyEvent.VK_L) {

            pressedKeys2.add(e.getKeyCode());
        }

        if (pressedKeys1.size() == 2) {
            // Check for desired key combinations based on pressedKeys1
            System.out.println("THIS IS PRESSED KEYS STORED");
            System.out.println(pressedKeys1);

            if (pressedKeys1.contains(KeyEvent.VK_W) && pressedKeys1.contains(KeyEvent.VK_E)) {
                // Action for w + E combination
                System.out.println("W + E was detected by the listener");
                callStress(1);
                if (!isThereValidMove()) {
                    flipOnPiles();
                    System.out.println("FLIP ON PILES CALLED");
                }
                System.out.println(pileA);
            }

            // stackCard calls
            // playCard calls
            if (pressedKeys1.contains(KeyEvent.VK_A) && pressedKeys1.contains(KeyEvent.VK_W)) {
                // Action for A + W combination
                System.out.println("A + W was detected by the listener");
                // NEED TO INSERT VALID MOVE CHECKER
                // playCard from player row, Pos 0, Pile A
                playCard(playerRow, 0, pileA, playerDrawPile);
                System.out.println("NEW PILEA");
                System.out.println(pileA);
            }
            if (pressedKeys1.contains(KeyEvent.VK_A) && pressedKeys1.contains(KeyEvent.VK_E)) {
                // Action for A + E combination
                System.out.println("A + E was detected by the listener");
                playCard(playerRow, 0, pileB, playerDrawPile);
            }
            if (pressedKeys1.contains(KeyEvent.VK_S) && pressedKeys1.contains(KeyEvent.VK_W)) {
                // Action for S + W combination
                System.out.println("S + W was detected by the listener");
                playCard(playerRow, 1, pileA, playerDrawPile);
            }
            if (pressedKeys1.contains(KeyEvent.VK_S) && pressedKeys1.contains(KeyEvent.VK_E)) {
                // Action for S + E combination
                System.out.println("S + E was detected by the listener");
                playCard(playerRow, 1, pileB, playerDrawPile);
            }
            if (pressedKeys1.contains(KeyEvent.VK_D) && pressedKeys1.contains(KeyEvent.VK_W)) {
                // Action for D + W combination
                System.out.println("D + W was detected by the listener");
                playCard(playerRow, 2, pileA, playerDrawPile);
            }
            if (pressedKeys1.contains(KeyEvent.VK_D) && pressedKeys1.contains(KeyEvent.VK_E)) {
                // Action for D + E combination
                System.out.println("D + E was detected by the listener");
                playCard(playerRow, 2, pileB, playerDrawPile);
            }
            if (pressedKeys1.contains(KeyEvent.VK_F) && pressedKeys1.contains(KeyEvent.VK_W)) {
                // Action for F + W combination
                System.out.println("F + W was detected by the listener");
                playCard(playerRow, 3, pileA, playerDrawPile);
            }
            if (pressedKeys1.contains(KeyEvent.VK_F) && pressedKeys1.contains(KeyEvent.VK_E)) {
                // Action for F + E combination
                System.out.println("F + E was detected by the listener");
                playCard(playerRow, 3, pileB, playerDrawPile);
            }

            gamePanel.repaint();
        }

        // HASH SET 2
        if (pressedKeys2.size() == 2) {
            // Check for desired key combinations based on pressedKeys1
            System.out.println("THIS IS PRESSED KEYS STORED");
            System.out.println(pressedKeys2);

            if (pressedKeys2.contains(KeyEvent.VK_K) && pressedKeys2.contains(KeyEvent.VK_L)) {
                // Action for K + L combination
                System.out.println("K + L was detected by the listener");
                callStress(1);
                System.out.println(pileB);
            }

            // stackCard calls
            // playCard calls
            if (pressedKeys2.contains(KeyEvent.VK_U) && pressedKeys2.contains(KeyEvent.VK_K)) {
                // Action for U + K combination
                System.out.println("U + K was detected by the listener");
                // NEED TO INSERT VALID MOVE CHECKER
                // playCard from player row, Pos 0, Pile A
                playCard(aiRow, 0, pileA, aiDrawPile);
                System.out.println("NEW PILEA");
                System.out.println(pileA);
            }
            if (pressedKeys2.contains(KeyEvent.VK_U) && pressedKeys2.contains(KeyEvent.VK_L)) {
                // Action for A + E combination
                System.out.println("U + L was detected by the listener");
                playCard(aiRow, 0, pileB, aiDrawPile);
            }
            if (pressedKeys2.contains(KeyEvent.VK_I) && pressedKeys2.contains(KeyEvent.VK_K)) {
                // Action for S + W combination
                System.out.println("I + K was detected by the listener");
                playCard(aiRow, 1, pileA, aiDrawPile);
            }
            if (pressedKeys2.contains(KeyEvent.VK_I) && pressedKeys2.contains(KeyEvent.VK_L)) {
                // Action for S + E combination
                System.out.println("I + L was detected by the listener");
                playCard(aiRow, 1, pileB, aiDrawPile);
            }
            if (pressedKeys2.contains(KeyEvent.VK_O) && pressedKeys2.contains(KeyEvent.VK_K)) {
                // Action for D + W combination
                System.out.println("O + K was detected by the listener");
                playCard(aiRow, 2, pileA, aiDrawPile);
            }
            if (pressedKeys2.contains(KeyEvent.VK_O) && pressedKeys2.contains(KeyEvent.VK_L)) {
                // Action for D + E combination
                System.out.println("O + L was detected by the listener");
                playCard(aiRow, 2, pileB, aiDrawPile);
            }
            if (pressedKeys2.contains(KeyEvent.VK_P) && pressedKeys2.contains(KeyEvent.VK_K)) {
                // Action for F + W combination
                System.out.println("P + K was detected by the listener");
                playCard(aiRow, 3, pileA, aiDrawPile);
            }
            if (pressedKeys2.contains(KeyEvent.VK_P) && pressedKeys2.contains(KeyEvent.VK_L)) {
                // Action for F + E combination
                System.out.println("P + L was detected by the listener");
                playCard(aiRow, 3, pileB, aiDrawPile);
            }
            gamePanel.repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys1.remove(e.getKeyCode());
        pressedKeys2.remove(e.getKeyCode());
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
                    if (!(playerRow.get(i).isEmpty())) {
                        Card card = playerRow.get(i).get(0);
                        Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                        g.drawImage(cardImg, 75 + (cardWidth + 5) * i, 460, cardWidth, cardHeight, null);
                    }
                }
                // draw/paint aiRow
                for (int i = 0; i < aiRow.size(); i++) {
                    if (!(aiRow.get(i).isEmpty())) {
                        Card card = aiRow.get(i).get(0);
                        Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                        g.drawImage(cardImg, 75 + (cardWidth + 5) * i, 20, cardWidth, cardHeight, null);
                    }
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

        Stress stressObject = this;
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stressObject.aiPlayGameTurn(); // Option 1 (using object reference)
                gamePanel.repaint();
                System.out.println("AI Action Performed");
                // OR
                // Stress.aiPlayGameTurn(); // Option 2 (if static method)
            }
        });
        timer.start();

        // tutorial says to leave this here
        System.out.println("GAME PANEL WAS ADDED TO THE FRAME, repaint and paintcomponent");
    }

    public void startGame() {
        // create deck, shuffle it, give each player half the deck.
        // init and fill up the initial player row with 4 cards
        // initalise pile A and pile B from each of the player's draw pile's
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

        playCard(playerRow, 3, pileA, playerDrawPile);
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

    public int getValueOfLastCardInStack(ArrayList<ArrayList<Card>> playerRow, int rowPosition) {
        if (!playerRow.get(rowPosition).isEmpty()) {
            int stack_size = playerRow.get(rowPosition).size();
            int stack_value = playerRow.get(rowPosition).get(stack_size - 1).getValue();
            return stack_value;
        }
        return -1;
    }

    public boolean isThereValidMove() {
        // comparison between pile A and B and all visible cards
        boolean isThere = false;
        ArrayList<Integer> array = new ArrayList<Integer>();
        int pileA_value = pileA.get(pileA.size() - 1).getValue();
        int pileB_value = pileB.get(pileB.size() - 1).getValue();
        for (int i = 0; i < 4; i++) {
            array.add(getValueOfLastCardInStack(playerRow, i));
        }
        for (int i = 0; i < 4; i++) {
            array.add(getValueOfLastCardInStack(aiRow, i));
        }
        for (int card_value : array) {
            // check pile A
            if ((card_value == (pileA_value + 1) || card_value == (pileA_value - 1) ||
                    (card_value == 14 && pileA_value == 2) || (card_value == 2 && pileA_value == 14))) {
                isThere = true;
                return isThere;
            }

        }

        for (int card_value : array) {
            // check pile B
            if ((card_value == (pileB_value + 1) || card_value == (pileB_value - 1) ||
                    (card_value == 14 && pileB_value == 2) || (card_value == 2 && pileB_value == 14))) {
                isThere = true;
                return isThere;
            }
        }
        return isThere;
    }

    public void flipOnPiles() {
        // just add last of playerDraw pile to pileA, aiDrawPile to pileB
        // if player drawpile is empty, both come from aiDrawpile, vice versa

        if (playerDrawPile.isEmpty()) {
            pileA.add(aiDrawPile.remove(aiDrawPile.size() - 1));
            pileB.add(aiDrawPile.remove(aiDrawPile.size() - 1));

        } else if (aiDrawPile.isEmpty()) {
            pileA.add(playerDrawPile.remove(playerDrawPile.size() - 1));
            pileB.add(playerDrawPile.remove(playerDrawPile.size() - 1));
        } else {
            pileA.add(playerDrawPile.remove(playerDrawPile.size() - 1));
            pileB.add(aiDrawPile.remove(aiDrawPile.size() - 1));
        }
    }

    public boolean playCard(ArrayList<ArrayList<Card>> playerRow, int rowPosition, ArrayList<Card> pile,
            ArrayList<Card> drawpile) {
        // given a position, transfer the last card in the array to the back of the
        // specified pileA/B
        // if the value of the last card in inner array is one over or one below the
        // last card in pile, then execute
        // pile value

        boolean isExecuted = false;

        if (playerRow.get(rowPosition).isEmpty()) {
            return isExecuted;
        }

        int pile_value = pile.get(pile.size() - 1).getValue();
        int stack_size = playerRow.get(rowPosition).size();
        int stack_value = playerRow.get(rowPosition).get(stack_size - 1).getValue();

        if (stack_value == (pile_value + 1) || stack_value == (pile_value - 1) ||
                (stack_value == 14 && pile_value == 2) || (stack_value == 2 && pile_value == 14)) {

            pile.add(playerRow.get(rowPosition).remove(stack_size - 1));
            isExecuted = true;

            // if stack is empty, and if theres still cards in drawpile,
            // played card is replaced immediately from the BACK of the drawpile.
            if (playerRow.get(rowPosition).isEmpty()) {
                if (drawpile.size() != 0) {
                    playerRow.get(rowPosition).add(0, drawpile.remove(drawpile.size() - 1));
                }
            }
        }
        if (checkWin() == 1) {
            System.out.println("PLAYER 1 is the WINNERR");
        } else if (checkWin() == 2) {
            System.out.println("PLAYER 2 is the WINNERRR");
        } else {
            System.out.println("No one has won yet");
        }
        return isExecuted;
    }

    public void stackCards(ArrayList<Card> movingStack, ArrayList<Card> mainStack) { // lets not implement this
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

        // if the value of the last cards in pileA and pileB are equal, then stress can
        // be called
        // transfer pileA and pileB to the opponents drawpile

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

            flipOnPiles();
            System.out.println("STRESS CALLED");
            // after a stress call, the game should auto help to fill in any empty spaces in
            // the row
        }
    }

    public boolean canCallStress() {
        return pileA.size() > 0 && pileB.size() > 0
                && pileA.get(pileA.size() - 1).getValue() == pileB.get(pileB.size() - 1).getValue();
    }

    public void aiPlayGameTurn() {
        if (canCallStress()) {
            callStress(2);
        }

        boolean cardPlayed = false;
        if (!cardPlayed) {
            cardPlayed = playCard(aiRow, 0, pileA, aiDrawPile);
        }
        if (!cardPlayed) {
            cardPlayed = playCard(aiRow, 1, pileA, aiDrawPile);
            ;
        }
        if (!cardPlayed) {
            cardPlayed = playCard(aiRow, 2, pileA, aiDrawPile);
        }
        if (!cardPlayed) {
            cardPlayed = playCard(aiRow, 3, pileA, aiDrawPile);
        }
        if (!cardPlayed) {
            cardPlayed = playCard(aiRow, 0, pileB, aiDrawPile);
        }
        if (!cardPlayed) {
            cardPlayed = playCard(aiRow, 1, pileB, aiDrawPile);
        }
        if (!cardPlayed) {
            cardPlayed = playCard(aiRow, 2, pileB, aiDrawPile);
        }
        if (!cardPlayed) {
            cardPlayed = playCard(aiRow, 3, pileB, aiDrawPile);
        }
        // playCard(aiRow, 0, pileA, aiDrawPile);
        // playCard(aiRow, 1, pileA, aiDrawPile);
        // playCard(aiRow, 2, pileA, aiDrawPile);
        // playCard(aiRow, 3, pileA, aiDrawPile);
        // playCard(aiRow, 0, pileB, aiDrawPile);
        // playCard(aiRow, 1, pileB, aiDrawPile);
        // playCard(aiRow, 2, pileB, aiDrawPile);
        // playCard(aiRow, 3, pileB, aiDrawPile);
    }

    public int checkWin() {
        // if drawpile empty and all rows empty

        if (playerRow.get(0).isEmpty() &&
                playerRow.get(1).isEmpty() &&
                playerRow.get(2).isEmpty() &&
                playerRow.get(3).isEmpty()) {
            return 1;

        } else if (aiRow.get(0).isEmpty() &&
                aiRow.get(1).isEmpty() &&
                aiRow.get(2).isEmpty() &&
                aiRow.get(3).isEmpty()) {
            return 2;
        } else {
            return 3;
        }
    }
}
