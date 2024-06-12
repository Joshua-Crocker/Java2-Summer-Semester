package Java_Assignments.Java_Assignment3.Question1;

import java.util.Random;

public class RandomSentenceGenerator {

    private static String generateSentence(String[] articles, String[] nouns, String[] verbs, String[] prepositions) {
        Random random = new Random();
        String article1 = articles[random.nextInt(articles.length)];
        String noun1 = nouns[random.nextInt(nouns.length)];
        String verb = verbs[random.nextInt(verbs.length)];
        String preposition = prepositions[random.nextInt(prepositions.length)];
        String article2 = articles[random.nextInt(articles.length)];
        String noun2 = nouns[random.nextInt(nouns.length)];

        String sentence = article1 + " " + noun1 + " " + verb + " " + preposition + " " + article2 + " " + noun2;

        sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1) + ".";

        return sentence;
    }

    public static void main(String[] args) {
        String[] articles = {"the", "a", "one", "some", "any"};
        String[] nouns = {"boy", "girl", "dog", "town", "car"};
        String[] verbs = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] prepositions = {"to", "from", "over", "under", "on"};

        for (int i = 0; i < 20; i++) {
            String sentence = generateSentence(articles, nouns, verbs, prepositions);
            System.out.println(sentence);
        }
    }
}
