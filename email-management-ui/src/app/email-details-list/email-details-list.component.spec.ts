import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailDetailsListComponent } from './email-details-list.component';

describe('EmailDetailsListComponent', () => {
  let component: EmailDetailsListComponent;
  let fixture: ComponentFixture<EmailDetailsListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmailDetailsListComponent]
    });
    fixture = TestBed.createComponent(EmailDetailsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
