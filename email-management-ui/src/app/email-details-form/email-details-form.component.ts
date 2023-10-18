import { Component } from '@angular/core';
import { EmailDetails } from '../model/email-details';
import { EmailDetailsService } from '../service/email-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-email-details-form',
  templateUrl: './email-details-form.component.html',
  styleUrls: ['./email-details-form.component.css']
})
export class EmailDetailsFormComponent {
  emailDetails: EmailDetails;
  fileToUpload!: File;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private emailDetailsService: EmailDetailsService) {
    this.emailDetails = new EmailDetails();
  }

  selectFile(event: any) {
    console.log('EmailDetailsFormComponent.selectFile');
    this.fileToUpload = event.target.files.item(0);
  }

  uploadFile() {
    console.log('EmailDetailsFormComponent.onSubmit');
    this.emailDetailsService.sendEmail(this.fileToUpload).subscribe(result => this.gotoEmailDetailsList());
  }

  gotoEmailDetailsList() {
    this.router.navigate(['/list']);
  }
}
