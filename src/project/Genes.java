package project;

import java.util.ArrayList;
import java.util.Random;

public class Genes {
    private ArrayList<Integer> Choices;
    private ArrayList<boolean[]> poss;

    public Genes(){
        Random rnd = new Random();
        for (int i =0;i<700;i++){
            double randomDouble = Math.random();
            randomDouble = randomDouble * 30 + 1;
            int randomInt = (int) randomDouble;
            Choices.add(randomInt);
        }

        ArrayList<boolean[]> poss = new ArrayList<>();

        poss.add(new boolean[]{true,true,true,true,true});
        poss.add(new boolean[]{true,true,true,true,false});
        poss.add(new boolean[]{true,true,true,false,true});
        poss.add(new boolean[]{true,true,true,false,false});
        poss.add(new boolean[]{true,true,false,true,true});
        poss.add(new boolean[]{true,true,false,true,false});
        poss.add(new boolean[]{true,true,false,false,true});
        poss.add(new boolean[]{true,true,false,false,false});
        poss.add(new boolean[]{true,false,true,true,true});
        poss.add(new boolean[]{true,false,true,true,false});
        poss.add(new boolean[]{true,false,true,false,true});
        poss.add(new boolean[]{true,false,true,false,false});
        poss.add(new boolean[]{true,false,false,true,true});
        poss.add(new boolean[]{true,false,false,true,false});
        poss.add(new boolean[]{true,false,false,false,true});
        poss.add(new boolean[]{true,false,false,false,false});
        poss.add(new boolean[]{false,true,true,true,true});
        poss.add(new boolean[]{false,true,true,true,false});
        poss.add(new boolean[]{false,true,true,false,true});
        poss.add(new boolean[]{false,true,true,false,false});
        poss.add(new boolean[]{false,true,false,true,true});
        poss.add(new boolean[]{false,true,false,true,false});
        poss.add(new boolean[]{false,true,false,false,true});
        poss.add(new boolean[]{false,true,false,false,false});
        poss.add(new boolean[]{false,false,true,true,true});
        poss.add(new boolean[]{false,false,true,true,false});
        poss.add(new boolean[]{false,false,true,false,true});
        poss.add(new boolean[]{false,false,true,false,false});
        poss.add(new boolean[]{false,false,false,true,true});
        poss.add(new boolean[]{false,false,false,true,false});
        poss.add(new boolean[]{false,false,false,false,true});
        poss.add(new boolean[]{false,false,false,false,false});
    }
    public Genes(ArrayList<Integer> choices) {
        Choices = choices;
        ArrayList<boolean[]> poss = new ArrayList<>();

        poss.add(new boolean[]{true,true,true,true,true});
        poss.add(new boolean[]{true,true,true,true,false});
        poss.add(new boolean[]{true,true,true,false,true});
        poss.add(new boolean[]{true,true,true,false,false});
        poss.add(new boolean[]{true,true,false,true,true});
        poss.add(new boolean[]{true,true,false,true,false});
        poss.add(new boolean[]{true,true,false,false,true});
        poss.add(new boolean[]{true,true,false,false,false});
        poss.add(new boolean[]{true,false,true,true,true});
        poss.add(new boolean[]{true,false,true,true,false});
        poss.add(new boolean[]{true,false,true,false,true});
        poss.add(new boolean[]{true,false,true,false,false});
        poss.add(new boolean[]{true,false,false,true,true});
        poss.add(new boolean[]{true,false,false,true,false});
        poss.add(new boolean[]{true,false,false,false,true});
        poss.add(new boolean[]{true,false,false,false,false});
        poss.add(new boolean[]{false,true,true,true,true});
        poss.add(new boolean[]{false,true,true,true,false});
        poss.add(new boolean[]{false,true,true,false,true});
        poss.add(new boolean[]{false,true,true,false,false});
        poss.add(new boolean[]{false,true,false,true,true});
        poss.add(new boolean[]{false,true,false,true,false});
        poss.add(new boolean[]{false,true,false,false,true});
        poss.add(new boolean[]{false,true,false,false,false});
        poss.add(new boolean[]{false,false,true,true,true});
        poss.add(new boolean[]{false,false,true,true,false});
        poss.add(new boolean[]{false,false,true,false,true});
        poss.add(new boolean[]{false,false,true,false,false});
        poss.add(new boolean[]{false,false,false,true,true});
        poss.add(new boolean[]{false,false,false,true,false});
        poss.add(new boolean[]{false,false,false,false,true});
        poss.add(new boolean[]{false,false,false,false,false});
    }

    public boolean[] getMove(int i){
        return poss.get(Choices.get(i));
    }
}
