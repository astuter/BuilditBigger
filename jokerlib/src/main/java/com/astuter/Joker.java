package com.astuter;

import java.util.Random;

public class Joker {

    private Random random = new Random();

    public String getJoke() {
        String joke;
        switch (random.nextInt(10)) {
            case 0:
                joke = "To understand what recursion is, you must first understand recursion !!!";
                break;
            case 1:
                joke = "So this programmer goes out on a date with a hot chick!!";
                break;
            case 2:
                joke = "The fantastic element that explains the appeal of games to many developers is neither the fire-breathing monsters nor the milky-skinned, semi-clad sirens;" +
                        " it is the experience of carrying out a task from start to finish without any change in the user requirements.";
                break;
            case 3:
                joke = "Unix is user friendly. It's just very particular about who its friends are.";
                break;
            case 4:
                joke = "A programmer puts two glasses on his bedside table before going to sleep. A full one, in case he gets thirsty, and an empty one, in case he doesn't.";
                break;
            case 5:
                joke = "A foo walks into a bar, takes a look around and says \"Hello World!\" and meet up his friend Baz";
                break;
            case 6:
                joke = "Keyboard not found ... press F1 to continue";
                break;
            case 7:
                joke = "Don't anthropomorphize computers. They hate that!";
                break;
            case 8:
                joke = "\n" +
                        "\n" +
                        "Two bytes meet. The first byte asks, “Are you ill?”\n" +
                        "\n" +
                        "The second byte replies, “No, just feeling a bit off.”\n";
                break;
            case 9:
                joke = "Two threads walk into a bar. The barkeeper looks up and yells, \"hey, I want don't any conditions race like time last!\"";
                break;
            default:
                joke = "This is a super awesome funny joke!!!";
                break;
        }
        return joke;
    }
}
