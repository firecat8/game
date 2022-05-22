import { Bears } from "./Bears.enum";
import { Drinks } from "./Drinks.enum";

export class PlaygroundElement {

    public row: number = 0;
    public column: number = 0;
    public drink?: Drinks;
    public bear?: Bears;

    constructor(row: number = 0, column: number = 0, drink?: Drinks, bear?: Bears) {
        this.row=row;
        this.column=column;
        this.drink=drink;
        this.bear=bear;
    }
}
