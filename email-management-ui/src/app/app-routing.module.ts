import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmailDetailsListComponent } from './email-details-list/email-details-list.component';
import { EmailDetailsFormComponent } from './email-details-form/email-details-form.component';

const routes: Routes = [
  { path: 'list', component: EmailDetailsListComponent },
  { path: 'sendEmail', component: EmailDetailsFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
