import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'cards-desk',
  templateUrl: './cards-desk.component.html',
  styleUrls: ['./cards-desk.component.scss']
})
export class CardsDeskComponent {
  
  expansionCardsCount: number = 2000;
  movementsCardsCount: number = 2000;
  attackCardsCount: number = 2000;
  surpriseCardsCount: number = 2000;

}
