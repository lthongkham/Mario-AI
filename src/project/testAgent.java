package project;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioTimer;
import engine.helper.MarioActions;
import engine.sprites.Mario;

public class testAgent implements MarioAgent {
    private int turn;
    private ArrayList<boolean[]> choices;
   // private MarioTimer timertest;


    public void initialize(MarioForwardModel model, MarioTimer timer){
        turn =0;
       // timertest = new MarioTimer(200);
        choices = new ArrayList<>();
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, true});
        choices.add(new boolean[]{false, false, false, false, false});
    }
    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
        turn += 1;
       // timertest = new MarioTimer(200);
        return choices.get((turn%9));
    }

    @Override
    public String getAgentName() {
        return "TestAgent";
    }
}
