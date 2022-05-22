import { Component, Input, OnInit } from '@angular/core';
import { PlaygroundElement } from 'src/app/common/domain/PlaygroundElement';

@Component({
  selector: 'pg-block',
  templateUrl: './playground-block.component.html',
  styleUrls: ['./playground-block.component.scss']
})
export class PlaygroundBlockComponent {
  @Input() element?: PlaygroundElement;
  @Input() isEven: boolean = false;

  public getBearClass(): string {
    return this.element?.bear ? this.element?.bear.toString() : "";
  }
  public getDrinkClass(): string {
    return this.element?.drink ? this.element?.drink.toString() : "";
  }
  public hasBear(): boolean {
    return this.element?.bear != null;
  }
  public hasDrink(): boolean {
    return this.element?.drink != null;
  }
}
