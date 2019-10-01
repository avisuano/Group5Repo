import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VetdecComponent } from './vetdec.component';

describe('VetdecComponent', () => {
  let component: VetdecComponent;
  let fixture: ComponentFixture<VetdecComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VetdecComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VetdecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
