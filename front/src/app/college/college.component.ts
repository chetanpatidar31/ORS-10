import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-college',
  templateUrl: './college.component.html'
 
})
export class CollegeComponent extends BaseCtl {

  constructor(public loactor: ServiceLocatorService, route: ActivatedRoute) {
    super(loactor.endpoints.COLLEGE, loactor, route);
  }

}
