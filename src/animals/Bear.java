package animals;

import diet.Omnivore;
import mobility.Point;
import utilities.MessageUtility;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

/**
 * @author Gleb Tcivie & Orel Dandeker
 * @Date 5/4/22
 */
public class Bear extends Animal{

    private String furColor;
    public static String[] COLORS = {"BLACK","WHITE","GRAY"};
    private static final String PICTURE_PATH = "src/graphics/assignment2_pictures/bea_n_1.png";

    /**
     * Ctor
     * @param name Name of the bear
     */
    public Bear(String name) {
        super(name, new Point(100,5));
        MessageUtility.logConstractor("Bear", name);
        setWeight(308.2);
        setFurColor("GRAY");
        setDiet(new Omnivore());
    }

    /**
     * Ctor
     * @param name Name of the bear
     * @param x x point
     * @param y y point
     */
    public Bear(String name, int x, int y) {
        super(name, new Point(x,y));
        MessageUtility.logConstractor("Bear", name);
        setWeight(308.2);
        setFurColor("GRAY");
        setDiet(new Omnivore());
    }

    /**
     * Ctor
     * @param name Name of the bear
     * @param color Color of the bear from the list of available colors : {"BLACK","WHITE","GRAY"}
     */
    public Bear(String name, String color) {
        super(name, new Point(100,5));
        MessageUtility.logConstractor("Bear", name);
        setWeight(308.2);
        setFurColor(color);
        setDiet(new Omnivore());
    }

    /**
     * Changes the fur color of the bear
     * @param color Color from the list of available colors {"BLACK","WHITE","GRAY"}
     * @return True if the operation was successful / False otherwise
     */
    public boolean setFurColor(String color) {
        boolean isSuccess = (Arrays.asList(COLORS).contains(color));
        if (isSuccess)
            this.furColor = color;
        else
            this.furColor = "GRAY";
        fireLog("logSetter","setFurColor",color,isSuccess);
        return isSuccess;
    }

    /**
     * Returns the current fur color
     * @return Fur color of the bear
     */
    public String getFurColor() {
        fireLog("logGetter", "getFurColor", this.furColor);
        return this.furColor;
    }


    @Override
    public void makeSound() {
        roar();
    } //TODO: find better approach

    /**
     * Plays the roar sound with the help of the Firelog method in Animal
     */
    public void roar() {
        fireLog("logSound","Stands on its hind legs, roars and scratches its belly");
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Creates the card for the ctor of the animal
     * @return Card with the relevant data added
     */
    public static JPanel createCard() {
        JPanel card = Animal.createPanel(PICTURE_PATH);

        JPanel additionalParams = new JPanel();
        additionalParams.setBorder(BorderFactory.createTitledBorder("Additional parameters"));
        additionalParams.setLayout(new GridLayout(1,2));
        additionalParams.add(new JLabel("Fur Color:"));
        additionalParams.add(new JComboBox<String>(COLORS));

        card.add(additionalParams,BorderLayout.EAST);
        return card;
    }
}
