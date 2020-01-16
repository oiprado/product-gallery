
import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../../services/category.service'
@Component({
  selector: 'header-section',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


    constructor(private _CategoryService: CategoryService) { }

  categories;

    ngOnInit(): void {
        this._CategoryService.getCategoryList().subscribe((response: any) => {
            this.categories = response;
        })        
    }
}