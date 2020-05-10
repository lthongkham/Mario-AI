package project;

import agents.random.Agent;
import engine.core.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Individual implements MarioAgent{
    private int turn;
    private Genes gene;
    private float fitness;

    public Individual() {
        this.gene = new Genes();
        this.fitness = 0;
    }
    public Individual( Genes gene) {
        this.gene = gene;
        this.fitness = 0;
    }

    // Interface methods
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
//
// Methods for G.A.
//
    public static String getLevel(String filepath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
        }
        return content;
    }



    public void setFitness(){
        MarioGame game = new MarioGame();
        MarioResult result = game.runGame(this, getLevel("./levels/original/lvl-1.txt"), 20, 0, false);
        float bonus = 0;
        if (result.getGameStatus().toString() == "WIN"){
            bonus = 10000000;
        }
        this.fitness = (result.getCompletionPercentage()*1000 + 5*result.getMaxXJump()+ 5*result.getCurrentCoins() + result.getKillsTotal() + result.getMarioMode() +bonus);
    }

    public static Individual[] crossover(Individual parent1, Individual parent2){
        // i set 7 break points.. i think it's a good solution to take a set of movements
        ArrayList<Integer> choices1 = new ArrayList<>();
        ArrayList<Integer> choices2 = new ArrayList<>();
        for (int j=1;j<8;j++)
            for (int i=0;i<100;i++){
                if (j%2 == 0) {
                    choices1.add(parent2.gene.getChoices(i * j));
                    choices2.add(parent1.gene.getChoices(i * j));
                } else {
                    choices1.add(parent1.gene.getChoices(i * j));
                    choices2.add(parent2.gene.getChoices(i * j));
                }
            }
        return(new Individual[]{new Individual(new Genes(choices1)), new Individual(new Genes(choices2))});
    }

    public static Individual mutate(Individual ind, double rate){
        for (int i=0;i<700;i++){
            double r = Math.random();
            if (r < rate){
                double randomDouble = Math.random();
                randomDouble = randomDouble * 30 + 1;
                int randomInt = (int) randomDouble;
                ind.gene.setChoice(i,randomInt);
            }
        }
        ind.setFitness();
        return ind;

    }

    public ArrayList<Individual> Initialise_Population(int n){
        ArrayList<Individual> population = new ArrayList<>();
        for (int i =0;i<n;i++){
            Individual ind = new Individual();
            ind.setFitness();
            population.add(new Individual());
        }
        return(population);
    }

    public static ArrayList<Individual> RunRound(ArrayList<Individual> population) throws IOException {
        ArrayList<Individual> new_population = new ArrayList<>();
        Individual best = population.get(0);
        float best_fitness = best.fitness;
        int best_rank = 0;
        //select best
        for (int i=1;i<20;i++){
            if (population.get(i).fitness > best_fitness){
                best = population.get(i);
                best_fitness = best.fitness;
                best_rank = i;
            }
        }
        new_population.add(best);
        System.out.println("Current best:");
        System.out.println(best_fitness);

        population.remove(best_rank);

        best = population.get(0);
        best_fitness = best.fitness;
        best_rank = 0;
        //select best
        for (int i=1;i<19;i++){
            if (population.get(i).fitness > best_fitness){
                best = population.get(i);
                best_fitness = best.fitness;
                best_rank = i;
            }
        }
        new_population.add(best);
        System.out.println("Current 2nd best:");
        System.out.println(best_fitness);

        population.remove(best_rank);

        Individual worst = population.get(0);
        float worst_fitness = worst.fitness;
        int worst_rank = 0;
        //select worst
        for (int i=1;i<18;i++){
            if (population.get(i).fitness < worst_fitness){
                worst = population.get(i);
                worst_fitness = worst.fitness;
                worst_rank = i;
            }
        }
        population.remove(worst_rank);

        worst = population.get(0);
        worst_fitness = worst.fitness;
        worst_rank = 0;
        //select worst
        for (int i=1;i<17;i++){
            if (population.get(i).fitness < worst_fitness){
                worst = population.get(i);
                worst_fitness = worst.fitness;
                worst_rank = i;
            }
        }
        population.remove(worst_rank);

        Individual[] children1 = crossover(population.get(0),population.get(1));
        Individual[] children2 = crossover(population.get(2),population.get(3));
        Individual[] children3 = crossover(population.get(4),population.get(5));
        Individual[] children4 = crossover(population.get(6),population.get(7));
        Individual[] children5 = crossover(population.get(8),population.get(9));
        Individual[] children6 = crossover(population.get(10),population.get(11));
        Individual[] children7 = crossover(population.get(12),population.get(13));
        Individual[] children8 = crossover(population.get(14),population.get(15));

        new_population.add(mutate(children1[0],0.2));
        new_population.add(mutate(children1[1],0.2));
        new_population.add(mutate(children2[0],0.2));
        new_population.add(mutate(children2[1],0.2));
        new_population.add(mutate(children3[0],0.2));
        new_population.add(mutate(children3[1],0.2));
        new_population.add(mutate(children4[0],0.2));
        new_population.add(mutate(children4[1],0.2));
        new_population.add(mutate(children5[0],0.2));
        new_population.add(mutate(children5[1],0.2));
        new_population.add(mutate(children6[0],0.2));
        new_population.add(mutate(children6[1],0.2));
        new_population.add(mutate(children7[0],0.2));
        new_population.add(mutate(children7[1],0.2));
        new_population.add(mutate(children8[0],0.2));
        new_population.add(mutate(children8[1],0.2));

        Individual n1 = new Individual();
        Individual n2 = new Individual();
        n1.setFitness();
        n2.setFitness();

        new_population.add(n1);
        new_population.add(n2);
        SavePopulation(new_population);
        return(new_population);
    }

    public static void SavePopulation(ArrayList<Individual> population) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        String file_name = String.valueOf(now);

        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/Happpyyyyyyy/Mario-AI/Exports/Pop/" +file_name));
        writer.write("Population Info");
        writer.append('\n');

        for (int i=0;i<20;i++){
            writer.append(".......................");
            writer.append('\n');
            writer.append("Genes: ");
            writer.append(population.get(i).gene.toString());
            writer.append('\n');
            writer.append("Fitness:");
            writer.append(String.valueOf(population.get(i).fitness));
            writer.append('\n');
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Individual> population = new ArrayList<>();
        for (int i =0;i<20;i++){
            Individual ind = new Individual();
            ind.setFitness();
            population.add(ind);
        }
        SavePopulation(population);

        for (int i = 0;i<100;i++){
            population = RunRound(population);
            System.out.println(i);
        }



        Individual best = population.get(0);
        float best_fitness = best.fitness;
        int best_rank = 0;
        for (int i=1;i<20;i++) {
            if (population.get(i).fitness > best_fitness) {
                best = population.get(i);
                best_fitness = best.fitness;
                best_rank = i;
            }
        }
        MarioGame game = new MarioGame();
        MarioResult result = game.runGame(population.get(best_rank), getLevel("./levels/original/lvl-1.txt"), 20, 0, true);

    }

}
