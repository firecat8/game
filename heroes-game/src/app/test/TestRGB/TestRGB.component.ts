import { Component } from '@angular/core';

@Component({
  selector: 'rgb',
  templateUrl: './TestRGB.component.html',
  styleUrls: ['./TestRGB.component.scss']
})
export class TestRGB {
  rows = this.getArray(12);
  cols = this.getArray(3);
  private colorsCount = 256 * 256 * 256 - 1;
  private size = this.rows.length * this.cols.length;
  private diff = Math.trunc(this.colorsCount / this.size);


  /* var rgbTotal = red * 65536 + green * 256 + blue;*/
  public getColor(r: number, c: number) {
    var color = this.makeRGBColor(r, c);
    return 'rgb(' + color.R + ',' + color.G + ',' + color.B + ')';
  }

  public getText(r: number, c: number) {
    var color = this.makeRGBColor(r, c);
    return 'R:' + color.R + ' G:' + color.G + ' B:' + color.B;
  }

  private makeRGBColor(r: number, c: number) {
    const elemNumber = r * this.cols.length + c + 1;
    const color = this.diff * elemNumber;
    return {
      R: Math.trunc(color / 65536),
      G: Math.trunc((color % 65536) / 256),
      B: Math.trunc(color % 256)
    }
  }

  private getArray(n: number): Array<number> {
    return [...Array(n).keys()]
  }
}
