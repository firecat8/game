import { Component } from '@angular/core';
import { Bears } from '../common/domain/Bears.enum';
import { Drinks } from '../common/domain/Drinks.enum';
import { PlaygroundElement } from '../common/domain/PlaygroundElement';

@Component({
  selector: 'playground',
  templateUrl: './playground.component.html',
  styleUrls: ['./playground.component.scss']
})
export class PlaygroundComponent {

  rows = this.getArray(10);
  cols = this.getArray(15);
  elems: PlaygroundElement[] = this.getElements();

  private getArray(n: number): Array<number> {
    return [...Array(n).keys()];
  }
  private getElements(): Array<PlaygroundElement> {
    var elements: PlaygroundElement[] = [];
    let ci = 0;
    for (let d in Drinks) {
      elements.push(new PlaygroundElement(0, ci, Drinks[d as keyof typeof Drinks]));
      ci++;
    }
    ci = 0;
    for (let b in Bears) {
      elements.push(new PlaygroundElement(1, ci, undefined, Bears[b as keyof typeof Bears]));
      ci++;
    }
    elements.push(new PlaygroundElement(2, 2));
    return elements;
  }

  public getElement(r: number, c: number): PlaygroundElement | undefined {
    return this.elems.find(e => e.row === r && e.column === c);
  }

  public isEven(r: number, c: number): boolean {
    return (r * this.cols.length + c + 1) % 2 === 0;
  }
}
