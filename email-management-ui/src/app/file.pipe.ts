import { Pipe, PipeTransform } from '@angular/core';
import { EmailDetailsService } from './service/email-service.service';
import { EmailDetails } from './model/email-details';

@Pipe({ name: 'fileName' })
export class FileNamePipe implements PipeTransform {

  emailDetails: EmailDetails[] = [];

  constructor(private emailDetailsService:EmailDetailsService){

  }

  ngOnInit() {
    this.emailDetailsService.findAll().subscribe(data => {
      console.log('EmailDetailsListComponent data is'+data);
      this.emailDetails = data;
    });
  }


  transform(values: EmailDetails[], filter: string): EmailDetails[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    return values.filter((value: EmailDetails) => {
      const nameFound =
        value.fileName.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const recipientEmailIdFound =
        value.recipientEmailId.toLowerCase().indexOf(filter.toLowerCase()) !== -1;


      if (nameFound || recipientEmailIdFound) {
        return value;
      }else{
        return false;
      }
    });
  }
}