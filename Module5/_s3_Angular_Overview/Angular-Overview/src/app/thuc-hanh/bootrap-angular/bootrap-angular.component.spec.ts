import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BootrapAngularComponent } from './bootrap-angular.component';

describe('BootrapAngularComponent', () => {
  let component: BootrapAngularComponent;
  let fixture: ComponentFixture<BootrapAngularComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BootrapAngularComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BootrapAngularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
