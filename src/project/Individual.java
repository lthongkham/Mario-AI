package project;

import agents.random.Agent;
import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioResult;

public class Individual {
    private MarioAgent Indvidual;
    private float fitness;

    public void InitializeInd(){
        this.Indvidual = new RandomIndividual();
    }

    public void setFitness(){
        MarioResult result = game.runGame(new RandomIndividual(), getLevel("./levels/original/lvl-1.txt"), 20, 0, true);
        this.fitness = result.getCompletionPercentage();
    }

}
