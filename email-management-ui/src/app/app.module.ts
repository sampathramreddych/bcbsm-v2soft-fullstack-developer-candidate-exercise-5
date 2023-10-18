import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { EmailDetailsListComponent } from './email-details-list/email-details-list.component';
import { EmailDetailsService } from './service/email-service.service';
import { EmailDetailsFormComponent } from './email-details-form/email-details-form.component';
import { FormsModule } from '@angular/forms';
import { FileNamePipe } from './file.pipe';
import { SortableHeaderDirective } from './sortable-header.directive';

@NgModule({
  declarations: [
    AppComponent,
    EmailDetailsListComponent,
    EmailDetailsFormComponent,
    FileNamePipe,
    SortableHeaderDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EmailDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
