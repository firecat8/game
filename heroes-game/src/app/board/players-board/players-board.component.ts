import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'players-board',
  templateUrl: './players-board.component.html',
  styleUrls: ['./players-board.component.scss']
})
export class PlayersBoardComponent {
  list = this.getArray(15);

  private getArray(n: number): Array<number> {
    return [...Array(n).keys()]
  }

}
