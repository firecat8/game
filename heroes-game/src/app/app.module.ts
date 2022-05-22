import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestRGB } from './test/TestRGB/TestRGB.component';
import { CardsDeskComponent } from './desk/cards-desk/cards-desk.component';
import { PlayersBoardComponent } from './board/players-board/players-board.component';
import { PlaygroundComponent } from './playground/playground.component';
import { PlayerDeskComponent } from './desk/player-desk/player-desk.component';
import { PlayerInfoCardComponent } from './common/player-info-card/player-info-card.component';
import { CommonModule } from '@angular/common';
import { DirectionsCardComponent } from './desk/player-desk/directions-card/directions-card.component';
import { PlaygroundBlockComponent } from './playground/playground-block/playground-block.component';

@NgModule({
  declarations: [
    AppComponent,
    TestRGB, 
    CardsDeskComponent,
    PlayersBoardComponent,
    PlaygroundComponent,
    PlayerDeskComponent,
    PlayerInfoCardComponent,
    DirectionsCardComponent,
    PlaygroundBlockComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
