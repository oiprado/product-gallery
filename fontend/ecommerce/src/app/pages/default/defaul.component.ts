
import { Component, OnInit, Input } from '@angular/core';
import { ProductService } from 'src/app/shared/services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'default',
  template: ''
})
export class DefaultComponent implements OnInit {
    
    constructor(private _Router: Router) { }

    ngOnInit(): void {
        this._Router.navigate(['/list'], { queryParams: { page: 0, size:10, sort: "name", direction: "asc"} });
    }
}
    