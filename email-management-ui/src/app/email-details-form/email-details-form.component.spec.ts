import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailDetailsFormComponent } from './email-details-form.component';

describe('EmailDetailsFormComponent', () => {
  let component: EmailDetailsFormComponent;
  let fixture: ComponentFixture<EmailDetailsFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmailDetailsFormComponent]
    });
    fixture = TestBed.createComponent(EmailDetailsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
