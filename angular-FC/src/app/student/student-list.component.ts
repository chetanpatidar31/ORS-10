import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';
import { BaseListCtl } from '../base-list.component';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent extends BaseListCtl {

  constructor(locator: ServiceLocatorService, route: ActivatedRoute) {
    super(locator.endpoints.STUDENT, locator, route);
  }

}
