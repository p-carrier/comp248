// -------------------------------------------------------
// Assignment 3
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

import java.util.Random;

/**
 *  Program that generate a password from three randomly selected word from a 3 dimensional array
 *  then print it along with the amount of password that were rejected per specific reason (wrong
 *  length, single letter word, multiple identical words, contains a newline character, all
 *  uppercase, all lowercase and has not exactly one special character). Then repeat it 10 000
 *  times or until a password was generated with all capital letters.
 *
 * @author Philippe Carrier
 * @since 11/04/2019
 */

public class Question1 {

    private final static String[][][] book = {
            {
                    {"ALICE was beginning to get very tired of sitting by her sister on the\n",
                            "bank, and of having nothing to do. Once or twice she had peeped into the\n",
                            "book her sister was reading, but it had no pictures or conversations in\n",
                            "it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
                            "conversations?\"\n"},
                    {"So she was considering in her OWN mind (as well as she could, for the\n",
                            "day made her feel very sleepy and stupid), whether the pleasure of\n",
                            "making a daisy-chain would be worth the trouble of getting up and\n",
                            "picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
                            "close by her.\n"},
                    {"There was nothing so very remarkable in that, nor did Alice think it so\n",
                            "very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
                            "dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
                            "out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
                            "started to her feet, for it flashed across her mind that she had never\n",
                            "before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
                            "out of it, and, burning with curiosity, she ran across the field after\n",
                            "it and was just in time to see it pop down a large rabbit-hole, under\n",
                            "the hedge. In another moment, down went Alice after it!"}
            },
            {
                    {"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
                            "telescope!\"\n"},
                    {"And so it was indeed! She was now only ten inches high, and her face\n",
                            "brightened up at the thought that she was now the right size for going\n",
                            "through the little door into that lovely garden.\n"},
                    {"After awhile, finding that nothing more happened, she decided on going\n",
                            "into the garden at once; but, alas for poor Alice! When she got to the\n",
                            "door, she found she had forgotten the little golden key, and when she\n",
                            "went back to the table for it, she found she could not possibly reach\n",
                            "it: she could see it quite plainly through the glass and she tried her\n",
                            "best to climb up one of the legs of the table, but it was too slippery,\n",
                            "and when she had tired herself out with trying, the poor little thing\n",
                            "sat down and cried.\n"},
                    {"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
                            "sharply. \"I advise you to leave off this minute!\" She generally gave\n",
                            "herself very good advice (though she very seldom followed it), and\n",
                            "sometimes she scolded herself so severely as to bring tears into her\n",
                            "eyes.\n"},
                    {"Soon her eye fell on a little glass box that was lying under the table:\n",
                            "she opened it and found in it a very small cake, on which the words \"EAT\n",
                            "ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
                            "Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
                            "makes me grow smaller, I can creep under the door: so either way I'll\n",
                            "get into the garden, and I don't care which happens!\"\n"},
                    {"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
                            "way?\" holding her hand on the top of her head to feel which way she was\n",
                            "growing; and she was quite surprised to find that she remained the same\n",
                            "size. So she set to work and very soon finished off the cake."}
            },
            {
                    {"The King and Queen of Hearts were seated on their throne when they\n",
                            "arrived, with a great crowd assembled about them--all sorts of little\n",
                            "birds and beasts, as well as the whole pack of cards: the Knave was\n",
                            "standing before them, in chains, with a soldier on each side to guard\n",
                            "him; and near the King was the White Rabbit, with a trumpet in one hand\n",
                            "and a scroll of parchment in the other. In the very middle of the court\n",
                            "was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
                            "trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},
                    {"The judge, by the way, was the King and he wore his crown over his great\n",
                            "wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
                            "(some were animals and some were birds) I suppose they are the jurors.\"\n"},
                    {"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
                    {"\"HERALD! read the accusation!\" said the King."}
            }
    };

    public static void main(String[] args) {

//        Random to get a random value
        Random random = new Random();
//        The amount of password that were refuse due to a new line
        int newLine = 0;
//        The amount of password that were refuse due to a word with a single character
        int single = 0;
//        The amount of password that were refuse due to two identical word chosen
        int equality = 0;
//        The amount of password that were refuse due to the length of the password being either
//        too short (< 8) of too long (>= 16)
        int len = 0;
//        The amount of password that were refuse due to a missing upper case letter
        int upper = 0;
//        The amount of password that were refuse due to a missing lower case letter
        int lower = 0;
//        The amount of password that were refuse due to a missing special character or too many
//        special character (>1)
        int special = 0;
//        The amount of successful password generated
        int count = 0;
//        Array containing the words that will form the password
        String[] passwordWords = new String[]{"", "", ""};

        System.out.println("Welcome to the password generator game!\n");

        while(count < 10_000) {

//            The amount of word in the password Words array
            int wordCount = 0;

//            loop that will find three random words for the password creation
            while (wordCount < 3) {
                boolean hasBreak = false;
//                The page where the word will be found
                int page = random.nextInt(book.length);
//                The paragraph where the word will be found
                int paragraph = random.nextInt(book[page].length);
//                The line where the word will be found
                int line = random.nextInt(book[page][paragraph].length);

//                All the words in the line
                String[] words = book[page][paragraph][line].split(" ");
//                The chosen random word
                String word = words[random.nextInt(words.length)];

//                Check for word smaller than 2 character to remove them from the list
                if (word.length() < 2) {
                    single++;
                    continue;
                }
//                Check for word containing new line to remove them from the list
                if (word.contains("\n")) {
                    newLine++;
                    continue;
                }

//                Check if word is already in the password Words array to limit the occurrence of a word to 1 time
                for (String passwordWord : passwordWords) {
                    if (word.equals(passwordWord)) {
                        equality++;
                        hasBreak = true;
                        break;
                    }
                }
                if (hasBreak) {
                    continue;
                }

//                add the word to the password Words array
                passwordWords[wordCount] = word;
                wordCount++;
            }

//            Concatenate the three chosen words into one password
            String password = "";
            for (String word : passwordWords) {
                password += word;
            }

//            Check the following condition to get a valid password
            if (password.length() < 8 || password.length() >= 16) {
                len++;
                continue;
            }

            if (password.toLowerCase().equals(password)) {
                upper++;
                continue;
            }

            if (password.toUpperCase().equals(password)) {
                lower++;
                continue;
            }

            int specialCount = 0;
            String lowerPassword = password.toLowerCase();
            for (int i = 0; i < lowerPassword.length(); i++) {
                char lowerLetter = lowerPassword.charAt(i);
                if (lowerLetter > 'z' || lowerLetter < 'a') {
                    specialCount++;
                }
            }

            if (specialCount != 1) {
                special++;
                continue;
            }


//            If the password doesn't fail the preceding condition, print out the password with
//            the amount of try.
            System.out.printf("Password = %-20s "
                  + "Newline = %-6s"
                  + "Single = %-6s"
                  + "Equal = %-6s"
                  + "Length = %-6s"
                  + "Upper = %-6s"
                  + "Lower = %-6s"
                  + "Special = %-6s%n",
                  password,
                  newLine,
                  single,
                  equality,
                  len,
                  upper,
                  lower,
                  special);

//            Add 1 valid password to the count
            count++;

//            Check if no attempt ended because the words didn't have any lowercase. End the while loop
//            if it was the case.
            if (lower != 0)
                break;

//            Reinitialize the errors count for the next password. No need to reinitialize the lower since it will
//            make the application exit if not equal to zero.
            newLine = 0;
            single = 0;
            equality = 0;
            len = 0;
            upper = 0;
            special = 0;
        }

        System.out.println();
        System.out.println("Total passwords generated: " + count);
        System.out.println();
        System.out.println("Thanks for using the password generator game. Good bye.");
    }

}
