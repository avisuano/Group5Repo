import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewforumpostComponent } from './newforumpost.component';

describe('NewforumpostComponent', () => {
  let component: NewforumpostComponent;
  let fixture: ComponentFixture<NewforumpostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewforumpostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewforumpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
