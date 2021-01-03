import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherEmployeeComponent } from './other-employee.component';

describe('OtherEmployeeComponent', () => {
  let component: OtherEmployeeComponent;
  let fixture: ComponentFixture<OtherEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
