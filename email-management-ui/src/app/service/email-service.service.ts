import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EmailDetails } from '../model/email-details';
import { Observable } from 'rxjs';

@Injectable()
export class EmailDetailsService {



  constructor(private http: HttpClient) {

  }

  public findAll(): Observable<EmailDetails[]> {
   
    return this.http.get<EmailDetails[]>('/api/files/list');
  }

  public downloadAttachment(id: string) {

    console.log('EmailDetailsService.downloadAttachment');


    this.http.get<ArrayBuffer>('api/files/download?id='+id, {responseType: 'blob' as 'json'}).subscribe(
      data => {
        console.info('data is'+data);
        const blob = new Blob([data as BlobPart], { type: 'application/octet-stream' });
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        alert('url is'+url);
        a.click();
      },
      error => {
        console.error(error);
      }
    );


  }

  public sendEmail(file: File) {
    console.log('EmailDetailsService.sendEmail');
    const formData: FormData = new FormData();
    var emailDetails = new EmailDetails();
    emailDetails.fromEmailId = "test@test.com";
    emailDetails.recipientEmailId = "test@test.com";
    emailDetails.uploadUser = "sampath";
    formData.append('file', file);
    formData.append('emailDetails', JSON.stringify(emailDetails));
    return this.http.post<String>('api/files/upload', formData);
  }
}
