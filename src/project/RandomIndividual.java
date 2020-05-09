package project;

import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioTimer;

import java.util.ArrayList;
import java.util.Random;


//Creates a Random Individual with a random length set of random actions

public class RandomIndividual implements MarioAgent {
    private int turn;
    private Random rnd;
    private ArrayList<Integer> choices;
    private float fitness;

    @Override
    public void initialize(MarioForwardModel model, MarioTimer timer) {
        turn =-1;
        rnd = new Random();
        choices = new ArrayList<>();

        final ArrayList<boolean[]> poss = new ArrayList<>();

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

    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
        turn += 1;
//        boolean[] action = /*poss.get*/choices.get(rnd.nextInt(choices.size()));
//        choices.add(action);
        return new boolean[]{true, true, true, true};//action;
    }

    @Override
    public String getAgentName() {
        return "RandomIndividual";
    }


//    public static void main(String[] args) {
//
//        ArrayList<boolean[]> choices = new ArrayList<>();
//        final int n = 5;
//        boolean[] form = new boolean[]{false,false,false,false,false};
//        for (int i = 0; i < Math.pow(2, n); i++) {
//            String bin = Integer.toBinaryString(i);
//            while (bin.length() < n)
//                bin = "0" + bin;
//
//            System.out.println(bin);
//            choices.add(form);
//        }
//        System.out.println(choices.size());
//    }
}
