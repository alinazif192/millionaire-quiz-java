/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

/**
 *
 * @author joel
 */

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class Game 
{
    private Player player;
    private List<Question> questions;
    private int currentQuestionNum;
    private Scanner scanner;
    private boolean[] hiddenOptions;
    private static final String SCORES_FILE = "scores.txt";
    private Map<Integer, Lifeline> lifelineMap;
    
    
    // starts the game with player and the loaded questions from question.txt
    public Game(Player player) 
    {
        this.player = player;
        this.questions = QuestionStorage.loadquestions("questions.txt");
        Collections.shuffle(this.questions);
        if (this.questions.size() > 15) 
        {
            this.questions = this.questions.subList(0, 15);
        }

        this.currentQuestionNum = 0;
        this.scanner = new Scanner(System.in);
        this.hiddenOptions = new boolean[4];

        this.lifelineMap = new HashMap<>();
        lifelineMap.put(5, new FiftyFifty());
        lifelineMap.put(6, new Asktheaudiencelifeline());
        lifelineMap.put(7, new PhoneAFriend());
    }

    // this checks if the answer that the player inputted is correect and then therefore handles where we go from there
    private boolean processAnswer(Question currentQuestion, int choice) 
    {
        if (hiddenOptions[choice - 1]) 
        {
            System.out.println("That option is no longer available!");
            return true;
        }

        if (choice == currentQuestion.getCorrectAnswer()) 
        {
            player.setCurrentPrize(MoneyLevels.getPrize(currentQuestionNum + 1));
            System.out.println("\nCorrect! You've won $" + MoneyLevels.getPrize(currentQuestionNum + 1));

            if (currentQuestionNum == questions.size() - 1) 
            {
                endGame(true);
                return false;
            }

            currentQuestionNum++;

            if (MoneyLevels.isSafetyNet(currentQuestionNum)) 
            {
                System.out.println("\nCongratulations! You've reached a safety net at $" +
                        MoneyLevels.getPrize(currentQuestionNum) +
                        "\nYou can't leave with less than this amount now.");
            }

            return true;
        } 
        else 
        {
            System.out.println("\nIncorrect! The correct answer was " +
                    currentQuestion.getCorrectAnswer() + ". " +
                    currentQuestion.getOptions()[currentQuestion.getCorrectAnswer() - 1]);
            endGame(false);
            return false;
        }
    }
    
    
    // this is the main game loop that runs the most of it
    public void startGame() 
    {
        while (currentQuestionNum < questions.size()) 
        {
            Question currentQuestion = questions.get(currentQuestionNum);
            resetOptions();
            boolean questionShown = false;

            while (true) 
            {
                if (!questionShown) 
                {
                    displayquestions(currentQuestion);
                    questionShown = true;
                }

                int choice = showOptions();

                if (choice == -2) 
                {
                    handleQuit();
                    return;
                }

                if (choice == -1) continue;

                if (choice >= 5 && choice <= 7) 
                {
                    useLifeline(choice, currentQuestion);
                    continue;
                }

                if (!processAnswer(currentQuestion, choice)) 
                {
                    return;
                }
                break;
            }
        }
    }

    // This displays the avalible options for lifelines and and has the x to quit feature
    private int showOptions() 
    {
        System.out.println("\nChoose an option (5, 6, 7) or press 'x' to quit:");
        if (!player.hasUsed5050()) System.out.println("5. 50/50");
        if (!player.hasUsedAskAudience()) System.out.println("6. Ask The Audience");
        if (!player.hasUsedPhoneAFriend()) System.out.println("7. Phone A Friend");

        try {
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("x")) 
            {
                return -2;
            }

            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 7) 
                {
                    System.out.println("Invalid choice. Please enter 1-7 or 'x' to quit.");
                    return -1;
                }
                return choice;
            } catch (NumberFormatException e) 
            {
                System.out.println("Please enter a number (1-7) or 'x' to quit.");
                return -1;
            }
        } catch (NoSuchElementException e) 
        {
            System.out.println("Input error. Please try again.");
            return -1;
        }
    }
    
    
    // this handles the if you press x to quit and it calculates the safety net prize
    private void handleQuit() 
    {
        int prize = calculateSafetyNet();
        System.out.println("\nYou've chosen to quit the game.");
        System.out.println("You walk away with $" + prize);
        saveFinalResult(prize);
        resetGame();
    }

    // this checks if the lifeline has already been used and it displays a message saying that lifeline has been used.
    private boolean useLifeline(int choice, Question question) 
    {
        Lifeline lifeline = lifelineMap.get(choice);
        if (lifeline == null) return true;


        switch (choice) 
        {
            case 5:
                if (player.hasUsed5050()) 
                {
                    System.out.println("You already used 50/50!");
                    return true;
                }
                break;
            case 6:
                if (player.hasUsedAskAudience())
                {
                    System.out.println("You already used Ask The Audience!");
                    return true;
                }
                break;
            case 7:
                if (player.hasUsedPhoneAFriend()) 
                {
                    System.out.println("You already used Phone A Friend!");
                    return true;
                }
                break;
        }

        lifeline.use(player, question, hiddenOptions);
        return true;
    }

    // this displays the current question and the prize money you recieve for it.
    private void displayquestions(Question question) 
    {
        System.out.println("\nQuestion for $" + MoneyLevels.getPrize(currentQuestionNum + 1) + ": (1, 2, 3, 4)");
        System.out.println(question.getQuestionText());
        for (int i = 0; i < question.getOptions().length; i++) 
        {
            if (!hiddenOptions[i]) 
            {
                System.out.println((i + 1) + ". " + question.getOptions()[i]);
            }
        }
    }

    
    // this calculates which safety net they are at either 1000, 32000 or 0.
    private int calculateSafetyNet() 
    {
        for (int i = MoneyLevels.safety_money.length - 1; i >= 0; i--) 
        {
            if (player.getCurrentPrize() >= MoneyLevels.safety_money[i]) 
            {
                return MoneyLevels.safety_money[i];
            }
        }
        return 0;
    }

    // this saves the results of the entered user into the scores.txt file in the format shown below 
    private void saveFinalResult(int prize) 
    {
        Path scoresPath = Paths.get(SCORES_FILE);

        try {
            String lifelines = getUsedLifelines();
            String record = String.format("%s | %s | Prize: $%,d | Lifelines: %s%n",
                    player.getName(),
                    LocalDate.now(),
                    prize,
                    lifelines.isEmpty() ? "None" : lifelines);

            Files.write(scoresPath, record.getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) 
        {
            System.out.println("Error saving final results: " + e.getMessage());
        }
    }

    private String getUsedLifelines() 
    {
        List<String> used = new ArrayList<>();
        if (player.hasUsed5050()) used.add("50/50");
        if (player.hasUsedAskAudience()) used.add("Ask The Audience");
        if (player.hasUsedPhoneAFriend()) used.add("Phone A Friend");
        return String.join(", ", used);
    }

    // This resets everything to start a new game ensuring lifelines are back, new set of questions.
    public void resetGame() 
    {
        currentQuestionNum = 0;
        resetOptions();
        player.reset();
    }

    
    // Shows all options again
    private void resetOptions() 
    {
        Arrays.fill(hiddenOptions, false);
    }

    
    //This handles the game ending conclusion, which is if you answer all the questions correectly you win the million.
    private void endGame(boolean won) 
    {
        int prize = won ? 1000000 : calculateSafetyNet();
        String result = won ? "WON $1,000,000" :
                (prize > 0 ? "SAFETY NET $" + prize : "LOST ($0)");

        System.out.println("\nGame over! You " + result);
        saveFinalResult(prize);
        resetGame();
    }
}
