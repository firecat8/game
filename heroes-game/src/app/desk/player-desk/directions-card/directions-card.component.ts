import { Component, Input } from '@angular/core';
import { Directions } from '../../../common/domain/Directions.enum';

@Component({
  selector: 'directions-card',
  templateUrl: './directions-card.component.html',
  styleUrls: ['./directions-card.component.scss']
})
export class DirectionsCardComponent {

  @Input() isAttackCard: boolean = false;
  @Input() directions: Directions[] = [Directions.EAST, Directions.NORTH, Directions.NORTH_WEST];

  public hasDirection(d: string): boolean {
    for (let i = 0; i < this.directions.length; i++) {
      const element = this.directions[i];
      if (this.directions[i].toString() === d)
        return true;
    }
    return false;
  }
}

