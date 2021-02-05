import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColorAngularComponent } from './color-angular.component';

describe('ColorAngularComponent', () => {
  let component: ColorAngularComponent;
  let fixture: ComponentFixture<ColorAngularComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColorAngularComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColorAngularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
