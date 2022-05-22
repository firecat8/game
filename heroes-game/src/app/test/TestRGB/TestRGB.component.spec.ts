/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { TestRGBComponent } from './TestRGB.component';

describe('TestRGBComponent', () => {
  let component: TestRGBComponent;
  let fixture: ComponentFixture<TestRGBComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestRGBComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestRGBComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
