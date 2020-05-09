package project;

import agents.random.Agent;
import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioResult;
import engine.core.MarioTimer;

import java.util.ArrayList;

public class Individual implements MarioAgent{
    private int turn;
    private Genes gene;
    private float fitness;

    @Override
    public void initialize(MarioForwardModel model, MarioTimer timer){
        turn =-1;



    }
    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
        turn += 1;
        boolean[] action = gene.getMove(turn);
        return action;
    }
    @Override
    public String getAgentName() {
        return "Individual";
    }


//    public void setFitness(){
//        MarioResult result = game.runGame(new RandomIndividual(), getLevel("./levels/original/lvl-1.txt"), 20, 0, true);
//        this.fitness = result.getCompletionPercentage();
//    }

}
