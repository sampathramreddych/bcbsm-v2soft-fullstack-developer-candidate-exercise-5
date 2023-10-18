import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;
  isAuthenticated: boolean = false;
  userObj:any;

  constructor(private http: HttpClient) {
    this.title = 'Email Management System';
  }


  login() {
    this.http.get('api/files').subscribe(
      data => {
        this.userObj = data;
        this.isAuthenticated = true;
        console.info(this.userObj);
      },
      error => {
        console.error(error);
      }
    );
  }
}
