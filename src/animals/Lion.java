package animals;

import diet.Carnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

public class Lion extends Animal{
    private int scarCount;

    public Lion(String name) {
        super(name, new Point(20,0));
        MessageUtility.logConstractor("Lion", name);
        setWeight(408.20);
        setDiet(new Carnivore());
    }

    public int getScarCount() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getScarCount", this.scarCount);
        return this.scarCount;
    }

    public boolean setScarCount(int scarCount) {
        boolean isSuccess = (scarCount >= 0);
        if (isSuccess)
            this.scarCount = scarCount;
        else
            this.scarCount = 0;
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setScarCount", scarCount, isSuccess);
        return isSuccess;
    }

    public void roar() {

    }

    /**
     * Gets the food type
     *
     * @return type of food from the Enum
     */
    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }
}
