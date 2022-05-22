import { Bears } from "./Bears.enum";
import { Drinks } from "./Drinks.enum";

export class Player {
    public name?: string;
    public bear?: Bears;
    public drink?: Drinks;
    public drinksCount?: number;

    constructor(name: string, bear: Bears, drink: Drinks, drinksCount: number) {
        this.name = name;
        this.bear = bear;
        this. drink = drink;
        this.drinksCount = drinksCount;
    }
}
