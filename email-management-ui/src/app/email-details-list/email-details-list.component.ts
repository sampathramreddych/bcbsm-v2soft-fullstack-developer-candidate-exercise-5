import { Component, QueryList, ViewChildren } from '@angular/core';
import { EmailDetails } from '../model/email-details';
import { EmailDetailsService } from '../service/email-service.service';
import {
  SortableHeaderDirective,
  SortEvent,
  compare,
} from '../sortable-header.directive';


@Component({
  selector: 'app-email-details-list',
  templateUrl: './email-details-list.component.html',
  styleUrls: ['./email-details-list.component.css']
})
export class EmailDetailsListComponent {


  emailDetails: EmailDetails[] = [];
  filter!: string;
  data!: EmailDetails[];

  constructor(private emailDetailsService: EmailDetailsService) {
  }

  ngOnInit() {
    this.emailDetailsService.findAll().subscribe(data => {
      console.log('EmailDetailsListComponent data is'+data);
      this.emailDetails = data;
    });
  }

  download(event: any) {
    console.log("id is"+event.target.id);
    this.emailDetailsService.downloadAttachment(event.target.id);
}





  @ViewChildren(SortableHeaderDirective)
  headers!: QueryList<SortableHeaderDirective>;

  onSort({ column, direction }: SortEvent) {
    // resetting other headers
    this.headers.forEach((header) => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });


    if (direction === '' || column === '') {
      this.emailDetails = this.data;
    } else {
      this.emailDetails = [...this.data].sort((a, b) => {
        const res = compare(a[column], b[column]);
        return direction === 'asc' ? res : -res;
      });
    }
  }
}
