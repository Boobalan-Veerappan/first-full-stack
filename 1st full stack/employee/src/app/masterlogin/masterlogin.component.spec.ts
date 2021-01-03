import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterloginComponent } from './masterlogin.component';

describe('MasterloginComponent', () => {
  let component: MasterloginComponent;
  let fixture: ComponentFixture<MasterloginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MasterloginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MasterloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
