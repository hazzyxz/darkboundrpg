package game;

import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class ChooseClassScreen implements Screen {
    private Screen returnScreen;
    private Creature player;
    private int xCenter = 45;
    private boolean isMaidenless = true;
    static int classChoice;
    AsciiArtDisplayer classAscii = new AsciiArtDisplayer();
    public static int worldCount = 0;



    public ChooseClassScreen() {
        //this.player = player;
    }

    // length 89(x)
    // height 50(y)
    //use https://textpaint.net to design ascii art
    @Override
    public void displayOutput(AsciiPanel terminal) {
        // Display the class selection options and instructions
        // name, health, mana, phyatt, magatt, phydef, magdef
        terminal.clear();

        //5,20,40,20,5
        String caption = "Chooseth thy Starting Class O' wise Hero:";
        terminal.write(caption,xCenter-caption.length()/2 ,2);

        int x = 5;
        int y = 5;
        terminal.write("[1] WARRIOR",x+7-2,y+11);
        String[] warrior = ArchetypeLoader.loadArchetype(1);
        displayClassStat(warrior,x,y, "/asciiArt/warriorAscii.txt",terminal);
        //19 x, 10 y


        x = 50;
        y = 5;
        terminal.write("[2] MAGE",x+9-2,y+11);
        String[] mage = ArchetypeLoader.loadArchetype(2);
        displayClassStat(mage,x,y, "/asciiArt/mageAscii.txt",terminal);

        x = 5;
        y = 20;
        terminal.write("[3] ROGUE",x+8-2,y+11);
        String[] rogue = ArchetypeLoader.loadArchetype(3);
        displayClassStat(rogue,x,y, "/asciiArt/rogueAscii.txt",terminal);

        x = 50;
        y = 20;
        terminal.write("[4] PALADIN",x+7-2,y+11);
        String[] paladin = ArchetypeLoader.loadArchetype(4);
        displayClassStat(paladin,x,y, "/asciiArt/paladinAscii.txt",terminal);

        x = 27;
        y = 35;
        terminal.write("[5] ARCHER",x+8-2,y+11);
        String[] archer = ArchetypeLoader.loadArchetype(5);
        displayClassStat(archer,x,y, "/asciiArt/archerAscii.txt",terminal);

        /*
        int y = 1;
        terminal.write("Choose Your Class:",xCenter, y++);
        terminal.write("[1] Warrior",xCenter, y++);
        terminal.write("[2] Mage",xCenter, y++);
        terminal.write("[3] Rogue",xCenter, y++);
        terminal.write("[4] Paladin",xCenter, y++);
        terminal.write("[5] Archer",xCenter, y++);
        terminal.write("",xCenter, y++);
        terminal.write("Select a class",xCenter, y++);
         */

    }

    private void displayClassStat(String[] classStats, int x, int y, String filePath, AsciiPanel terminal){
        displayBox(x,y,terminal);
        classAscii.displayAsciiArtFromFile(x+1,y, filePath, terminal);

        y = y+1;
        terminal.write(" Health: ", x+20+1, y, AsciiPanel.brightRed);
        terminal.write(classStats[1], x+20+1+9, y++, AsciiPanel.brightWhite);

        terminal.write(" Mana: ", x+20+1, y, AsciiPanel.brightCyan);
        terminal.write(classStats[3], x+20+1+7, y++, AsciiPanel.brightWhite);

        terminal.write("" , x+20+1, y++);
        terminal.write(" Physical: ", x+20+1, y);
        terminal.write(classStats[5], x+20+1+11, y++, AsciiPanel.brightWhite);
        terminal.write(" Magical: ", x+20+1, y);
        terminal.write(classStats[6], x+20+1+10, y++, AsciiPanel.brightWhite);
        terminal.write(" Armour: ", x+20+1, y);
        terminal.write(classStats[7], x+20+1+9, y++, AsciiPanel.brightWhite);
        terminal.write(" Barrier: ", x+20+1, y);
        terminal.write(classStats[8], x+20+1+10, y, AsciiPanel.brightWhite);

    }

    private void displayBox(int x, int y,AsciiPanel terminal){
        int width = 20;
        int height = 10;
        for(int i=0; i<height; i++)
            terminal.write('|',x,y+i, AsciiPanel.yellow);
        for(int i=1; i<=width; i++)
            terminal.write('_',x+i,y-1+height, AsciiPanel.yellow);
        for(int i=1; i<width; i++)
            terminal.write('_',x+i,y-1, AsciiPanel.yellow);
        for(int i=0; i<height; i++)
            terminal.write('|',x+width,y+i, AsciiPanel.yellow);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        //Scanner in = new Scanner(System.in);
        //Choice choice = new Choice();


        int keyCode = key.getKeyCode();

        if (keyCode == KeyEvent.VK_1) {
            // Set the player class to Warrior and return to the previous screen
            classChoice = 1;
        } else if (keyCode == KeyEvent.VK_2) {
            // Set the player class to Mage and return to the previous screen
            classChoice = 2;
        } else if (keyCode == KeyEvent.VK_3) {
            // Set the player class to rogue and return to the previous screen
            classChoice = 3;
        } else if (keyCode == KeyEvent.VK_4) {
            // Set the player class to archer and return to the previous screen
            classChoice = 4;
        } else if (keyCode == KeyEvent.VK_5) {
            // Set the player class to paladin and return to the previous screen
            classChoice = 5;
        } else if (keyCode == KeyEvent.VK_ESCAPE) {
            return new StartScreen();
        }
        else{
            return this;
        }

        worldCount = 0;

        //inititate playscreen (world)
        return new PlayScreen();


    }



}

