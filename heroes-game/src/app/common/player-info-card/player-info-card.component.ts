import { Component, Input, OnInit } from '@angular/core';
import { Bears } from '../domain/Bears.enum';
import { Drinks } from '../domain/Drinks.enum';
import { Player } from '../domain/Player';

@Component({
  selector: 'player-info-card',
  templateUrl: './player-info-card.component.html',
  styleUrls: ['./player-info-card.component.scss']
})
export class PlayerInfoCardComponent {

  @Input() player: Player = new Player("Name", Bears.POLAR_BEAR, Drinks.VODKA, 0);

}
