package project;

import java.util.ArrayList;
import java.util.Random;

import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioTimer;
import engine.helper.MarioActions;

public class testAgent implements MarioAgent {
    private int turn;
    private ArrayList<boolean[]> choices;

    public void initialize(MarioForwardModel model, MarioTimer timer){
        turn =0;
        choices = new ArrayList<>();
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, false});
    }
    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
        turn += 1;
        System.out.println(turn%2);
        return choices.get((turn%2));
    }

    @Override
    public String getAgentName() {
        return "TestAgent";
    }
}
