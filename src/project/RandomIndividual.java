package project;

import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioTimer;

import java.util.ArrayList;
import java.util.Random;


//Creates a Random Individual with a random length set of  random actions

public class RandomIndividual implements MarioAgent {
    private int length;
    private Random rnd;
    private ArrayList<boolean[]> choices;

    @Override
    public void initialize(MarioForwardModel model, MarioTimer timer) {
        rnd = new Random();
        length= rnd.nextInt(100);
        choices = new ArrayList<>();

        for (int i = 0; i<length; i++) {
            choices.add(RandomAction());
        }
    }

    public boolean[] RandomAction(){
        boolean[] res = new boolean[5];
        for (int i=0;i<5;i++){
            if ((rnd.nextInt(2)) == 0) {
                res[i]= false;
            } else {
                res[i] = true;
            }
        }
        return res;
    }

    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
        return choices.get(rnd.nextInt(choices.size()));
    }

    @Override
    public String getAgentName() {
        return "RandomIndividual";
    }
}
